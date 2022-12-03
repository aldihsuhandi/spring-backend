package com.project.spring.core.model.request.session;

import com.project.spring.core.model.request.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SessionLogoutRequest extends BaseRequest {
    private String sessionId;
}
