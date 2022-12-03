package com.project.spring.common.model.request.session;

import com.project.spring.common.model.request.BaseInnerRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class SessionLogoutInnerRequest extends BaseInnerRequest {
    private String sessionId;
    private Date gmtModified;
}
