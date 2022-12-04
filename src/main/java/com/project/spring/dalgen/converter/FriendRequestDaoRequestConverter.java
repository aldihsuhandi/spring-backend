package com.project.spring.dalgen.converter;

import com.project.spring.common.model.request.friend.AddFriendInnerRequest;
import com.project.spring.common.model.request.friend.QueryFriendRequestInnerRequest;
import com.project.spring.common.model.request.friend.UpdateFriendRequestInnerRequest;
import com.project.spring.dalgen.model.request.FriendRequestDAORequest;

public class FriendRequestDaoRequestConverter {
    public static FriendRequestDAORequest toDAORequest(AddFriendInnerRequest innerRequest) {
        FriendRequestDAORequest daoRequest = new FriendRequestDAORequest();

        daoRequest.setRequesterId(innerRequest.getRequesterId());
        daoRequest.setReceiverId(innerRequest.getReceiverId());

        return daoRequest;
    }

    public static FriendRequestDAORequest toDAORequest(UpdateFriendRequestInnerRequest innerRequest) {
        FriendRequestDAORequest daoRequest = new FriendRequestDAORequest();

        daoRequest.setRequesterId(innerRequest.getRequesterId());
        daoRequest.setReceiverId(innerRequest.getReceiverId());
        daoRequest.setDeleted(innerRequest.isDeleted());
        daoRequest.setAccepted(innerRequest.isAccepted());

        return daoRequest;
    }

    public static FriendRequestDAORequest toDAORequest(QueryFriendRequestInnerRequest innerRequest) {
        FriendRequestDAORequest daoRequest = new FriendRequestDAORequest();
        daoRequest.setRequesterId(innerRequest.getRequesterId());

        return daoRequest;
    }
}
