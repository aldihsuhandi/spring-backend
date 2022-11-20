package com.project.spring.common.validator.impl;

import com.project.spring.common.model.enumeration.SpringErrorCodeEnum;
import com.project.spring.common.util.ParamChecker;
import com.project.spring.common.util.StringUtil;
import com.project.spring.common.validator.BaseValidator;
import com.project.spring.core.model.request.BaseRequest;
import com.project.spring.core.model.request.UserUpdateRequest;

public class UserUpdateValidator implements BaseValidator {
    @Override
    public void validate(BaseRequest request) throws Exception {
        ParamChecker.isNotNull(request, "request", SpringErrorCodeEnum.PARAM_ILLEGAL);
        ParamChecker.isExpected(request instanceof UserUpdateRequest, "request", SpringErrorCodeEnum.PARAM_ILLEGAL);

        UserUpdateRequest userUpdateRequest = (UserUpdateRequest) request;

        ParamChecker.isNotBlank(userUpdateRequest.getUserId(), "userId", SpringErrorCodeEnum.PARAM_ILLEGAL);

        checkEmail(userUpdateRequest.getEmail());
    }

    private void checkEmail(String email) throws Exception {
        if (StringUtil.isEmpty(email)) {
            return;
        }

        ParamChecker.isExpected(email, "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$",
                "email", SpringErrorCodeEnum.PARAM_ILLEGAL);
    }
}
