package com.project.spring.core.converter;

import com.project.spring.common.constant.CommonConst;
import com.project.spring.common.model.context.UserUpdateContext;
import com.project.spring.common.model.request.user.UserCreateInnerRequest;
import com.project.spring.common.model.request.user.UserDeleteInnerRequest;
import com.project.spring.common.model.request.user.UserQueryInnerRequest;
import com.project.spring.common.model.request.user.UserQueryListInnerRequest;
import com.project.spring.common.model.request.user.UserUpdateCacheInnerRequest;
import com.project.spring.common.model.request.user.UserQueryListInnerRequest;
import com.project.spring.common.model.request.user.UserUpdateInnerRequest;
import com.project.spring.common.model.viewobject.UserVO;
import com.project.spring.common.util.StringUtil;
import com.project.spring.core.model.request.user.UserCreateRequest;
import com.project.spring.core.model.request.user.UserDeleteRequest;
import com.project.spring.core.model.request.user.UserQueryRequest;
import com.project.spring.core.model.request.user.UserUpdateRequest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class UserRequestConverter {
    public static UserCreateInnerRequest toInnerRequest(UserCreateRequest request) {
        UserCreateInnerRequest innerRequest = new UserCreateInnerRequest();

        innerRequest.setEmail(request.getEmail());
        innerRequest.setUsername(request.getUsername());
        innerRequest.setPassword(request.getPassword());

        return innerRequest;
    }

    public static UserQueryInnerRequest toInnerRequest(UserQueryRequest request, boolean useCache) {
        UserQueryInnerRequest innerRequest = new UserQueryInnerRequest();
        innerRequest.setEmail(request.getEmail());
        innerRequest.setUsername(request.getUsername());
        innerRequest.setUserId(request.getUserId());
        innerRequest.setUseCache(useCache);

        return innerRequest;
    }

    public static UserQueryInnerRequest toInnerRequest(String value, String key, boolean useCache) {
        UserQueryInnerRequest request = new UserQueryInnerRequest();
        switch (key) {
            case CommonConst.EMAIL:
                request.setEmail(value);
                break;

            case CommonConst.USER_ID:
                request.setUserId(value);
                break;

            case CommonConst.USERNAME:
                request.setUsername(value);
                break;
        }

        request.setUseCache(useCache);

        return request;
    }

    public static UserUpdateInnerRequest toInnerRequest(UserUpdateRequest request, UserVO userVO) {
        UserUpdateInnerRequest updateInnerRequest = new UserUpdateInnerRequest();
        UserUpdateContext updateContext = request.getUpdateContext();

        updateInnerRequest.setUserId(userVO.getUserId());
        updateInnerRequest.setUsername(StringUtil.defaultIfEmpty(
                updateContext.getUsername(), userVO.getUsername()));
        updateInnerRequest.setEmail(StringUtil.defaultIfEmpty(
                updateContext.getEmail(), userVO.getEmail()));
        updateInnerRequest.setStatus(StringUtil.defaultIfEmpty(
                updateContext.getStatus(), userVO.getStatus()));
        updateInnerRequest.setPassword(StringUtil.defaultIfEmpty(
                updateContext.getPassword(), userVO.getPassword()));
        updateInnerRequest.setBanner(StringUtil.defaultIfEmpty(
                updateContext.getBanner(), userVO.getBanner()));
        updateInnerRequest.setProfilePicture(StringUtil.defaultIfEmpty(
                updateContext.getProfilePicture(), userVO.getProfilePicture()));

        return updateInnerRequest;
    }

    public static UserDeleteInnerRequest toInnerRequest(UserDeleteRequest request, UserVO userVO) {
        UserDeleteInnerRequest innerRequest = new UserDeleteInnerRequest();
        innerRequest.setUserId(userVO.getUserId());
        innerRequest.setActive(false);
        innerRequest.setGmtModified(new Date());

        return innerRequest;
    }

    public static UserUpdateCacheInnerRequest toInnerRequest(List<String> userIds, String identifier) {
        UserUpdateCacheInnerRequest innerRequest = new UserUpdateCacheInnerRequest();
        innerRequest.setUpdateAll(false);
        innerRequest.setKeys(userIds);
        innerRequest.setIdentifier(identifier);

        return innerRequest;
    }

    public static UserUpdateCacheInnerRequest toInnerRequest(String userId, String identifier) {
        List<String> userIds = new ArrayList<>();
        userIds.add(userId);

        return toInnerRequest(userIds, identifier);
    }

    public static UserUpdateCacheInnerRequest toInnerRequest() {
        UserUpdateCacheInnerRequest innerRequest = new UserUpdateCacheInnerRequest();
        innerRequest.setUpdateAll(false);

        return innerRequest;
    }

    public static UserQueryListInnerRequest toInnerRequest(List<String> values, String key, boolean useCache) {
        UserQueryListInnerRequest innerRequest = new UserQueryListInnerRequest();
        innerRequest.setRequests(
                values.stream().map(value ->
                        toInnerRequest(value, key, useCache)).collect(Collectors.toList())
        );

        return innerRequest;
    }
}
