package com.project.spring.common.model.request.session;

import com.project.spring.common.model.request.BaseInnerRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class SessionUpdateInnerRequest extends BaseInnerRequest {
    private Date sessionDt;
    private Date gmtModified;
}
