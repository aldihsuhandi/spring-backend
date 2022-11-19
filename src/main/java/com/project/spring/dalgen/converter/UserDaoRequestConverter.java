package com.project.spring.dalgen.converter;

import com.project.spring.common.model.request.UserCreateInnerRequest;
import com.project.spring.common.model.request.UserQueryInnerRequest;
import com.project.spring.common.util.StringUtil;
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
        if (StringUtil.isNotEmpty(innerRequest.getUserId())) {
            request.setUserId(innerRequest.getUserId());
        }

        if (StringUtil.isNotEmpty(innerRequest.getUsername())) {
            request.setUsername(innerRequest.getUsername());
        }

        if (StringUtil.isNotEmpty(innerRequest.getEmail())) {
            request.setEmail(innerRequest.getEmail());
        }

        return request;
    }
}
