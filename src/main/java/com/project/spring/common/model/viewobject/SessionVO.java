package com.project.spring.common.model.viewobject;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class SessionVO implements Serializable {
    private static final long serialVersionUID = 6011854379092129327L;

    private String sessionId;
    private String userId;
    private boolean isActive;
    private Date sessionDt;
    private Date gmtCreate;
    private Date gmtModified;
}
