package com.project.spring.dalgen.model.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class SessionDO implements Serializable {
    private static final long serialVersionUID = -9065219288302576612L;

    private String sessionId;
    private String userId;
    private boolean isActive;
    private Date sessionDt;
    private Date gmtCreate;
    private Date gmtModified;
}