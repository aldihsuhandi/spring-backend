package com.project.spring.process.processor.user;

import com.project.spring.common.converter.UserVOConverter;
import com.project.spring.common.model.exception.SpringException;
import com.project.spring.common.model.request.user.UserQueryInnerRequest;
import com.project.spring.common.model.viewobject.UserVO;
import com.project.spring.common.service.UserService;
import com.project.spring.common.util.StringUtil;
import com.project.spring.core.converter.UserRequestConverter;
import com.project.spring.core.model.request.BaseRequest;
import com.project.spring.core.model.request.user.UserQueryRequest;
import com.project.spring.core.model.result.BaseResult;
import com.project.spring.core.model.result.UserQueryResult;
import com.project.spring.process.processor.BaseProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class UserQueryProcessor implements BaseProcessor {

    @Autowired
    @Qualifier("userService")
    UserService userService;

    @Override
    public void doProcess(final BaseResult result, final BaseRequest request) throws SpringException {
        UserQueryRequest userQueryRequest = (UserQueryRequest) request;
        UserQueryResult userQueryResult = (UserQueryResult) result;

        UserVO userVO = new UserVO();
        UserQueryInnerRequest innerRequest = UserRequestConverter.toInnerRequest(userQueryRequest);
        if (StringUtil.isNotEmpty(userQueryRequest.getUserId())) {
            userVO = userService.queryById(innerRequest);
        } else if (StringUtil.isNotEmpty(userQueryRequest.getEmail())) {
            userVO = userService.queryByEmail(innerRequest);
        } else if (StringUtil.isNotEmpty(userQueryRequest.getUsername())) {
            userVO = userService.queryByUsername(innerRequest);
        }

        UserVOConverter.toResult(userVO, userQueryResult);
    }
}
