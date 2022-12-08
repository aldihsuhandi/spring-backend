package com.project.spring.common.service;

import com.project.spring.common.model.exception.SpringException;
import com.project.spring.common.model.request.friend.InsertFriendInnerRequest;
import com.project.spring.common.model.request.friend.QueryFriendInnerRequest;
import com.project.spring.dalgen.model.response.FriendDO;

import java.util.List;

public interface FriendService {
    void insertFriend(InsertFriendInnerRequest request) throws SpringException;

    List<FriendDO> query(QueryFriendInnerRequest request);
}
