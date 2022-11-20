package com.project.spring.process.service.impl;

import com.project.spring.common.model.enumeration.ProcessTypeEnum;
import com.project.spring.core.model.request.UserCreateRequest;
import com.project.spring.core.model.request.UserQueryRequest;
import com.project.spring.core.model.request.UserUpdateRequest;
import com.project.spring.core.model.result.BaseResult;
import com.project.spring.core.model.result.UserCreateResult;
import com.project.spring.core.model.result.UserQueryResult;
import com.project.spring.core.model.result.UserUpdateResult;
import com.project.spring.core.service.UserController;
import com.project.spring.process.callback.ProcessCallback;
import com.project.spring.process.callback.ProcessCallbackSupport;
import com.project.spring.process.callback.ProcessFacade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserControllerImpl extends ProcessFacade implements UserController {

    @Override
    @PostMapping("/create")
    public UserCreateResult create(@RequestBody UserCreateRequest request) {
        System.out.println(request.toString());
        return (UserCreateResult) ProcessCallbackSupport.process(request, ProcessTypeEnum.USER_CREATE, new ProcessCallback() {
            @Override
            public BaseResult initResult() {
                return new UserCreateResult();
            }

            @Override
            public void process(ProcessTypeEnum processType, BaseResult result) throws Exception {
                doProcess(request, result, processType);
            }
        });
    }

    @Override
    @PostMapping("/info")
    public UserQueryResult query(@RequestBody UserQueryRequest request) {
        return (UserQueryResult) ProcessCallbackSupport.process(request, ProcessTypeEnum.USER_QUERY, new ProcessCallback() {
            @Override
            public BaseResult initResult() {
                return new UserQueryResult();
            }

            @Override
            public void process(ProcessTypeEnum processType, BaseResult result) throws Exception {
                doProcess(request, result, processType);
            }
        });
    }

    @Override
    @PostMapping("/update")
    public UserUpdateResult update(@RequestBody UserUpdateRequest request) {
        return (UserUpdateResult) ProcessCallbackSupport.process(request, ProcessTypeEnum.USER_UPDATE, new ProcessCallback() {
            @Override
            public BaseResult initResult() {
                return new UserUpdateResult();
            }

            @Override
            public void process(ProcessTypeEnum processType, BaseResult result) throws Exception {
                doProcess(request, result, processType);
            }
        });
    }
}
