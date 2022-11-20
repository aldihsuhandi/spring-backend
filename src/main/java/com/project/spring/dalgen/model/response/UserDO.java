package com.project.spring.dalgen.model.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class UserDO implements Serializable {
    private static final long serialVersionUID = -6355199624791428470L;

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
