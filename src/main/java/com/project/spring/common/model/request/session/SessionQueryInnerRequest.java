package com.project.spring.common.model.request.session;

import com.project.spring.common.model.request.BaseInnerRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SessionQueryInnerRequest extends BaseInnerRequest {
    private String sessionId;
}
