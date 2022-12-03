package com.project.spring.core.model.request.session;

import com.project.spring.core.model.request.BaseRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SessionRefreshRequest extends BaseRequest {
    private String sessionId;
}
