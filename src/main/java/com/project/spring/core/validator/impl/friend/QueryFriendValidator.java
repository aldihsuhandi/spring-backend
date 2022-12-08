package com.project.spring.core.validator.impl.friend;

import com.project.spring.common.model.enumeration.SpringErrorCodeEnum;
import com.project.spring.common.util.ParamChecker;
import com.project.spring.core.model.request.BaseRequest;
import com.project.spring.core.model.request.friend.QueryFriendListRequest;
import com.project.spring.core.validator.BaseValidator;

public class QueryFriendValidator implements BaseValidator {
    @Override
    public void validate(BaseRequest request) throws Exception {
        ParamChecker.isNotNull(request, "request", SpringErrorCodeEnum.PARAM_ILLEGAL);
        ParamChecker.isExpected(request instanceof QueryFriendListRequest, "request", SpringErrorCodeEnum.PARAM_ILLEGAL);

        QueryFriendListRequest queryFriendListRequest = (QueryFriendListRequest) request;
        ParamChecker.isNotBlank(queryFriendListRequest.getEmail(), "email", SpringErrorCodeEnum.PARAM_ILLEGAL);
        ParamChecker.isExpected(queryFriendListRequest.getEmail(), "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$",
                "email", SpringErrorCodeEnum.PARAM_ILLEGAL);
    }
}
