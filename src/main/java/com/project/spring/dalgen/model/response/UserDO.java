package com.project.spring.dalgen.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserDO {
    private String userId;
    private String email;
    private String username;
    private String password;
    private String profilePicture;
    private String banner;
    private String status;
    private boolean isActive;
    private Date gmtCreate;
    private Date gmtModified;
}
