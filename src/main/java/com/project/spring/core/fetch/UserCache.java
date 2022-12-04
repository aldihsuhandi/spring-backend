package com.project.spring.core.fetch;

import com.project.spring.common.constant.CommonConst;
import com.project.spring.common.model.enumeration.SpringErrorCodeEnum;
import com.project.spring.common.model.exception.SpringException;
import com.project.spring.common.model.viewobject.UserVO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Qualifier("userCache")
public class UserCache {
    private final Map<String, UserVO> userCacheMap = new HashMap<>();
    private final Map<String, String> usernameCache = new HashMap<>();
    private final Map<String, String> emailCache = new HashMap<>();

    public void put(UserVO userVO) {
        String username = userVO.getUsername();
        String email = userVO.getEmail();
        String userId = userVO.getUserId();

        usernameCache.put(username, userId);
        emailCache.put(email, userId);

        userCacheMap.put(userId, userVO);
    }

    public void put(List<UserVO> userVOS) {
        for (UserVO user : userVOS) {
            put(user);
        }
    }

    public boolean isExist(String key, String identifier) {
        if (CommonConst.USER_ID.equals(identifier)) {
            return userCacheMap.containsKey(key);
        }

        if (CommonConst.USERNAME.equals(identifier)) {
            return usernameCache.containsKey(key) && userCacheMap.containsKey(usernameCache.get(key));
        }

        if (CommonConst.EMAIL.equals(identifier)) {
            return emailCache.containsKey(key) && userCacheMap.containsKey(emailCache.get(key));
        }

        return false;
    }

    public UserVO fetch(String key, String identifier) throws SpringException {
        String userId = getUserId(key, identifier);
        return userCacheMap.get(userId);
    }

    private String getUserId(String key, String identifier) throws SpringException {
        if (CommonConst.USER_ID.equals(identifier)) {
            return key;
        } else if (CommonConst.EMAIL.equals(identifier)) {
            return emailCache.get(key);
        } else if (CommonConst.USERNAME.equals(identifier)) {
            return usernameCache.get(key);
        }

        throw new SpringException("Bad Request", SpringErrorCodeEnum.SYSTEM_BUSY);
    }
}