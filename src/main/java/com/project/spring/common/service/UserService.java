package com.project.spring.common.service;

import com.project.spring.common.model.exception.SpringException;
import com.project.spring.common.model.request.user.UserCreateInnerRequest;
import com.project.spring.common.model.request.user.UserDeleteInnerRequest;
import com.project.spring.common.model.request.user.UserQueryInnerRequest;
import com.project.spring.common.model.request.user.UserUpdateInnerRequest;
import com.project.spring.common.model.viewobject.UserVO;

public interface UserService {
    UserVO create(UserCreateInnerRequest request) throws SpringException;

    UserVO queryById(UserQueryInnerRequest request) throws SpringException;

    UserVO queryByUsername(UserQueryInnerRequest request) throws SpringException;

    UserVO queryByEmail(UserQueryInnerRequest request) throws SpringException;

    void update(UserUpdateInnerRequest request) throws SpringException;

    void delete(UserDeleteInnerRequest request) throws SpringException;

    String encryptPassword(String password);
}
