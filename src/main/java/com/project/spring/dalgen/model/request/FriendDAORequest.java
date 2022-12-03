package com.project.spring.dalgen.model.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class FriendDAORequest implements Serializable {
    private static final long serialVersionUID = -1480102911702203501L;

    private String userId;
    private String friendId;
    private boolean isBlocked;
    private Date gmtCreate;
    private Date gmtModified;
}
