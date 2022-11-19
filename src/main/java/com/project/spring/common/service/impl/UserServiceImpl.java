package com.project.spring.common.service.impl;

import com.project.spring.common.converter.UserVOConverter;
import com.project.spring.common.model.exception.SpringException;
import com.project.spring.common.model.request.UserCreateInnerRequest;
import com.project.spring.common.model.viewobject.UserVO;
import com.project.spring.common.service.UserService;
import com.project.spring.dalgen.converter.UserDaoRequestConverter;
import com.project.spring.dalgen.model.request.UserDAORequest;
import com.project.spring.dalgen.model.response.UserDO;
import com.project.spring.dalgen.service.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Qualifier("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userDAO")
    UserDAO userDAO;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserVO create(UserCreateInnerRequest request) throws SpringException {
        UserDAORequest daoRequest = UserDaoRequestConverter.toDAORequest(request);

        daoRequest.setPassword(encryptPassword(daoRequest.getPassword()));
        daoRequest.setUserId(generateUserId());

        UserDO userDO = userDAO.createUser(daoRequest);
        return UserVOConverter.toViewObject(userDO);
    }

    private String encryptPassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    private String generateUserId() {
        return UUID.randomUUID().toString();
    }
}