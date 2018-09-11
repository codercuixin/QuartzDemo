package chapter3;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * * @Author: cuixin
 * * @Date: 2018/9/11 18:29
 */
public class DumbJobWithInject implements Job{
    private String jobSays;
    private float myFloatValue;
    //JobFactory会帮我们利用反射进行注入
    public void setJobSays(String jobSays) {
        this.jobSays = jobSays;
    }

    public void setMyFloatValue(float myFloatValue) {
        this.myFloatValue = myFloatValue;
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Instance "+context.getJobDetail().getKey()+" of DumbJob says: "+jobSays+" , val is "+myFloatValue);
    }
}
