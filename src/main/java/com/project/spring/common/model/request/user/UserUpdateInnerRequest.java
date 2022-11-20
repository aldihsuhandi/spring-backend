package com.project.spring.common.model.request.user;

import com.project.spring.common.model.request.BaseInnerRequest;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserUpdateInnerRequest extends BaseInnerRequest {
    private String userId;
    private String username;
    private String email;
    private String status;
    private String password;
    private String banner;
    private String profilePicture;
}
