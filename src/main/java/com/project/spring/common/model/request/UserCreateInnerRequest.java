package com.project.spring.common.model.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserCreateInnerRequest {
    private String userId;
    private String email;
    private String username;
    private String password;
    private Date gmtCreate;
    private Date gmtModified;
}
