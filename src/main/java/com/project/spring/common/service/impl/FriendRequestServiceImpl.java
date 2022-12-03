package com.project.spring.common.service.impl;

import com.project.spring.common.model.exception.SpringException;
import com.project.spring.common.model.request.friend.AddFriendInnerRequest;
import com.project.spring.common.service.FriendRequestService;
import com.project.spring.dalgen.converter.FriendRequestDaoRequestConverter;
import com.project.spring.dalgen.model.request.FriendRequestDAORequest;
import com.project.spring.dalgen.service.FriendRequestDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("friendRequestService")
public class FriendRequestServiceImpl implements FriendRequestService {

    @Autowired
    @Qualifier("friendRequestDAO")
    private FriendRequestDAO friendRequestDAO;

    @Override
    public void addFriend(AddFriendInnerRequest request) throws SpringException {
        FriendRequestDAORequest daoRequest = FriendRequestDaoRequestConverter.
                toDAORequest(request);
        friendRequestDAO.insert(daoRequest);
    }
}
