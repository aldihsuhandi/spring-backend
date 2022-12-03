package com.project.spring.core.validator.impl.user;

import com.project.spring.common.model.context.UserUpdateContext;
import com.project.spring.common.model.enumeration.SpringErrorCodeEnum;
import com.project.spring.common.util.ParamChecker;
import com.project.spring.common.util.StringUtil;
import com.project.spring.core.model.request.BaseRequest;
import com.project.spring.core.model.request.user.UserUpdateRequest;
import com.project.spring.core.validator.BaseValidator;

public class UserUpdateValidator implements BaseValidator {
    @Override
    public void validate(BaseRequest request) throws Exception {
        ParamChecker.isNotNull(request, "request", SpringErrorCodeEnum.PARAM_ILLEGAL);
        ParamChecker.isExpected(request instanceof UserUpdateRequest, "request", SpringErrorCodeEnum.PARAM_ILLEGAL);

        UserUpdateRequest userUpdateRequest = (UserUpdateRequest) request;

        ParamChecker.isNotBlank(userUpdateRequest.getEmail(), "userId", SpringErrorCodeEnum.PARAM_ILLEGAL);

        ParamChecker.isNotNull(userUpdateRequest.getUpdateContext(), "update context", SpringErrorCodeEnum.PARAM_ILLEGAL);

        checkEmail(userUpdateRequest.getUpdateContext());
    }

    private void checkEmail(UserUpdateContext updateContext) throws Exception {
        if (StringUtil.isEmpty(updateContext.getEmail())) {
            return;
        }

        ParamChecker.isExpected(updateContext.getEmail(), "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$",
                "email", SpringErrorCodeEnum.PARAM_ILLEGAL);
    }
}
