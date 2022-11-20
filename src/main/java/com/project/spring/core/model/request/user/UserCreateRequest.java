package com.project.spring.core.model.request.user;

import com.project.spring.core.model.request.BaseRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserCreateRequest extends BaseRequest {
    private String username;
    private String email;
    private String password;
}
