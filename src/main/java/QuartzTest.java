import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * * @Author: cuixin
 * * @Date: 2018/9/11 10:29
 */
public class QuartzTest {
    public static void main(String args[]) throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        JobDetail job = newJob(HelloJob.class).withIdentity("job1", "group1").build();
        Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startNow()
                .withSchedule(simpleSchedule().withIntervalInMilliseconds(40).repeatForever())
                .build();
        scheduler.scheduleJob(job, trigger);
        scheduler.start();
    }

    private static class HelloJob implements Job {
        public HelloJob(){

        }
        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {
            System.out.println("Hello Quartz Job");
        }
    }
}
