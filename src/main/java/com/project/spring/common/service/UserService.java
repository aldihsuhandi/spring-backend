package com.project.spring.common.service;

import com.project.spring.common.model.exception.SpringException;
import com.project.spring.common.model.request.UserCreateInnerRequest;
import com.project.spring.common.model.viewobject.UserVO;

public interface UserService {
    UserVO create(UserCreateInnerRequest request) throws SpringException;
}
