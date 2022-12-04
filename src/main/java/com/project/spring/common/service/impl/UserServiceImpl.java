package com.project.spring.common.service.impl;

import com.project.spring.common.converter.UserVOConverter;
import com.project.spring.common.model.enumeration.SpringErrorCodeEnum;
import com.project.spring.common.model.exception.SpringException;
import com.project.spring.common.model.request.user.UserCreateInnerRequest;
import com.project.spring.common.model.request.user.UserDeleteInnerRequest;
import com.project.spring.common.model.request.user.UserQueryInnerRequest;
import com.project.spring.common.model.request.user.UserQueryListInnerRequest;
import com.project.spring.common.model.request.user.UserUpdateInnerRequest;
import com.project.spring.common.model.viewobject.UserVO;
import com.project.spring.common.service.UserService;
import com.project.spring.common.util.AssertUtil;
import com.project.spring.dalgen.converter.UserDaoRequestConverter;
import com.project.spring.dalgen.model.request.UserDAORequest;
import com.project.spring.dalgen.model.response.UserDO;
import com.project.spring.dalgen.service.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    @Override
    public UserVO queryById(UserQueryInnerRequest request) throws SpringException {
        UserDAORequest daoRequest = UserDaoRequestConverter.toDAORequest(request);

        UserDO userDO = userDAO.queryByUserId(daoRequest);
        AssertUtil.isNotNull(userDO, "user", SpringErrorCodeEnum.USER_NOT_FOUND);

        return UserVOConverter.toViewObject(userDO);
    }

    @Override
    public UserVO queryByUsername(UserQueryInnerRequest request) throws SpringException {
        UserDAORequest daoRequest = UserDaoRequestConverter.toDAORequest(request);

        UserDO userDO = userDAO.queryByUsername(daoRequest);
        AssertUtil.isNotNull(userDO, "user", SpringErrorCodeEnum.USER_NOT_FOUND);

        return UserVOConverter.toViewObject(userDO);
    }

    @Override
    public UserVO queryByEmail(UserQueryInnerRequest request) throws SpringException {
        UserDAORequest daoRequest = UserDaoRequestConverter.toDAORequest(request);

        UserDO userDO = userDAO.queryByEmail(daoRequest);
        AssertUtil.isNotNull(userDO, "user", SpringErrorCodeEnum.USER_NOT_FOUND);

        return UserVOConverter.toViewObject(userDO);
    }

    @Override
    public List<UserVO> queryListById(UserQueryListInnerRequest request) {
        List<UserDAORequest> daoRequests = UserDaoRequestConverter.toDAORequest(request);

        List<UserDO> userDOS = userDAO.queryUserListById(daoRequests);

        return userDOS.stream().map(UserVOConverter::toViewObject).collect(Collectors.toList());
    }

    @Override
    public List<UserVO> queryListByEmail(UserQueryListInnerRequest request) {
        List<UserDAORequest> daoRequests = UserDaoRequestConverter.toDAORequest(request);

        List<UserDO> userDOS = userDAO.queryUserListByEmail(daoRequests);

        return userDOS.stream().map(UserVOConverter::toViewObject).collect(Collectors.toList());
    }

    @Override
    public List<UserVO> queryListByUsername(UserQueryListInnerRequest request) {
        List<UserDAORequest> daoRequests = UserDaoRequestConverter.toDAORequest(request);

        List<UserDO> userDOS = userDAO.queryUserListByUsername(daoRequests);

        return userDOS.stream().map(UserVOConverter::toViewObject).collect(Collectors.toList());
    }

    @Override
    public void update(UserUpdateInnerRequest request) throws SpringException {
        UserDAORequest daoRequest = UserDaoRequestConverter.toDAORequest(request);
        userDAO.update(daoRequest);
    }

    @Override
    public void delete(UserDeleteInnerRequest request) throws SpringException {
        UserDAORequest daoRequest = UserDaoRequestConverter.toDAORequest(request);
        userDAO.delete(daoRequest);
    }

    public String encryptPassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    private String generateUserId() {
        return UUID.randomUUID().toString();
    }
}
