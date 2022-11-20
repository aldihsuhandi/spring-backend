package com.project.spring.process.processor.user;

import com.project.spring.common.model.context.UserUpdateContext;
import com.project.spring.common.model.exception.SpringException;
import com.project.spring.common.model.request.user.UserUpdateInnerRequest;
import com.project.spring.common.model.viewobject.UserVO;
import com.project.spring.common.service.UserService;
import com.project.spring.common.util.Const;
import com.project.spring.common.util.StringUtil;
import com.project.spring.core.converter.UserRequestConverter;
import com.project.spring.core.model.request.BaseRequest;
import com.project.spring.core.model.request.user.UserUpdateRequest;
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
        UserVO userVO = userService.queryByEmail(UserRequestConverter.
                toInnerRequest(updateRequest.getEmail(), Const.EMAIL));

        UserUpdateContext updateContext = updateRequest.getUpdateContext();

        if (StringUtil.isNotEmpty(updateContext.getPassword())) {
            updateContext.setPassword(userService.
                    encryptPassword(updateContext.getPassword()));
        }

        UserUpdateInnerRequest innerRequest =
                UserRequestConverter.toInnerRequest(updateRequest, userVO);
        userService.update(innerRequest);
    }
}
