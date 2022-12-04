package com.project.spring.common.service;

import com.project.spring.common.model.exception.SpringException;
import com.project.spring.common.model.request.user.UserCreateInnerRequest;
import com.project.spring.common.model.request.user.UserDeleteInnerRequest;
import com.project.spring.common.model.request.user.UserQueryInnerRequest;
import com.project.spring.common.model.request.user.UserQueryListInnerRequest;
import com.project.spring.common.model.request.user.UserUpdateCacheInnerRequest;
import com.project.spring.common.model.request.user.UserUpdateInnerRequest;
import com.project.spring.common.model.viewobject.UserVO;

import java.util.List;

public interface UserService {
    UserVO create(UserCreateInnerRequest request) throws SpringException;

    UserVO queryById(UserQueryInnerRequest request) throws SpringException;

    UserVO queryByUsername(UserQueryInnerRequest request) throws SpringException;

    UserVO queryByEmail(UserQueryInnerRequest request) throws SpringException;

    List<UserVO> queryListById(UserQueryListInnerRequest request) throws SpringException;

    List<UserVO> queryListByEmail(UserQueryListInnerRequest request);

    List<UserVO> queryListByUsername(UserQueryListInnerRequest request);

    void update(UserUpdateInnerRequest request) throws SpringException;

    void delete(UserDeleteInnerRequest request) throws SpringException;

    void updateCache(UserUpdateCacheInnerRequest request) throws SpringException;

    String encryptPassword(String password);
}
