package com.project.spring.process.scheduler.impl;

import com.project.spring.common.model.request.session.SessionUpdateInnerRequest;
import com.project.spring.common.service.SessionService;
import com.project.spring.process.scheduler.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SessionExpiredScheduler implements Scheduler {

    @Autowired
    @Qualifier("sessionService")
    SessionService sessionService;

    @Override
    @Scheduled(fixedRate = 300000)
    public void task() {
        Date currentTime = new Date();
        System.out.printf("session expired scheduler, time: %s\n", currentTime);

        SessionUpdateInnerRequest innerRequest = new SessionUpdateInnerRequest();
        innerRequest.setSessionDt(currentTime);
        innerRequest.setGmtModified(currentTime);

        try {
            sessionService.deactivate(innerRequest);
        } catch (Exception e) {
            System.out.printf("session expired scheduler, exception: %s\n", e.getMessage());
        }
    }
}
