package com.project.spring.core.validator.impl.friend;

import com.project.spring.common.model.enumeration.SpringErrorCodeEnum;
import com.project.spring.common.util.ParamChecker;
import com.project.spring.core.model.request.BaseRequest;
import com.project.spring.core.model.request.friend.QueryFriendRequestListRequest;
import com.project.spring.core.validator.BaseValidator;

public class QueryFriendRequestValidator implements BaseValidator {
    @Override
    public void validate(BaseRequest request) throws Exception {
        ParamChecker.isNotNull(request, "request", SpringErrorCodeEnum.PARAM_ILLEGAL);
        ParamChecker.isExpected(request instanceof QueryFriendRequestListRequest, "request", SpringErrorCodeEnum.PARAM_ILLEGAL);

        QueryFriendRequestListRequest queryRequest = (QueryFriendRequestListRequest) request;
        ParamChecker.isNotBlank(queryRequest.getRequesterId(), "requesterId", SpringErrorCodeEnum.PARAM_ILLEGAL);
    }
}
