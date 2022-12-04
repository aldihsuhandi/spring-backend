package com.project.spring.common.model.request.user;

import com.project.spring.common.model.request.BaseInnerRequest;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserQueryInnerRequest extends BaseInnerRequest {
    private String userId;
    private String email;
    private String username;
    private boolean useCache;
}
