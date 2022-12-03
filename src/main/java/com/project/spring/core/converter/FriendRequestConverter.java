package com.project.spring.core.converter;

import com.project.spring.common.model.request.friend.AddFriendInnerRequest;
import com.project.spring.common.model.viewobject.UserVO;

public class FriendRequestConverter {
    public static AddFriendInnerRequest toInnerRequest(UserVO requester, UserVO receiver) {
        AddFriendInnerRequest innerRequest = new AddFriendInnerRequest();

        innerRequest.setRequesterId(requester.getUserId());
        innerRequest.setReceiverId(receiver.getUserId());

        return innerRequest;
    }
}
