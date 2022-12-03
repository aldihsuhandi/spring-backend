package com.project.spring.process.service.impl;

import com.project.spring.common.model.enumeration.ProcessTypeEnum;
import com.project.spring.core.model.request.friend.AddFriendRequest;
import com.project.spring.core.model.result.BaseResult;
import com.project.spring.core.model.result.friend.AddFriendResult;
import com.project.spring.core.service.FriendController;
import com.project.spring.process.callback.ProcessCallback;
import com.project.spring.process.callback.ProcessCallbackSupport;
import com.project.spring.process.callback.ProcessFacade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/friend")
public class FriendControllerImpl extends ProcessFacade implements FriendController {
    @Override
    @PostMapping("/add")
    public AddFriendResult addFriend(AddFriendRequest request) {
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
}
