package com.project.spring.core.validator.impl.session;

import com.project.spring.common.model.enumeration.SpringErrorCodeEnum;
import com.project.spring.common.util.ParamChecker;
import com.project.spring.core.model.request.BaseRequest;
import com.project.spring.core.model.request.session.SessionRefreshRequest;
import com.project.spring.core.validator.BaseValidator;

public class SessionRefreshValidator implements BaseValidator {
    @Override
    public void validate(BaseRequest request) throws Exception {
        ParamChecker.isNotNull(request, "request", SpringErrorCodeEnum.PARAM_ILLEGAL);
        ParamChecker.isExpected(request instanceof SessionRefreshRequest, "request", SpringErrorCodeEnum.PARAM_ILLEGAL);

        SessionRefreshRequest refreshRequest = (SessionRefreshRequest) request;
        ParamChecker.isNotBlank(refreshRequest.getSessionId(), "sessionId", SpringErrorCodeEnum.PARAM_ILLEGAL);
    }
}
