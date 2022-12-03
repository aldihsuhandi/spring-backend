package com.project.spring.common.validator.impl.friend;

import com.project.spring.common.model.enumeration.SpringErrorCodeEnum;
import com.project.spring.common.util.ParamChecker;
import com.project.spring.common.validator.BaseValidator;
import com.project.spring.core.model.request.BaseRequest;
import com.project.spring.core.model.request.friend.AddFriendRequest;

public class AddFriendValidator implements BaseValidator {
    @Override
    public void validate(BaseRequest request) throws Exception {

        ParamChecker.isNotNull(request, "request", SpringErrorCodeEnum.PARAM_ILLEGAL);
        ParamChecker.isExpected(request instanceof AddFriendRequest, "request", SpringErrorCodeEnum.PARAM_ILLEGAL);

        AddFriendRequest addFriendRequest = (AddFriendRequest) request;

        ParamChecker.isNotBlank(addFriendRequest.getRequesterUsername(), "requester username", SpringErrorCodeEnum.PARAM_ILLEGAL);
        ParamChecker.isNotBlank(addFriendRequest.getReceiverUsername(), "receiver username", SpringErrorCodeEnum.PARAM_ILLEGAL);
    }
}
