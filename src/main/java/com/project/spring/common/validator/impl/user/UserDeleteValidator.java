package com.project.spring.common.validator.impl.user;

import com.project.spring.common.model.enumeration.SpringErrorCodeEnum;
import com.project.spring.common.util.ParamChecker;
import com.project.spring.common.validator.BaseValidator;
import com.project.spring.core.model.request.BaseRequest;
import com.project.spring.core.model.request.user.UserDeleteRequest;

public class UserDeleteValidator implements BaseValidator {
    @Override
    public void validate(BaseRequest request) throws Exception {

        ParamChecker.isNotNull(request, "request", SpringErrorCodeEnum.PARAM_ILLEGAL);
        ParamChecker.isExpected(request instanceof UserDeleteRequest, "request", SpringErrorCodeEnum.PARAM_ILLEGAL);

        UserDeleteRequest deleteRequest = (UserDeleteRequest) request;

        ParamChecker.isNotBlank(deleteRequest.getEmail(), "email", SpringErrorCodeEnum.PARAM_ILLEGAL);

        ParamChecker.isExpected(deleteRequest.getEmail(), "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$",
                "email", SpringErrorCodeEnum.PARAM_ILLEGAL);
    }
}
