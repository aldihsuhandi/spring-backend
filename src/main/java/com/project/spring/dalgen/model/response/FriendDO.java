package com.project.spring.dalgen.model.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class FriendDO implements Serializable {
    private static final long serialVersionUID = -1006050721071257708L;

    private String userId;
    private String friendId;
    private boolean isBlocked;
    private Date gmtCreate;
    private Date gmtModified;
}
