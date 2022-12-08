package com.project.spring.common.model.request.friend;

import com.project.spring.common.model.request.BaseInnerRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class QueryFriendInnerRequest extends BaseInnerRequest {
    private String userId;
}