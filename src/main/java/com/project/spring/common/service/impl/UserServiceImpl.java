package com.project.spring.common.service.impl;

import com.project.spring.common.constant.CommonConst;
import com.project.spring.common.converter.UserVOConverter;
import com.project.spring.common.model.enumeration.SpringErrorCodeEnum;
import com.project.spring.common.model.exception.SpringException;
import com.project.spring.common.model.request.user.UserCreateInnerRequest;
import com.project.spring.common.model.request.user.UserDeleteInnerRequest;
import com.project.spring.common.model.request.user.UserQueryInnerRequest;
import com.project.spring.common.model.request.user.UserQueryListInnerRequest;
import com.project.spring.common.model.request.user.UserUpdateCacheInnerRequest;
import com.project.spring.common.model.request.user.UserUpdateInnerRequest;
import com.project.spring.common.model.viewobject.UserVO;
import com.project.spring.common.service.UserService;
import com.project.spring.common.util.AssertUtil;
import com.project.spring.core.converter.UserRequestConverter;
import com.project.spring.core.fetch.UserCache;
import com.project.spring.dalgen.converter.UserDaoRequestConverter;
import com.project.spring.dalgen.model.request.UserDAORequest;
import com.project.spring.dalgen.model.response.UserDO;
import com.project.spring.dalgen.service.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Qualifier("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userDAO")
    private UserDAO userDAO;

    @Autowired
    @Qualifier("userCache")
    private UserCache userCache;

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

        if (userCache.isExist(daoRequest.getUserId(), CommonConst.USER_ID) && request.isUseCache()) {
            return userCache.fetch(daoRequest.getUserId(), CommonConst.USER_ID);
        }

        UserDO userDO = userDAO.queryByUserId(daoRequest);
        AssertUtil.isNotNull(userDO, "user", SpringErrorCodeEnum.USER_NOT_FOUND);

        UserVO userVO = UserVOConverter.toViewObject(userDO);
        userCache.put(userVO);

        return userVO;
    }

    @Override
    public UserVO queryByUsername(UserQueryInnerRequest request) throws SpringException {
        UserDAORequest daoRequest = UserDaoRequestConverter.toDAORequest(request);

        if (userCache.isExist(daoRequest.getUsername(), CommonConst.USERNAME) && request.isUseCache()) {
            return userCache.fetch(daoRequest.getUsername(), CommonConst.USERNAME);
        }

        UserDO userDO = userDAO.queryByUsername(daoRequest);
        AssertUtil.isNotNull(userDO, "user", SpringErrorCodeEnum.USER_NOT_FOUND);

        UserVO userVO = UserVOConverter.toViewObject(userDO);
        userCache.put(userVO);

        return userVO;
    }

    @Override
    public UserVO queryByEmail(UserQueryInnerRequest request) throws SpringException {
        UserDAORequest daoRequest = UserDaoRequestConverter.toDAORequest(request);

        if (userCache.isExist(daoRequest.getEmail(), CommonConst.EMAIL) && request.isUseCache()) {
            return userCache.fetch(daoRequest.getEmail(), CommonConst.EMAIL);
        }

        UserDO userDO = userDAO.queryByEmail(daoRequest);
        AssertUtil.isNotNull(userDO, "user", SpringErrorCodeEnum.USER_NOT_FOUND);

        UserVO userVO = UserVOConverter.toViewObject(userDO);
        userCache.put(userVO);

        return userVO;
    }

    @Override
    public List<UserVO> queryAll() throws SpringException {
        List<UserDO> userDOS = userDAO.queryAll();

        return userDOS.stream().map(userDO -> {
            UserVO userVO = UserVOConverter.toViewObject(userDO);
            userCache.put(userVO);

            return userVO;
        }).collect(Collectors.toList());
    }

    @Override
    public List<UserVO> queryListById(UserQueryListInnerRequest request) {

        List<UserVO> userVOS = new ArrayList<>();

        for (UserQueryInnerRequest innerRequest : request.getRequests()) {
            if (!(userCache.isExist(innerRequest.getUserId(), CommonConst.USER_ID) && innerRequest.isUseCache())) {
                continue;
            }

            try {
                userVOS.add(userCache.fetch(innerRequest.getUserId(), CommonConst.USER_ID));
                request.getRequests().remove(innerRequest);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        List<UserDAORequest> daoRequests = UserDaoRequestConverter.toDAORequest(request);

        List<UserDO> userDOS = userDAO.queryUserListById(daoRequests);

        userVOS.addAll(userDOS.stream().map(userDO -> {
            UserVO userVO = UserVOConverter.toViewObject(userDO);
            userCache.put(userVO);

            return userVO;
        }).collect(Collectors.toList()));

        return userVOS;
    }

    @Override
    public List<UserVO> queryListByEmail(UserQueryListInnerRequest request) {
        List<UserVO> userVOS = new ArrayList<>();
        for (UserQueryInnerRequest innerRequest : request.getRequests()) {
            if (!(userCache.isExist(innerRequest.getEmail(), CommonConst.EMAIL) && innerRequest.isUseCache())) {
                continue;
            }

            try {
                userVOS.add(userCache.fetch(innerRequest.getEmail(), CommonConst.EMAIL));
                request.getRequests().remove(innerRequest);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        List<UserDAORequest> daoRequests = UserDaoRequestConverter.toDAORequest(request);

        List<UserDO> userDOS = userDAO.queryUserListByEmail(daoRequests);

        userVOS.addAll(userDOS.stream().map(userDO -> {
            UserVO userVO = UserVOConverter.toViewObject(userDO);
            userCache.put(userVO);

            return userVO;
        }).collect(Collectors.toList()));

        return userVOS;
    }

    @Override
    public List<UserVO> queryListByUsername(UserQueryListInnerRequest request) {
        List<UserVO> userVOS = new ArrayList<>();
        for (UserQueryInnerRequest innerRequest : request.getRequests()) {
            if (!(userCache.isExist(innerRequest.getUsername(), CommonConst.USERNAME) && innerRequest.isUseCache())) {
                continue;
            }

            try {
                userVOS.add(userCache.fetch(innerRequest.getUsername(), CommonConst.USERNAME));
                request.getRequests().remove(innerRequest);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        List<UserDAORequest> daoRequests = UserDaoRequestConverter.toDAORequest(request);

        List<UserDO> userDOS = userDAO.queryUserListByUsername(daoRequests);

        userVOS.addAll(userDOS.stream().map(userDO -> {
            UserVO userVO = UserVOConverter.toViewObject(userDO);
            userCache.put(userVO);

            return userVO;
        }).collect(Collectors.toList()));

        return userVOS;
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

    @Override
    public void updateCache(UserUpdateCacheInnerRequest request) throws SpringException {
        if (request.isUpdateAll()) {
            throw new SpringException("Method Not Supported", SpringErrorCodeEnum.SYSTEM_BUSY);
        }

        for (String key : request.getKeys()) {
            UserQueryInnerRequest queryRequest = UserRequestConverter.toInnerRequest(key, request.getIdentifier(), false);
            if (CommonConst.USER_ID.equals(request.getIdentifier())) {
                this.queryById(queryRequest);
            } else if (CommonConst.EMAIL.equals(request.getIdentifier())) {
                this.queryByEmail(queryRequest);
            } else if (CommonConst.USERNAME.equals(request.getIdentifier())) {
                this.queryByUsername(queryRequest);
            }
        }
    }

    public String encryptPassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    private String generateUserId() {
        return UUID.randomUUID().toString();
    }
}
