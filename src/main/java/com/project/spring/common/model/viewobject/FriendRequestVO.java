package com.project.spring.common.model.viewobject;

import java.io.Serializable;

public class FriendRequestVO implements Serializable {
    private static final long serialVersionUID = -2291990955777018536L;

    private UserVO receiver;
    private boolean isDeleted;
    private boolean isAccepted;
}