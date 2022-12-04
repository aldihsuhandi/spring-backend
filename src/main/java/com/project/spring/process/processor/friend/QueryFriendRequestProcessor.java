package com.project.spring.process.processor.friend;

import com.project.spring.common.constant.CommonConst;
import com.project.spring.common.model.exception.SpringException;
import com.project.spring.common.model.request.friend.QueryFriendRequestInnerRequest;
import com.project.spring.common.model.request.user.UserQueryListInnerRequest;
import com.project.spring.common.model.viewobject.FriendRequestVO;
import com.project.spring.common.model.viewobject.UserVO;
import com.project.spring.common.service.FriendRequestService;
import com.project.spring.common.service.UserService;
import com.project.spring.core.converter.FriendRequestConverter;
import com.project.spring.core.converter.UserRequestConverter;
import com.project.spring.core.model.request.BaseRequest;
import com.project.spring.core.model.request.friend.QueryFriendRequestListRequest;
import com.project.spring.core.model.result.BaseResult;
import com.project.spring.core.model.result.friend.QueryFriendRequestListResult;
import com.project.spring.process.processor.BaseProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class QueryFriendRequestProcessor implements BaseProcessor {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    @Qualifier("friendRequestService")
    private FriendRequestService friendRequestService;

    @Override
    public void doProcess(BaseResult result, BaseRequest request) throws SpringException {
        QueryFriendRequestListRequest listRequest = (QueryFriendRequestListRequest) request;
        QueryFriendRequestListResult listResult = (QueryFriendRequestListResult) result;

        QueryFriendRequestInnerRequest innerRequest = FriendRequestConverter.toInnerREquest(listRequest);
        List<FriendRequestVO> friendRequestDOList = friendRequestService.queryFriendRequest(innerRequest);

        UserQueryListInnerRequest usersQueryRequest = UserRequestConverter.toInnerRequest(
                friendRequestDOList.stream().map(friendRequest -> friendRequest.
                        getReceiver().getUserId()).collect(Collectors.toList()), CommonConst.USER_ID);

        List<UserVO> userVOS = userService.queryListById(usersQueryRequest);

        composeUserInfoToResult(listResult, userVOS, friendRequestDOList);
    }

    private void composeUserInfoToResult(QueryFriendRequestListResult listResult,
                                         List<UserVO> userVOS, List<FriendRequestVO> friendRequestDOList) {
        Map<String, UserVO> userMap = userVOS.stream().collect(Collectors.toMap(UserVO::getUserId, userVO -> userVO));
        listResult.setFriendRequestVOS(
                friendRequestDOList.stream().peek(friendRequest -> {
                    UserVO user = userMap.get(friendRequest.getReceiver().getUserId());
                    friendRequest.setReceiver(user);
                }).collect(Collectors.toList())
        );
    }
}
