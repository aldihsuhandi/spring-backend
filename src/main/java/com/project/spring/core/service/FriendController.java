package com.project.spring.core.service;

import com.project.spring.core.model.request.friend.AddFriendRequest;
import com.project.spring.core.model.result.friend.AddFriendResult;

public interface FriendController {
    AddFriendResult addFriend(AddFriendRequest request);
}
