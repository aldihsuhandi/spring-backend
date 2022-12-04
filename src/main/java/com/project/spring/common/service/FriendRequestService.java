package com.project.spring.common.service;

import com.project.spring.common.model.exception.SpringException;
import com.project.spring.common.model.request.friend.AddFriendInnerRequest;
import com.project.spring.common.model.request.friend.QueryFriendRequestInnerRequest;
import com.project.spring.common.model.request.friend.UpdateFriendRequestInnerRequest;
import com.project.spring.common.model.viewobject.FriendRequestVO;

import java.util.List;

public interface FriendRequestService {
    void addFriend(AddFriendInnerRequest request) throws SpringException;

    void updateFriendRequest(UpdateFriendRequestInnerRequest request) throws SpringException;

    List<FriendRequestVO> queryFriendRequest(QueryFriendRequestInnerRequest request);
}
