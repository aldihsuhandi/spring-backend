package com.project.spring.common.model.request.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserUpdateInnerRequest {
    private String userId;
    private String username;
    private String email;
    private String status;
    private String password;
    private String banner;
    private String profilePicture;
}
