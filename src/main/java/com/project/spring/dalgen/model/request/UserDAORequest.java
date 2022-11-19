package com.project.spring.dalgen.model.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class UserDAORequest implements Serializable {
    private static final long serialVersionUID = -5891443408696754985L;

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
