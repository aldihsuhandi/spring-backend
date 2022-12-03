package com.project.spring.core.model.result.user;

import com.project.spring.core.model.result.BaseResult;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class UserQueryResult extends BaseResult {
    private String userId;
    private String email;
    private String username;
    private String profilePicture;
    private String banner;
    private String status;
    private boolean isActive;
    private Date gmtCreate;
    private Date gmtModified;
}
