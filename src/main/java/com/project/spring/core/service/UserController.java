package com.project.spring.core.service;

import com.project.spring.core.model.request.UserCreateRequest;
import com.project.spring.core.model.result.UserCreateResult;

public interface UserController {
    public UserCreateResult create(UserCreateRequest request);
}
