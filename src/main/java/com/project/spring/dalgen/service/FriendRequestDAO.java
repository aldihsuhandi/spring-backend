package com.project.spring.dalgen.service;

import com.project.spring.common.model.exception.SpringException;
import com.project.spring.dalgen.model.request.FriendRequestDAORequest;

public interface FriendRequestDAO {
    void insert(FriendRequestDAORequest request) throws SpringException;

    void update(FriendRequestDAORequest request) throws SpringException;
}
