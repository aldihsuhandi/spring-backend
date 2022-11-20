package com.project.spring.common.validator.impl.user;

import com.project.spring.common.model.enumeration.SpringErrorCodeEnum;
import com.project.spring.common.util.ParamChecker;
import com.project.spring.common.util.StringUtil;
import com.project.spring.common.validator.BaseValidator;
import com.project.spring.core.model.request.BaseRequest;
import com.project.spring.core.model.request.user.UserQueryRequest;

public class UserQueryValidator implements BaseValidator {
    @Override
    public void validate(BaseRequest request) throws Exception {
        ParamChecker.isNotNull(request, "request", SpringErrorCodeEnum.PARAM_ILLEGAL);

        ParamChecker.isExpected(request instanceof UserQueryRequest, "request", SpringErrorCodeEnum.PARAM_ILLEGAL);

        UserQueryRequest userQueryRequest = (UserQueryRequest) request;

        ParamChecker.isExpected(checkIdentifier(userQueryRequest), "userId, userName, Email", SpringErrorCodeEnum.PARAM_ILLEGAL);
    }

    private boolean checkIdentifier(UserQueryRequest request) {
        return StringUtil.isNotEmpty(request.getUserId()) ||
                StringUtil.isNotEmpty(request.getUsername()) ||
                StringUtil.isNotEmpty(request.getEmail());
    }
}
