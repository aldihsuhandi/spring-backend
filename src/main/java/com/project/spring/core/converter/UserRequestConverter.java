package com.project.spring.core.converter;

import com.project.spring.common.model.request.UserCreateInnerRequest;
import com.project.spring.common.model.request.UserQueryInnerRequest;
import com.project.spring.common.model.request.UserUpdateInnerRequest;
import com.project.spring.common.model.viewobject.UserVO;
import com.project.spring.common.util.StringUtil;
import com.project.spring.core.model.request.UserCreateRequest;
import com.project.spring.core.model.request.UserQueryRequest;
import com.project.spring.core.model.request.UserUpdateRequest;

public class UserRequestConverter {
    public static UserCreateInnerRequest toInnerRequest(UserCreateRequest request) {
        UserCreateInnerRequest innerRequest = new UserCreateInnerRequest();

        innerRequest.setEmail(request.getEmail());
        innerRequest.setUsername(request.getUsername());
        innerRequest.setPassword(request.getPassword());

        return innerRequest;
    }

    public static UserQueryInnerRequest toInnerRequest(UserQueryRequest request) {
        UserQueryInnerRequest innerRequest = new UserQueryInnerRequest();
        innerRequest.setEmail(request.getEmail());
        innerRequest.setUsername(request.getUsername());
        innerRequest.setUserId(request.getUserId());

        return innerRequest;
    }

    public static UserUpdateInnerRequest toInnerRequest(UserUpdateRequest request, UserVO userVO) {
        UserUpdateInnerRequest updateInnerRequest = new UserUpdateInnerRequest();

        updateInnerRequest.setUserId(request.getUserId());
        updateInnerRequest.setUsername(StringUtil.defaultIfEmpty(
                request.getUsername(), userVO.getUsername()));
        updateInnerRequest.setEmail(StringUtil.defaultIfEmpty(
                request.getEmail(), userVO.getUsername()));
        updateInnerRequest.setStatus(StringUtil.defaultIfEmpty(
                request.getStatus(), userVO.getUsername()));
        updateInnerRequest.setPassword(StringUtil.defaultIfEmpty(
                request.getPassword(), userVO.getUsername()));
        updateInnerRequest.setBanner(StringUtil.defaultIfEmpty(
                request.getBanner(), userVO.getUsername()));
        updateInnerRequest.setProfilePicture(StringUtil.defaultIfEmpty(
                request.getProfilePicture(), userVO.getUsername()));

        return updateInnerRequest;
    }
}
