package com.project.spring.core.validator.impl.session;

import com.project.spring.common.model.enumeration.SpringErrorCodeEnum;
import com.project.spring.common.util.ParamChecker;
import com.project.spring.core.model.request.BaseRequest;
import com.project.spring.core.model.request.session.SessionQueryRequest;
import com.project.spring.core.validator.BaseValidator;

public class SessionQueryValidator implements BaseValidator {
    @Override
    public void validate(BaseRequest request) throws Exception {
        ParamChecker.isNotNull(request, "request", SpringErrorCodeEnum.PARAM_ILLEGAL);
        ParamChecker.isExpected(request instanceof SessionQueryRequest, "request", SpringErrorCodeEnum.PARAM_ILLEGAL);

        SessionQueryRequest queryRequest = (SessionQueryRequest) request;
        ParamChecker.isNotBlank(queryRequest.getSessionId(), "sessionId", SpringErrorCodeEnum.PARAM_ILLEGAL);
    }
}
