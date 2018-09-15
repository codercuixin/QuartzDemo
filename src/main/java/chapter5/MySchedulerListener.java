package chapter5;

import org.quartz.*;

/**
 * * @Author: cuixin
 * * @Date: 2018/9/12 15:25
 */
public class MySchedulerListener implements SchedulerListener {
    @Override
    public void jobScheduled(Trigger trigger) {
        System.out.println("jobScheduled "+trigger);
    }

    @Override
    public void jobUnscheduled(TriggerKey triggerKey) {
        System.out.println("jobUnscheduled "+triggerKey);
    }

    @Override
    public void triggerFinalized(Trigger trigger) {
        System.out.println("triggerFinalized "+trigger);
    }

    @Override
    public void triggerPaused(TriggerKey triggerKey) {
        System.out.println("triggerPaused "+triggerKey);
    }

    @Override
    public void triggersPaused(String triggerGroup) {
        System.out.println("triggersPaused "+triggerGroup);
    }

    @Override
    public void triggerResumed(TriggerKey triggerKey) {
        System.out.println("triggersPaused "+triggerKey);
    }

    @Override
    public void triggersResumed(String triggerGroup) {
        System.out.println("triggersResumed "+triggerGroup);
    }

    @Override
    public void jobAdded(JobDetail jobDetail) {
        System.out.println("jobAdded "+jobDetail);
    }

    @Override
    public void jobDeleted(JobKey jobKey) {
        System.out.println("jobDeleted "+jobKey);
    }

    @Override
    public void jobPaused(JobKey jobKey) {
        System.out.println("jobPaused "+jobKey);
    }

    @Override
    public void jobsPaused(String jobGroup) {
        System.out.println("jobPaused "+jobGroup);
    }

    @Override
    public void jobResumed(JobKey jobKey) {

    }

    @Override
    public void jobsResumed(String jobGroup) {

    }

    @Override
    public void schedulerError(String msg, SchedulerException cause) {

    }

    @Override
    public void schedulerInStandbyMode() {

    }

    @Override
    public void schedulerStarted() {

    }

    @Override
    public void schedulerStarting() {

    }

    @Override
    public void schedulerShutdown() {

    }

    @Override
    public void schedulerShuttingdown() {

    }

    @Override
    public void schedulingDataCleared() {

    }
}
