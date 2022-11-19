package com.project.spring.common.converter;

import com.project.spring.common.model.viewobject.UserVO;
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
        userVO.setGmtCreate(userDO.getGmtCreate());
        userVO.setGmtModified(userDO.getGmtModified());
        userVO.setProfilePicture(userDO.getProfilePicture());

        return userVO;
    }
}
