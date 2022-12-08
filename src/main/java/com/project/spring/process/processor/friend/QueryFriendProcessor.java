package com.project.spring.process.processor.friend;

import com.project.spring.common.constant.CommonConst;
import com.project.spring.common.model.exception.SpringException;
import com.project.spring.common.model.request.friend.QueryFriendInnerRequest;
import com.project.spring.common.model.viewobject.UserVO;
import com.project.spring.common.service.FriendService;
import com.project.spring.common.service.UserService;
import com.project.spring.core.converter.FriendConverter;
import com.project.spring.core.converter.UserRequestConverter;
import com.project.spring.core.model.request.BaseRequest;
import com.project.spring.core.model.request.friend.QueryFriendListRequest;
import com.project.spring.core.model.result.BaseResult;
import com.project.spring.core.model.result.friend.QueryFriendListResult;
import com.project.spring.dalgen.model.response.FriendDO;
import com.project.spring.process.processor.BaseProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.stream.Collectors;

public class QueryFriendProcessor implements BaseProcessor {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    @Qualifier("friendService")
    private FriendService friendService;

    @Override
    public void doProcess(BaseResult result, BaseRequest request) throws SpringException {
        QueryFriendListRequest queryRequest = (QueryFriendListRequest) request;
        QueryFriendListResult queryResult = (QueryFriendListResult) result;

        String userId = userService.queryByEmail(UserRequestConverter.toInnerRequest(
                queryRequest.getEmail(), CommonConst.EMAIL, true)).getUserId();

        QueryFriendInnerRequest innerRequest = FriendConverter.toInnerRequest(userId);
        List<String> friendIds = friendService.query(innerRequest).
                stream().map(FriendDO::getUserId).collect(Collectors.toList());

        List<UserVO> userVOS = userService.queryListById(
                UserRequestConverter.toInnerRequest(friendIds, CommonConst.USER_ID, true));
        queryResult.setUserVOS(userVOS);
    }
}
