package chapter5;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;
import org.quartz.listeners.TriggerListenerSupport;

/**
 * * @Author: cuixin
 * * @Date: 2018/9/12 15:03
 */
public class MyTriggerListener implements TriggerListener {
    @Override
    public String getName() {
        return "myTriggerListener";
    }

    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext context) {
       System.out.println("triggerFired");
    }

    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
        System.out.println("triggerFired");
        return false;
    }

    @Override
    public void triggerMisfired(Trigger trigger) {
       System.out.println("triggerMisfired");
    }

    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext context, Trigger.CompletedExecutionInstruction triggerInstructionCode) {
        System.out.println("triggerComplete");
    }
}
