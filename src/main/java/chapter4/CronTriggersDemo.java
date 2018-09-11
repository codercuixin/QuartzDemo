package chapter4;

import chapter3.DumbJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.CronScheduleBuilder.dailyAtHourAndMinute;
import static org.quartz.CronScheduleBuilder.weeklyOnDayAndHourAndMinute;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.DateBuilder.*;
/**
 * * @Author: cuixin
 * * @Date: 2018/9/11 20:25
 */
public class CronTriggersDemo {
    public static void main(String args[]) throws SchedulerException {
        JobDetail jobDetail = newJob(DumbJob.class)
                .withIdentity("job1", "group1")
                .usingJobData("jobSays", "Hello　World!")
                .usingJobData("myFloatValue", 3.141f)
                .build();
        //每天8点到17点每隔2秒钟执行一次
        Trigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .withSchedule(cronSchedule("0 0/2 8-23 * * ?"))
//                .withSchedule(dailyAtHourAndMinute(20, 36))
//                .withSchedule(weeklyOnDayAndHourAndMinute(DateBuilder.WEDNESDAY, 10, 42))
                .withSchedule(cronSchedule("0 0/2 8-23 * * ?").withMisfireHandlingInstructionFireAndProceed())
                .build();
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();

    }
}
