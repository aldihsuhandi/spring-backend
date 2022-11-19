package com.project.spring.core.converter;

import com.project.spring.common.model.request.UserCreateInnerRequest;
import com.project.spring.common.model.request.UserQueryInnerRequest;
import com.project.spring.core.model.request.UserCreateRequest;
import com.project.spring.core.model.request.UserQueryRequest;

public class UserRequestConverter {
    public static UserCreateInnerRequest toInnerRequest(UserCreateRequest request) {
        UserCreateInnerRequest innerRequest = new UserCreateInnerRequest();

        innerRequest.setEmail(request.getEmail());
        innerRequest.setUsername(request.getUsername());
        innerRequest.setPassword(request.getPassword());

        return innerRequest;
    }

    public static UserQueryInnerRequest toInnerRequest(UserQueryRequest request) {
        UserQueryInnerRequest innerRequest = new UserQueryInnerRequest();
        innerRequest.setEmail(request.getEmail());
        innerRequest.setUsername(request.getUsername());
        innerRequest.setUserId(request.getUserId());

        return innerRequest;
    }
}
