package com.project.spring.process.processor.user;

import com.project.spring.common.constant.CommonConst;
import com.project.spring.common.model.exception.SpringException;
import com.project.spring.common.model.request.user.UserDeleteInnerRequest;
import com.project.spring.common.model.request.user.UserUpdateCacheInnerRequest;
import com.project.spring.common.model.viewobject.UserVO;
import com.project.spring.common.service.UserService;
import com.project.spring.core.converter.UserRequestConverter;
import com.project.spring.core.model.request.BaseRequest;
import com.project.spring.core.model.request.user.UserDeleteRequest;
import com.project.spring.core.model.result.BaseResult;
import com.project.spring.process.processor.BaseProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class UserDeleteProcessor implements BaseProcessor {

    @Autowired
    @Qualifier("userService")
    UserService userService;

    @Override
    public void doProcess(BaseResult result, BaseRequest request) throws SpringException {
        UserDeleteRequest deleteRequest = (UserDeleteRequest) request;
        UserVO userVO = userService.queryByEmail(UserRequestConverter.
                toInnerRequest(deleteRequest.getEmail(), CommonConst.EMAIL, true));

        UserDeleteInnerRequest innerRequest = UserRequestConverter.toInnerRequest(deleteRequest, userVO);
        userService.delete(innerRequest);


        UserUpdateCacheInnerRequest updateCacheRequest = UserRequestConverter.
                toInnerRequest(deleteRequest.getEmail(), CommonConst.EMAIL);
        userService.updateCache(updateCacheRequest);
    }
}
