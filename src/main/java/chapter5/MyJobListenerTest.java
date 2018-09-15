package chapter5;

import chapter3.DumbJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.KeyMatcher;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * * @Author: cuixin
 * * @Date: 2018/9/12 13:31
 */
public class MyJobListenerTest {
    public static void main(String args[]) throws SchedulerException {
        JobDetail jobDetail = newJob(DumbJob.class)
                .withIdentity("job1", "group1")
                .usingJobData("jobSays", "Hello　World!")
                .usingJobData("myFloatValue", 3.141f)
                .build();
        Trigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .withSchedule(cronSchedule("0/2 * * * * ?"))
                .build();
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
//        scheduler.getListenerManager().addJobListener(new MyJobListener(), KeyMatcher.keyEquals(new JobKey("job1", "group1")));
//        scheduler.getListenerManager().addTriggerListener(new MyTriggerListener(), KeyMatcher.keyEquals(new TriggerKey("trigger1", "group1")));
        scheduler.getListenerManager().addSchedulerListener(new MySchedulerListener());
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }
}
