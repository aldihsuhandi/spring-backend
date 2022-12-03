package com.project.spring.process.processor.friend;

import com.project.spring.common.model.exception.SpringException;
import com.project.spring.common.model.request.friend.InsertFriendInnerRequest;
import com.project.spring.common.model.request.friend.UpdateFriendRequestInnerRequest;
import com.project.spring.common.service.FriendRequestService;
import com.project.spring.common.service.FriendService;
import com.project.spring.core.converter.FriendConverter;
import com.project.spring.core.converter.FriendRequestConverter;
import com.project.spring.core.model.request.BaseRequest;
import com.project.spring.core.model.request.friend.AcceptFriendRequest;
import com.project.spring.core.model.result.BaseResult;
import com.project.spring.process.processor.BaseProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class AcceptFriendProcessor implements BaseProcessor {

    @Autowired
    @Qualifier("friendRequestService")
    private FriendRequestService friendRequestService;

    @Autowired
    @Qualifier("friendService")
    private FriendService friendService;

    @Override
    public void doProcess(BaseResult result, BaseRequest request) throws SpringException {
        AcceptFriendRequest acceptRequest = (AcceptFriendRequest) request;

        UpdateFriendRequestInnerRequest innerRequest = FriendRequestConverter.toInnerRequest(acceptRequest);
        friendRequestService.updateFriendRequest(innerRequest);

        InsertFriendInnerRequest insertRequest = FriendConverter.toInnerRequest(acceptRequest);
        friendService.insertFriend(insertRequest);
    }
}
