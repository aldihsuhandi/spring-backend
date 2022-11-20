package com.project.spring.core.model.request.user;

import com.project.spring.core.model.request.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDeleteRequest extends BaseRequest {
    private String email;
}
