package com.project.spring.dalgen.service;

import com.project.spring.common.model.exception.SpringException;
import com.project.spring.dalgen.model.request.FriendRequestDAORequest;
import com.project.spring.dalgen.model.response.FriendRequestDO;

import java.util.List;

public interface FriendRequestDAO {
    void insert(FriendRequestDAORequest request) throws SpringException;

    void update(FriendRequestDAORequest request) throws SpringException;

    List<FriendRequestDO> query(FriendRequestDAORequest request);
}
