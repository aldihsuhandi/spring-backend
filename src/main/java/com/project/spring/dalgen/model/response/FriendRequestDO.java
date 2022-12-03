package com.project.spring.dalgen.model.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class FriendRequestDO implements Serializable {
    private static final long serialVersionUID = 361073157361131033L;

    private String requesterId;
    private String receiverId;
    private boolean isAccepted;
    private boolean isDeleted;
    private Date gmtCreate;
    private Date gmtModified;
}
