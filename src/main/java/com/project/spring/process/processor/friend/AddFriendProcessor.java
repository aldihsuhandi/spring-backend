package com.project.spring.process.processor.friend;

import com.project.spring.common.constant.CommonConst;
import com.project.spring.common.model.exception.SpringException;
import com.project.spring.common.model.request.friend.AddFriendInnerRequest;
import com.project.spring.common.model.request.user.UserQueryInnerRequest;
import com.project.spring.common.model.viewobject.UserVO;
import com.project.spring.common.service.FriendRequestService;
import com.project.spring.common.service.UserService;
import com.project.spring.core.converter.FriendRequestConverter;
import com.project.spring.core.converter.UserRequestConverter;
import com.project.spring.core.model.request.BaseRequest;
import com.project.spring.core.model.request.friend.AddFriendRequest;
import com.project.spring.core.model.result.BaseResult;
import com.project.spring.process.processor.BaseProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class AddFriendProcessor implements BaseProcessor {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    @Qualifier("friendRequestService")
    private FriendRequestService friendRequestService;

    @Override
    public void doProcess(BaseResult result, BaseRequest request) throws SpringException {
        AddFriendRequest addFriendRequest = (AddFriendRequest) request;
        UserQueryInnerRequest requesterQueryRequest = UserRequestConverter.
                toInnerRequest(addFriendRequest.getRequesterUsername(), CommonConst.USERNAME, true);
        UserQueryInnerRequest receiverQueryRequest = UserRequestConverter.
                toInnerRequest(addFriendRequest.getReceiverUsername(), CommonConst.USERNAME, true);

        UserVO receiver = userService.queryByUsername(receiverQueryRequest);
        UserVO requester = userService.queryByUsername(requesterQueryRequest);

        AddFriendInnerRequest innerRequest = FriendRequestConverter.toInnerRequest(requester, receiver);

        friendRequestService.addFriend(innerRequest);
    }
}
