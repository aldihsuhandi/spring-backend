package com.project.spring.common.service;

import com.project.spring.common.model.exception.SpringException;
import com.project.spring.common.model.request.friend.InsertFriendInnerRequest;

public interface FriendService {
    void insertFriend(InsertFriendInnerRequest request) throws SpringException;
}
