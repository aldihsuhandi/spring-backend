package com.project.spring.dalgen.converter;

import com.project.spring.common.model.request.friend.QueryFriendInnerRequest;
import com.project.spring.dalgen.model.request.FriendDAORequest;

public class FriendDaoRequestConverter {
    public static FriendDAORequest toDAORequest(String userId, String friendId) {
        FriendDAORequest request = new FriendDAORequest();
        request.setUserId(userId);
        request.setFriendId(friendId);

        return request;
    }

    public static FriendDAORequest toDAORequest(QueryFriendInnerRequest innerRequest) {
        FriendDAORequest daoRequest = new FriendDAORequest();
        daoRequest.setUserId(innerRequest.getUserId());

        return daoRequest;
    }
}
