package org.example.springbootweb.quartz;

import org.example.springbootweb.component.VerifyEmail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class EmailJob extends QuartzJobBean {

    private VerifyEmail verifyEmail;

    @Override
    protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
        try {
            verifyEmail.executeTask();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setVerifyEmail(VerifyEmail verifyEmail) {
        this.verifyEmail = verifyEmail;
    }
}
