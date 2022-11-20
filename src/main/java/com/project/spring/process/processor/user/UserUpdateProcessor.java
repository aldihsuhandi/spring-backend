package com.project.spring.process.processor.user;

import com.project.spring.common.model.exception.SpringException;
import com.project.spring.common.model.request.UserQueryInnerRequest;
import com.project.spring.common.model.request.UserUpdateInnerRequest;
import com.project.spring.common.model.viewobject.UserVO;
import com.project.spring.common.service.UserService;
import com.project.spring.common.util.StringUtil;
import com.project.spring.core.converter.UserRequestConverter;
import com.project.spring.core.model.request.BaseRequest;
import com.project.spring.core.model.request.UserUpdateRequest;
import com.project.spring.core.model.result.BaseResult;
import com.project.spring.process.processor.BaseProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class UserUpdateProcessor implements BaseProcessor {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Override
    public void doProcess(BaseResult result, BaseRequest request) throws SpringException {
        UserUpdateRequest updateRequest = (UserUpdateRequest) request;
        UserVO userVO = userService.queryById(composeQueryRequest((updateRequest.getUserId())));

        if (StringUtil.isNotEmpty(updateRequest.getPassword())) {
            updateRequest.setPassword(userService.
                    encryptPassword(updateRequest.getPassword()));
        }

        UserUpdateInnerRequest innerRequest =
                UserRequestConverter.toInnerRequest(updateRequest, userVO);
        userService.update(innerRequest);
    }

    private UserQueryInnerRequest composeQueryRequest(String userId) {
        UserQueryInnerRequest request = new UserQueryInnerRequest();
        request.setUserId(userId);

        return request;
    }
}
