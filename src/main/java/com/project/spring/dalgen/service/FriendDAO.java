package com.project.spring.dalgen.service;

import com.project.spring.common.model.exception.SpringException;
import com.project.spring.dalgen.model.request.FriendDAORequest;
import com.project.spring.dalgen.model.response.FriendDO;

import java.util.List;

public interface FriendDAO {
    void insert(FriendDAORequest request) throws SpringException;

    List<FriendDO> query(FriendDAORequest request);
}
