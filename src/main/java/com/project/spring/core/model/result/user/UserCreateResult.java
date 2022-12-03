package com.project.spring.core.model.result.user;

import com.project.spring.core.model.result.BaseResult;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateResult extends BaseResult {
    private String userId;
}
