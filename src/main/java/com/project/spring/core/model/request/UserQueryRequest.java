package com.project.spring.core.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserQueryRequest extends BaseRequest {
    private String userId;
    private String email;
    private String username;
}
