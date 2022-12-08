package com.project.spring.core.converter;

import com.project.spring.common.model.request.friend.InsertFriendInnerRequest;
import com.project.spring.common.model.request.friend.QueryFriendInnerRequest;
import com.project.spring.core.model.request.friend.AcceptFriendRequest;

public class FriendConverter {
    public static InsertFriendInnerRequest toInnerRequest(AcceptFriendRequest request) {
        InsertFriendInnerRequest innerRequest = new InsertFriendInnerRequest();
        innerRequest.setFirstUser(request.getRequesterUsername());
        innerRequest.setSecondUser(request.getReceiverUsername());

        return innerRequest;
    }

    public static QueryFriendInnerRequest toInnerRequest(String userId) {
        QueryFriendInnerRequest innerRequest = new QueryFriendInnerRequest();
        innerRequest.setUserId(userId);

        return innerRequest;
    }
}
