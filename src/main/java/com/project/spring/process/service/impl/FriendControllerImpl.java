package com.project.spring.process.service.impl;

import com.project.spring.common.model.enumeration.ProcessTypeEnum;
import com.project.spring.core.model.request.friend.AcceptFriendRequest;
import com.project.spring.core.model.request.friend.AddFriendRequest;
import com.project.spring.core.model.request.friend.QueryFriendListRequest;
import com.project.spring.core.model.request.friend.QueryFriendRequestListRequest;
import com.project.spring.core.model.request.friend.RejectFriendRequest;
import com.project.spring.core.model.result.BaseResult;
import com.project.spring.core.model.result.friend.AcceptFriendResult;
import com.project.spring.core.model.result.friend.AddFriendResult;
import com.project.spring.core.model.result.friend.QueryFriendListResult;
import com.project.spring.core.model.result.friend.QueryFriendRequestListResult;
import com.project.spring.core.model.result.friend.RejectFriendResult;
import com.project.spring.core.service.FriendController;
import com.project.spring.process.callback.ProcessCallback;
import com.project.spring.process.callback.ProcessCallbackSupport;
import com.project.spring.process.callback.ProcessFacade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/friend")
public class FriendControllerImpl extends ProcessFacade implements FriendController {
    @Override
    @PostMapping("/add")
    public AddFriendResult addFriend(@RequestBody AddFriendRequest request) {
        return (AddFriendResult) ProcessCallbackSupport.process(request, ProcessTypeEnum.ADD_FRIEND, new ProcessCallback() {
            @Override
            public BaseResult initResult() {
                return new AddFriendResult();
            }

            @Override
            public void process(ProcessTypeEnum processType, BaseResult result) throws Exception {
                doProcess(request, result, processType);
            }
        });
    }

    @Override
    @PostMapping("/accept")
    public AcceptFriendResult acceptFriend(@RequestBody AcceptFriendRequest request) {
        return (AcceptFriendResult) ProcessCallbackSupport.process(request, ProcessTypeEnum.ACCEPT_FRIEND, new ProcessCallback() {
            @Override
            public BaseResult initResult() {
                return new AcceptFriendResult();
            }

            @Override
            public void process(ProcessTypeEnum processType, BaseResult result) throws Exception {
                doProcess(request, result, processType);
            }
        });
    }

    @Override
    @PostMapping("/reject")
    public RejectFriendResult rejectFriend(@RequestBody RejectFriendRequest request) {
        return (RejectFriendResult) ProcessCallbackSupport.process(request, ProcessTypeEnum.REJECT_FRIEND, new ProcessCallback() {
            @Override
            public BaseResult initResult() {
                return new RejectFriendResult();
            }

            @Override
            public void process(ProcessTypeEnum processType, BaseResult result) throws Exception {
                doProcess(request, result, processType);
            }
        });
    }

    @Override
    @PostMapping("/request/query")
    public QueryFriendRequestListResult queryFriendRequest(@RequestBody QueryFriendRequestListRequest request) {
        return (QueryFriendRequestListResult) ProcessCallbackSupport.process(request, ProcessTypeEnum.QUERY_FRIEND_REQUEST, new ProcessCallback() {
            @Override
            public BaseResult initResult() {
                return new QueryFriendRequestListResult();
            }

            @Override
            public void process(ProcessTypeEnum processType, BaseResult result) throws Exception {
                doProcess(request, result, processType);
            }
        });
    }

    @Override
    @PostMapping("/query")
    public QueryFriendListResult queryFriend(@RequestBody QueryFriendListRequest request) {
        return (QueryFriendListResult) ProcessCallbackSupport.process(request, ProcessTypeEnum.QUERY_FRIEND, new ProcessCallback() {
            @Override
            public BaseResult initResult() {
                return new QueryFriendListResult();
            }

            @Override
            public void process(ProcessTypeEnum processType, BaseResult result) throws Exception {
                doProcess(request, result, processType);
            }
        });
    }
}
