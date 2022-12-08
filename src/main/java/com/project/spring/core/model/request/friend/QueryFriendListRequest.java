package com.project.spring.core.model.request.friend;

import com.project.spring.core.model.request.BaseRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class QueryFriendListRequest extends BaseRequest {
    private String email;
}
