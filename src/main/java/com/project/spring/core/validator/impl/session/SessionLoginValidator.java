package com.project.spring.core.validator.impl.session;

import com.project.spring.common.model.enumeration.SpringErrorCodeEnum;
import com.project.spring.common.util.ParamChecker;
import com.project.spring.core.model.request.BaseRequest;
import com.project.spring.core.model.request.session.SessionLoginRequest;
import com.project.spring.core.validator.BaseValidator;

public class SessionLoginValidator implements BaseValidator {
    @Override
    public void validate(BaseRequest request) throws Exception {
        ParamChecker.isNotNull(request, "request", SpringErrorCodeEnum.PARAM_ILLEGAL);
        ParamChecker.isExpected(request instanceof SessionLoginRequest, "request", SpringErrorCodeEnum.PARAM_ILLEGAL);

        SessionLoginRequest sessionLoginRequest = (SessionLoginRequest) request;
        ParamChecker.isNotBlank(sessionLoginRequest.getUsername(), "username", SpringErrorCodeEnum.PARAM_ILLEGAL);
    }
}
