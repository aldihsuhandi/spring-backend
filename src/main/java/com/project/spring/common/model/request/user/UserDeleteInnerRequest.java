package com.project.spring.common.model.request.user;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class UserDeleteInnerRequest {
    private boolean isActive;
    private String userId;
    private Date gmtModified;
}
