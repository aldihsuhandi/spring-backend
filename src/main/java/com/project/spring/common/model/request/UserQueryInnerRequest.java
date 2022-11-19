package com.project.spring.common.model.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserQueryInnerRequest {
    private String userId;
    private String email;
    private String username;
}
