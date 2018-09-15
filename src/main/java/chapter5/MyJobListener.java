package chapter5;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.listeners.JobListenerSupport;

/**
 * * @Author: cuixin
 * * @Date: 2018/9/12 13:26
 */
public class MyJobListener extends JobListenerSupport {

    @Override
    public String getName() {
        return "myJobListener";
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext context) {
        System.out.println("MyJobListener: jobToBeExecuted");
    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext context) {
        System.out.println("MyJobListener: jobExecutionVetoed");
    }

    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        System.out.println("MyJobListener: jobWasExecuted");
    }
}
