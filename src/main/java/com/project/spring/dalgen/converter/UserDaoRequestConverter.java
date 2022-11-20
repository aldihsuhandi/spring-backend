package com.project.spring.dalgen.converter;

import com.project.spring.common.model.request.UserCreateInnerRequest;
import com.project.spring.common.model.request.UserQueryInnerRequest;
import com.project.spring.common.model.request.UserUpdateInnerRequest;
import com.project.spring.dalgen.model.request.UserDAORequest;

import java.util.Date;

public class UserDaoRequestConverter {
    public static UserDAORequest toDAORequest(UserCreateInnerRequest request) {
        UserDAORequest req = new UserDAORequest();

        req.setUserId(request.getUserId());
        req.setEmail(request.getEmail());
        req.setPassword(request.getPassword());
        req.setUsername(request.getUsername());
        req.setGmtCreate(new Date());
        req.setGmtModified(new Date());

        return req;
    }

    public static UserDAORequest toDAORequest(UserQueryInnerRequest innerRequest) {
        UserDAORequest request = new UserDAORequest();
        request.setUserId(innerRequest.getUserId());
        request.setUsername(innerRequest.getUsername());
        request.setEmail(innerRequest.getEmail());

        return request;
    }

    public static UserDAORequest toDAORequest(UserUpdateInnerRequest innerRequest) {
        UserDAORequest req = new UserDAORequest();

        req.setUserId(innerRequest.getUserId());
        req.setEmail(innerRequest.getEmail());
        req.setPassword(innerRequest.getPassword());
        req.setUsername(innerRequest.getUsername());
        req.setBanner(innerRequest.getBanner());
        req.setProfilePicture(innerRequest.getProfilePicture());
        req.setStatus(innerRequest.getStatus());
        req.setGmtModified(new Date());

        System.out.printf("DEBUG[DAORequest=%s]\n", req.toString());

        return req;
    }
}
