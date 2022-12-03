package com.project.spring.dalgen.model.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class SessionDAORequest implements Serializable {
    private static final long serialVersionUID = 4738069807985389230L;

    private String sessionId;
    private String userId;
    private boolean isActive;
    private boolean isRemembered;
    private Date sessionDt;
    private Date gmtCreate;
    private Date gmtModified;
}
