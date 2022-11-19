package com.project.spring.common.validator.impl;

import com.project.spring.common.model.enumeration.SpringErrorCodeEnum;
import com.project.spring.common.util.ParamChecker;
import com.project.spring.common.validator.BaseValidator;
import com.project.spring.core.model.request.BaseRequest;
import com.project.spring.core.model.request.UserCreateRequest;

public class UserCreateValidator implements BaseValidator {

    @Override
    public void validate(BaseRequest request) throws Exception {
        ParamChecker.isExpected(request instanceof UserCreateRequest, "request", SpringErrorCodeEnum.PARAM_ILLEGAL);
        UserCreateRequest userCreateRequest = (UserCreateRequest) request;

        ParamChecker.isNotBlank(userCreateRequest.getUsername(), "username", SpringErrorCodeEnum.PARAM_ILLEGAL);
        ParamChecker.isNotBlank(userCreateRequest.getEmail(), "email", SpringErrorCodeEnum.PARAM_ILLEGAL);
        ParamChecker.isNotBlank(userCreateRequest.getPassword(), "password", SpringErrorCodeEnum.PARAM_ILLEGAL);

        ParamChecker.isExpected(userCreateRequest.getEmail(), "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$",
                "email", SpringErrorCodeEnum.PARAM_ILLEGAL);
    }
}
