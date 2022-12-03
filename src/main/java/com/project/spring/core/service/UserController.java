package com.project.spring.core.service;

import com.project.spring.core.model.request.user.UserCreateRequest;
import com.project.spring.core.model.request.user.UserDeleteRequest;
import com.project.spring.core.model.request.user.UserQueryRequest;
import com.project.spring.core.model.request.user.UserUpdateRequest;
import com.project.spring.core.model.result.user.UserCreateResult;
import com.project.spring.core.model.result.user.UserDeleteResult;
import com.project.spring.core.model.result.user.UserQueryResult;
import com.project.spring.core.model.result.user.UserUpdateResult;

public interface UserController {
    UserCreateResult create(UserCreateRequest request);

    UserQueryResult query(UserQueryRequest request);

    UserUpdateResult update(UserUpdateRequest request);

    UserDeleteResult delete(UserDeleteRequest request);
}
