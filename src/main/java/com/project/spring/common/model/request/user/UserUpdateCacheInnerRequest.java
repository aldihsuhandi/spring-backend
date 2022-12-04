package com.project.spring.common.model.request.user;

import com.project.spring.common.model.request.BaseInnerRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class UserUpdateCacheInnerRequest extends BaseInnerRequest {
    private List<String> keys;
    private String identifier;
    private boolean updateAll;
}
