package com.project.spring.common.model.request.user;

import com.project.spring.common.model.request.BaseInnerRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class UserDeleteInnerRequest extends BaseInnerRequest {
    private boolean isActive;
    private String userId;
    private Date gmtModified;
}
