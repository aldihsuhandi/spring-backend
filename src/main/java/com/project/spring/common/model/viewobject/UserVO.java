package com.project.spring.common.model.viewobject;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserVO {
    private String userId;
    private String email;
    private String username;
    private String password;
    private String profilePicture;
    private String banner;
    private String status;
    private Date gmtCreate;
    private Date gmtModified;
}
