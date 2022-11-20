package com.project.spring.core.model.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserUpdateRequest extends BaseRequest {
    private String userId;
    private String username;
    private String email;
    private String status;
    private String password;
    private String banner;
    private String profilePicture;
}
