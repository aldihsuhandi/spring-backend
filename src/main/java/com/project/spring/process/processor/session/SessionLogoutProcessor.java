package com.project.spring.process.processor.session;

import com.project.spring.common.model.exception.SpringException;
import com.project.spring.common.service.SessionService;
import com.project.spring.core.converter.SessionRequestConverter;
import com.project.spring.core.model.request.BaseRequest;
import com.project.spring.core.model.request.session.SessionLogoutRequest;
import com.project.spring.core.model.result.BaseResult;
import com.project.spring.process.processor.BaseProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class SessionLogoutProcessor implements BaseProcessor {

    @Autowired
    @Qualifier("sessionService")
    private SessionService sessionService;

    @Override
    public void doProcess(BaseResult result, BaseRequest request) throws SpringException {
        SessionLogoutRequest logoutRequest = (SessionLogoutRequest) request;
        sessionService.logout(SessionRequestConverter.toInnerRequest(logoutRequest));
    }
}
