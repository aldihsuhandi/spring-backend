package com.project.spring.core.model.result.friend;

import com.project.spring.common.model.viewobject.FriendRequestVO;
import com.project.spring.core.model.result.BaseResult;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class QueryFriendRequestListResult extends BaseResult {
    private List<FriendRequestVO> friendRequestVOS;
}