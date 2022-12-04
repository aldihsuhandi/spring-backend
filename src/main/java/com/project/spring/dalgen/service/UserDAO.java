package com.project.spring.dalgen.service;

import com.project.spring.common.model.exception.SpringException;
import com.project.spring.dalgen.model.request.UserDAORequest;
import com.project.spring.dalgen.model.response.UserDO;

import java.util.List;

public interface UserDAO {
    UserDO createUser(UserDAORequest request) throws SpringException;

    UserDO queryByUserId(UserDAORequest request);

    UserDO queryByUsername(UserDAORequest request);

    UserDO queryByEmail(UserDAORequest request);

    List<UserDO> queryUserListById(List<UserDAORequest> requests);

    List<UserDO> queryUserListByUsername(List<UserDAORequest> requests);

    List<UserDO> queryUserListByEmail(List<UserDAORequest> requests);

    void update(UserDAORequest request) throws SpringException;

    void delete(UserDAORequest request) throws SpringException;
}
