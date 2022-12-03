package com.project.spring.common.validator.impl.session;

import com.project.spring.common.model.enumeration.SpringErrorCodeEnum;
import com.project.spring.common.util.ParamChecker;
import com.project.spring.common.validator.BaseValidator;
import com.project.spring.core.model.request.BaseRequest;
import com.project.spring.core.model.request.session.SessionLogoutRequest;

public class SessionLogoutValidator implements BaseValidator {
    @Override
    public void validate(BaseRequest request) throws Exception {
        ParamChecker.isNotNull(request, "request", SpringErrorCodeEnum.PARAM_ILLEGAL);
        ParamChecker.isExpected(request instanceof SessionLogoutRequest, "request", SpringErrorCodeEnum.PARAM_ILLEGAL);

        SessionLogoutRequest logoutRequest = (SessionLogoutRequest) request;
        ParamChecker.isNotBlank(logoutRequest.getSessionId(), "sessionId", SpringErrorCodeEnum.PARAM_ILLEGAL);
    }
}
