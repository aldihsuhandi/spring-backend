package com.project.spring.dalgen.model.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class FriendRequestDAORequest implements Serializable {
    private static final long serialVersionUID = 6097410499819214262L;

    private String requesterId;
    private String receiverId;
    private boolean isAccepted;
    private boolean isDeleted;
    private Date gmtCreate;
    private Date gmtModified;
}
