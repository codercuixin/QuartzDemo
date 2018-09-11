package chapter3;

import org.quartz.*;
import org.quartz.ee.jmx.jboss.JBoss4RMIRemoteMBeanScheduler;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;

import java.lang.annotation.Annotation;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * * @Author: cuixin
 * * @Date: 2018/9/11 14:57
 */
public class QuartzTest3 {
    public static void main(String args[]) throws SchedulerException {
        ;
//        testJob(DumbJob.class);
//      testJob(DumbJobWithMergedJobDataMap.class);
//      testJob(DumbJobWithInject.class);
        testDisallowConcurrent(DumbJob.class);
    }

    public static void testJob(Class<? extends Job> job) throws SchedulerException {
        JobDetail jobDetail = newJob(job)
                .withIdentity("myJob", "group1")
                .usingJobData("jobSays", "Hello　World!")
                .usingJobData("myFloatValue", 3.141f)
                .build();
        Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startNow()
                .withSchedule(simpleSchedule().withIntervalInSeconds(2).repeatForever())
                .usingJobData("jobSays", "Hello　Quartz!")
                .usingJobData("myFloatValue", 4.141f)
                .build();
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }
    //TODO 测试
    public static void testDisallowConcurrent(Class<? extends Job> job) throws SchedulerException {
        if(job.isAnnotationPresent(DisallowConcurrentExecution.class)){
            JobDetail jobDetail = newJob(job)
                    .withIdentity("myJob1", "group1")
                    .usingJobData("jobSays", "Hello　World!")
                    .usingJobData("myFloatValue", 3.141f)
                    .build();
            Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startNow()
                    .withSchedule(simpleSchedule().withIntervalInSeconds(2).repeatForever())
                    .usingJobData("jobSays", "Hello　Quartz!")
                    .usingJobData("myFloatValue", 4.141f)
                    .build();

            JobDetail jobDetail2 = newJob(job)
                    .withIdentity("myJob2", "group2")
                    .usingJobData("jobSays", "Hello　World!")
                    .usingJobData("myFloatValue", 3.141f)
                    .build();
            Trigger trigger2 = newTrigger().withIdentity("trigger2", "group2").startNow()
                    .withSchedule(simpleSchedule().withIntervalInSeconds(2).repeatForever())
                    .usingJobData("jobSays", "Hello　Quartz!")
                    .usingJobData("myFloatValue", 4.141f)
                    .build();
            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();

            Scheduler scheduler2 = new StdSchedulerFactory().getScheduler();
            scheduler2.scheduleJob(jobDetail2, trigger2);
            scheduler2.start();
        }
    }

}
