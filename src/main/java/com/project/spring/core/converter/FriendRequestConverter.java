package com.project.spring.core.converter;

import com.project.spring.common.model.request.friend.AddFriendInnerRequest;
import com.project.spring.common.model.request.friend.QueryFriendRequestInnerRequest;
import com.project.spring.common.model.request.friend.UpdateFriendRequestInnerRequest;
import com.project.spring.common.model.viewobject.UserVO;
import com.project.spring.core.model.request.friend.AcceptFriendRequest;
import com.project.spring.core.model.request.friend.QueryFriendRequestListRequest;
import com.project.spring.core.model.request.friend.RejectFriendRequest;

public class FriendRequestConverter {
    public static AddFriendInnerRequest toInnerRequest(UserVO requester, UserVO receiver) {
        AddFriendInnerRequest innerRequest = new AddFriendInnerRequest();

        innerRequest.setRequesterId(requester.getUserId());
        innerRequest.setReceiverId(receiver.getUserId());

        return innerRequest;
    }

    public static UpdateFriendRequestInnerRequest toInnerRequest(AcceptFriendRequest request) {
        UpdateFriendRequestInnerRequest innerRequest = new UpdateFriendRequestInnerRequest();
        innerRequest.setRequesterId(request.getRequesterUsername());
        innerRequest.setReceiverId(request.getReceiverUsername());
        innerRequest.setAccepted(true);
        innerRequest.setDeleted(false);

        return innerRequest;
    }

    public static UpdateFriendRequestInnerRequest toInnerRequest(RejectFriendRequest request) {
        UpdateFriendRequestInnerRequest innerRequest = new UpdateFriendRequestInnerRequest();
        innerRequest.setRequesterId(request.getRequesterUsername());
        innerRequest.setReceiverId(request.getReceiverUsername());
        innerRequest.setAccepted(false);
        innerRequest.setDeleted(true);

        return innerRequest;
    }

    public static QueryFriendRequestInnerRequest toInnerREquest(QueryFriendRequestListRequest request) {
        QueryFriendRequestInnerRequest innerRequest = new QueryFriendRequestInnerRequest();
        innerRequest.setRequesterId(request.getRequesterId());

        return innerRequest;
    }
}
