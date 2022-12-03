package com.project.spring.process.processor.friend;

import com.project.spring.common.model.exception.SpringException;
import com.project.spring.common.model.request.friend.UpdateFriendRequestInnerRequest;
import com.project.spring.common.service.FriendRequestService;
import com.project.spring.core.converter.FriendRequestConverter;
import com.project.spring.core.model.request.BaseRequest;
import com.project.spring.core.model.request.friend.RejectFriendRequest;
import com.project.spring.core.model.result.BaseResult;
import com.project.spring.process.processor.BaseProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class RejectFriendProcessor implements BaseProcessor {

    @Autowired
    @Qualifier("friendRequestService")
    private FriendRequestService friendRequestService;

    @Override
    public void doProcess(BaseResult result, BaseRequest request) throws SpringException {
        RejectFriendRequest rejectFriendRequest = (RejectFriendRequest) request;

        UpdateFriendRequestInnerRequest innerRequest = FriendRequestConverter.toInnerRequest(rejectFriendRequest);
        friendRequestService.updateFriendRequest(innerRequest);
    }
}
