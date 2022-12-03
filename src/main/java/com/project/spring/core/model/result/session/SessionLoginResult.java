package com.project.spring.core.model.result.session;

import com.project.spring.core.model.result.BaseResult;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class SessionLoginResult extends BaseResult {
    private String sessionId;
    private Date sessionDt;
}
