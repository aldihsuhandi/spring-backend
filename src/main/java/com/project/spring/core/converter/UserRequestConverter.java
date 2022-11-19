package com.project.spring.core.converter;

import com.project.spring.common.model.request.UserCreateInnerRequest;
import com.project.spring.core.model.request.UserCreateRequest;

public class UserRequestConverter {
    public static UserCreateInnerRequest toInnerCreateRequest(UserCreateRequest request) {
        UserCreateInnerRequest innerRequest = new UserCreateInnerRequest();

        innerRequest.setEmail(request.getEmail());
        innerRequest.setUsername(request.getUsername());
        innerRequest.setPassword(request.getPassword());

        return innerRequest;
    }
}
