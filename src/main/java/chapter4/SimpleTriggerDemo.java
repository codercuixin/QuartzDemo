package chapter4;

import chapter3.DumbJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

import static org.quartz.SimpleScheduleBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.JobBuilder.*;
/**
 * * @Author: cuixin
 * * @Date: 2018/9/11 19:59
 */
public class SimpleTriggerDemo {
    public static void main(String args[]) throws SchedulerException {
        JobDetail jobDetail = newJob(DumbJob.class)
                .withIdentity("job1", "group1")
                .usingJobData("jobSays", "Hello　World!")
                .usingJobData("myFloatValue", 3.141f)
                .build();
        SimpleTrigger trigger =(SimpleTrigger) newTrigger()
                .withIdentity("trigger1", "group1")
                .startAt(new Date())
                .withSchedule(simpleSchedule().withIntervalInSeconds(10).repeatForever())
                .forJob("job1", "group1")
                .build();
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }
}
