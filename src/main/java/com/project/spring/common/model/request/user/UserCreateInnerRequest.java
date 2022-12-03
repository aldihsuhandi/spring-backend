package com.project.spring.common.model.request.user;

import com.project.spring.common.model.request.BaseInnerRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserCreateInnerRequest extends BaseInnerRequest {
    private String userId;
    private String email;
    private String username;
    private String password;
    private Date gmtCreate;
    private Date gmtModified;
}
