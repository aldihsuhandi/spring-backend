package com.project.spring.core.model.request.friend;

import com.project.spring.core.model.request.BaseRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RejectFriendRequest extends BaseRequest {
    private String receiverUsername;
    private String requesterUsername;
}
