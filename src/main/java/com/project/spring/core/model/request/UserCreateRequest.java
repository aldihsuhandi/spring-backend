package com.project.spring.core.model.request;

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
