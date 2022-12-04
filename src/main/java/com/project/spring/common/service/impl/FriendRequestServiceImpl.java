package com.project.spring.common.service.impl;

import com.project.spring.common.model.exception.SpringException;
import com.project.spring.common.model.request.friend.AddFriendInnerRequest;
import com.project.spring.common.model.request.friend.QueryFriendRequestInnerRequest;
import com.project.spring.common.model.request.friend.UpdateFriendRequestInnerRequest;
import com.project.spring.common.model.viewobject.FriendRequestVO;
import com.project.spring.common.model.viewobject.UserVO;
import com.project.spring.common.service.FriendRequestService;
import com.project.spring.dalgen.converter.FriendRequestDaoRequestConverter;
import com.project.spring.dalgen.model.request.FriendRequestDAORequest;
import com.project.spring.dalgen.model.response.FriendRequestDO;
import com.project.spring.dalgen.service.FriendRequestDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public void updateFriendRequest(UpdateFriendRequestInnerRequest request) throws SpringException {
        FriendRequestDAORequest daoRequest = FriendRequestDaoRequestConverter.
                toDAORequest(request);

        friendRequestDAO.update(daoRequest);
    }

    @Override
    public List<FriendRequestVO> queryFriendRequest(QueryFriendRequestInnerRequest request) {
        FriendRequestDAORequest daoRequest = FriendRequestDaoRequestConverter.
                toDAORequest(request);

        List<FriendRequestDO> friendRequestDOS = friendRequestDAO.query(daoRequest);
        return friendRequestDOS.stream().map(friendRequestDO -> {
            UserVO userVO = new UserVO();
            userVO.setUserId(friendRequestDO.getReceiverId());

            FriendRequestVO vo = new FriendRequestVO();
            vo.setReceiver(userVO);
            vo.setDeleted(friendRequestDO.isDeleted());
            vo.setAccepted(friendRequestDO.isAccepted());

            return vo;
        }).collect(Collectors.toList());
    }
}
