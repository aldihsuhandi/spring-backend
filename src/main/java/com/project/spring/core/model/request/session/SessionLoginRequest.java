package com.project.spring.core.model.request.session;

import com.project.spring.core.model.request.BaseRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SessionLoginRequest extends BaseRequest {
    private String username;
    private boolean isRemembered;
}
