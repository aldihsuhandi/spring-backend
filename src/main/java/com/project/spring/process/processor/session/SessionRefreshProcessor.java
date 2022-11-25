package com.project.spring.process.processor.session;

import com.project.spring.common.model.exception.SpringException;
import com.project.spring.common.model.viewobject.SessionVO;
import com.project.spring.common.service.SessionService;
import com.project.spring.core.converter.SessionRequestConverter;
import com.project.spring.core.model.request.BaseRequest;
import com.project.spring.core.model.request.session.SessionRefreshRequest;
import com.project.spring.core.model.result.BaseResult;
import com.project.spring.process.processor.BaseProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class SessionRefreshProcessor implements BaseProcessor {

    @Autowired
    @Qualifier("sessionService")
    private SessionService sessionService;

    @Override
    public void doProcess(BaseResult result, BaseRequest request) throws SpringException {
        SessionRefreshRequest refreshRequest = (SessionRefreshRequest) request;
        SessionVO sessionVO = sessionService.query(SessionRequestConverter.
                toInnerRequest(refreshRequest.getSessionId()));

        sessionService.refresh(SessionRequestConverter.
                toInnerRequest(refreshRequest));
    }
}
