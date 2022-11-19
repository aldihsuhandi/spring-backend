package com.project.spring.process.processor.user;

import com.project.spring.common.model.exception.SpringException;
import com.project.spring.common.model.request.UserCreateInnerRequest;
import com.project.spring.common.model.viewobject.UserVO;
import com.project.spring.common.service.UserService;
import com.project.spring.core.converter.UserRequestConverter;
import com.project.spring.core.model.request.BaseRequest;
import com.project.spring.core.model.request.UserCreateRequest;
import com.project.spring.core.model.result.BaseResult;
import com.project.spring.process.processor.BaseProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class UserCreateProcessor implements BaseProcessor {

    @Autowired
    @Qualifier("userService")
    UserService userService;

    @Override
    public void doProcess(final BaseResult result, final BaseRequest request) throws SpringException {
        UserCreateInnerRequest userCreateInnerRequest = UserRequestConverter.toInnerCreateRequest((UserCreateRequest) request);
        UserVO userVO = userService.create(userCreateInnerRequest);
    }
}
