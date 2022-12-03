package com.project.spring.core.validator.impl.friend;

import com.project.spring.common.model.enumeration.SpringErrorCodeEnum;
import com.project.spring.common.util.ParamChecker;
import com.project.spring.core.model.request.BaseRequest;
import com.project.spring.core.model.request.friend.AcceptFriendRequest;
import com.project.spring.core.validator.BaseValidator;

public class AcceptFriendValidator implements BaseValidator {
    @Override
    public void validate(BaseRequest request) throws Exception {

        ParamChecker.isNotNull(request, "request", SpringErrorCodeEnum.PARAM_ILLEGAL);
        ParamChecker.isExpected(request instanceof AcceptFriendRequest, "request", SpringErrorCodeEnum.PARAM_ILLEGAL);

        AcceptFriendRequest acceptFriendRequest = (AcceptFriendRequest) request;

        ParamChecker.isNotBlank(acceptFriendRequest.getRequesterUsername(), "requester username", SpringErrorCodeEnum.PARAM_ILLEGAL);
        ParamChecker.isNotBlank(acceptFriendRequest.getReceiverUsername(), "receiver username", SpringErrorCodeEnum.PARAM_ILLEGAL);
    }
}
