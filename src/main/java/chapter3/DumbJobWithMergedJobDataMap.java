package chapter3;

import org.quartz.*;

/**
 * * @Author: cuixin
 * * @Date: 2018/9/11 17:31
 */
public class DumbJobWithMergedJobDataMap implements Job {
    public DumbJobWithMergedJobDataMap(){

    }
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobKey key = context.getJobDetail().getKey();
        JobDataMap dataMap = context.getMergedJobDataMap();
        String jobSays = dataMap.getString("jobSays");
        float myFloatValue = dataMap.getFloat("myFloatValue");
        System.out.println("Instance "+key+" of DumbJob says: "+jobSays+" , val is "+myFloatValue);
    }
}
