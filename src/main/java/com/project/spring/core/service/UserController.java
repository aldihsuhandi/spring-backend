package com.project.spring.core.service;

import com.project.spring.core.model.request.UserCreateRequest;
import com.project.spring.core.model.request.UserQueryRequest;
import com.project.spring.core.model.result.UserCreateResult;
import com.project.spring.core.model.result.UserQueryResult;

public interface UserController {
    public UserCreateResult create(UserCreateRequest request);

    public UserQueryResult query(UserQueryRequest request);
}
