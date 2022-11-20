package com.project.spring.common.model.viewobject;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class UserVO implements Serializable {
    private static final long serialVersionUID = 477714972530453539L;

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
