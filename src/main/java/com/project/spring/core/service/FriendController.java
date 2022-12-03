package com.project.spring.core.service;

import com.project.spring.core.model.request.friend.AcceptFriendRequest;
import com.project.spring.core.model.request.friend.AddFriendRequest;
import com.project.spring.core.model.request.friend.RejectFriendRequest;
import com.project.spring.core.model.result.friend.AcceptFriendResult;
import com.project.spring.core.model.result.friend.AddFriendResult;
import com.project.spring.core.model.result.friend.RejectFriendResult;

public interface FriendController {
    AddFriendResult addFriend(AddFriendRequest request);

    AcceptFriendResult acceptFriend(AcceptFriendRequest request);

    RejectFriendResult rejectFriend(RejectFriendRequest request);
}
