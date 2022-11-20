package com.project.spring.core.service;

import com.project.spring.core.model.request.UserCreateRequest;
import com.project.spring.core.model.request.UserQueryRequest;
import com.project.spring.core.model.request.UserUpdateRequest;
import com.project.spring.core.model.result.UserCreateResult;
import com.project.spring.core.model.result.UserQueryResult;
import com.project.spring.core.model.result.UserUpdateResult;

public interface UserController {
    UserCreateResult create(UserCreateRequest request);

    UserQueryResult query(UserQueryRequest request);

    UserUpdateResult update(UserUpdateRequest request);
}
