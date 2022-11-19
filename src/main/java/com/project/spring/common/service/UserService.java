package com.project.spring.common.service;

import com.project.spring.common.model.exception.SpringException;
import com.project.spring.common.model.request.UserCreateInnerRequest;
import com.project.spring.common.model.request.UserQueryInnerRequest;
import com.project.spring.common.model.viewobject.UserVO;

public interface UserService {
    UserVO create(UserCreateInnerRequest request) throws SpringException;

    UserVO queryById(UserQueryInnerRequest request) throws SpringException;

    UserVO queryByUsername(UserQueryInnerRequest request) throws SpringException;

    UserVO queryByEmail(UserQueryInnerRequest request) throws SpringException;
}
