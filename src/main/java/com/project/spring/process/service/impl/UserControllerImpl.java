package com.project.spring.process.service.impl;

import com.project.spring.common.model.enumeration.ProcessTypeEnum;
import com.project.spring.core.model.request.user.UserCreateRequest;
import com.project.spring.core.model.request.user.UserDeleteRequest;
import com.project.spring.core.model.request.user.UserQueryRequest;
import com.project.spring.core.model.request.user.UserUpdateRequest;
import com.project.spring.core.model.result.BaseResult;
import com.project.spring.core.model.result.user.UserCreateResult;
import com.project.spring.core.model.result.user.UserDeleteResult;
import com.project.spring.core.model.result.user.UserQueryResult;
import com.project.spring.core.model.result.user.UserUpdateResult;
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

    @Override
    @PostMapping("/delete")
    public UserDeleteResult delete(@RequestBody UserDeleteRequest request) {
        return (UserDeleteResult) ProcessCallbackSupport.process(request, ProcessTypeEnum.USER_DELETE, new ProcessCallback() {
            @Override
            public BaseResult initResult() {
                return new UserDeleteResult();
            }

            @Override
            public void process(ProcessTypeEnum processType, BaseResult result) throws Exception {
                doProcess(request, result, processType);
            }
        });
    }
}
