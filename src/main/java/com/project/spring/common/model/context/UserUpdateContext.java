package com.project.spring.common.model.context;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class UserUpdateContext implements Serializable {

    private static final long serialVersionUID = -4099953766222712471L;

    private String username;
    private String email;
    private String status;
    private String password;
    private String banner;
    private String profilePicture;
}
