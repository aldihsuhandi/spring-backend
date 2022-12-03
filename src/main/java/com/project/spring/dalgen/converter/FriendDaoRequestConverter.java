package com.project.spring.dalgen.converter;

import com.project.spring.dalgen.model.request.FriendDAORequest;

public class FriendDaoRequestConverter {
    public static FriendDAORequest toDAORequest(String userId, String friendId) {
        FriendDAORequest request = new FriendDAORequest();
        request.setUserId(userId);
        request.setFriendId(friendId);

        return request;
    }
}
