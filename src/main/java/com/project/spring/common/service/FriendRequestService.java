package com.project.spring.common.service;

import com.project.spring.common.model.exception.SpringException;
import com.project.spring.common.model.request.friend.AddFriendInnerRequest;

public interface FriendRequestService {
    void addFriend(AddFriendInnerRequest request) throws SpringException;
}
