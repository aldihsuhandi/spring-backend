package com.project.spring.common.converter;

import com.project.spring.common.model.viewobject.UserVO;
import com.project.spring.core.model.result.user.UserCreateResult;
import com.project.spring.core.model.result.user.UserQueryResult;
import com.project.spring.dalgen.model.response.UserDO;

public class UserVOConverter {
    public static UserVO toViewObject(UserDO userDO) {
        UserVO userVO = new UserVO();

        userVO.setUserId(userDO.getUserId());
        userVO.setEmail(userDO.getEmail());
        userVO.setBanner(userDO.getBanner());
        userVO.setStatus(userDO.getStatus());
        userVO.setPassword(userDO.getPassword());
        userVO.setUsername(userDO.getUsername());
        userVO.setActive(userDO.isActive());
        userVO.setProfilePicture(userDO.getProfilePicture());
        userVO.setGmtCreate(userDO.getGmtCreate());
        userVO.setGmtModified(userDO.getGmtModified());

        return userVO;
    }

    public static void toResult(UserVO userVO, UserCreateResult result) {
        result.setUserId(userVO.getUserId());
    }

    public static void toResult(UserVO userVO, UserQueryResult result) {
        result.setUserId(userVO.getUserId());
        result.setEmail(userVO.getEmail());
        result.setUsername(userVO.getUsername());
        result.setBanner(userVO.getBanner());
        result.setProfilePicture(userVO.getProfilePicture());
        result.setStatus(userVO.getStatus());
        result.setActive(userVO.isActive());
        result.setGmtCreate(userVO.getGmtCreate());
        result.setGmtModified(userVO.getGmtModified());
    }
}
