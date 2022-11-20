package com.project.spring.core.model.request.user;

import com.project.spring.common.model.context.UserUpdateContext;
import com.project.spring.core.model.request.BaseRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserUpdateRequest extends BaseRequest {
    private String email;
    UserUpdateContext updateContext;
}
