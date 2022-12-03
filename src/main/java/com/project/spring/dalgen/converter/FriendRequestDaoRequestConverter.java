package com.project.spring.dalgen.converter;

import com.project.spring.common.model.request.friend.AddFriendInnerRequest;
import com.project.spring.dalgen.model.request.FriendRequestDAORequest;

public class FriendRequestDaoRequestConverter {
    public static FriendRequestDAORequest toDAORequest(AddFriendInnerRequest innerRequest) {
        FriendRequestDAORequest daoRequest = new FriendRequestDAORequest();

        daoRequest.setRequesterId(innerRequest.getRequesterId());
        daoRequest.setReceiverId(innerRequest.getReceiverId());

        return daoRequest;
    }
}
