package com.project.spring.common.model.request.user;

import com.project.spring.common.model.request.BaseInnerRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class UserQueryListInnerRequest extends BaseInnerRequest {
    private List<UserQueryInnerRequest> requests;
}
