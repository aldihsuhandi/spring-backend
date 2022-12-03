package com.project.spring.core.validator.impl.friend;

import com.project.spring.common.model.enumeration.SpringErrorCodeEnum;
import com.project.spring.common.util.ParamChecker;
import com.project.spring.core.model.request.BaseRequest;
import com.project.spring.core.model.request.friend.RejectFriendRequest;
import com.project.spring.core.validator.BaseValidator;

public class RejectFriendValidator implements BaseValidator {
    @Override
    public void validate(BaseRequest request) throws Exception {
        ParamChecker.isNotNull(request, "request", SpringErrorCodeEnum.PARAM_ILLEGAL);
        ParamChecker.isExpected(request instanceof RejectFriendRequest, "request", SpringErrorCodeEnum.PARAM_ILLEGAL);

        RejectFriendRequest rejectFriendRequest = (RejectFriendRequest) request;

        ParamChecker.isNotBlank(rejectFriendRequest.getRequesterUsername(), "requester username", SpringErrorCodeEnum.PARAM_ILLEGAL);
        ParamChecker.isNotBlank(rejectFriendRequest.getReceiverUsername(), "receiver username", SpringErrorCodeEnum.PARAM_ILLEGAL);
    }
}
