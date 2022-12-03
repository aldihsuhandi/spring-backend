package com.project.spring.dalgen.service;

import com.project.spring.common.model.exception.SpringException;
import com.project.spring.dalgen.model.request.FriendDAORequest;

public interface FriendDAO {
    void insert(FriendDAORequest request) throws SpringException;
}
