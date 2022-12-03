package com.project.spring.common.service.impl;

import com.project.spring.common.model.exception.SpringException;
import com.project.spring.common.model.request.friend.InsertFriendInnerRequest;
import com.project.spring.common.service.FriendService;
import com.project.spring.dalgen.converter.FriendDaoRequestConverter;
import com.project.spring.dalgen.service.FriendDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("friendService")
public class FriendServiceImpl implements FriendService {

    @Autowired
    @Qualifier("friendDAO")
    private FriendDAO friendDAO;

    @Override
    public void insertFriend(InsertFriendInnerRequest request) throws SpringException {
        friendDAO.insert(FriendDaoRequestConverter.
                toDAORequest(request.getFirstUser(), request.getSecondUser()));
        friendDAO.insert(FriendDaoRequestConverter.
                toDAORequest(request.getSecondUser(), request.getFirstUser()));
    }
}
