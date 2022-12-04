package com.project.spring.common.model.viewobject;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class FriendRequestVO implements Serializable {
    private static final long serialVersionUID = -2291990955777018536L;

    private UserVO receiver;
    private boolean isDeleted;
    private boolean isAccepted;
}