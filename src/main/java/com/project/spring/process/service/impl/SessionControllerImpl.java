package com.project.spring.process.service.impl;

import com.project.spring.common.model.enumeration.ProcessTypeEnum;
import com.project.spring.core.model.request.session.SessionLoginRequest;
import com.project.spring.core.model.request.session.SessionLogoutRequest;
import com.project.spring.core.model.request.session.SessionQueryRequest;
import com.project.spring.core.model.request.session.SessionRefreshRequest;
import com.project.spring.core.model.result.BaseResult;
import com.project.spring.core.model.result.session.SessionLoginResult;
import com.project.spring.core.model.result.session.SessionLogoutResult;
import com.project.spring.core.model.result.session.SessionQueryResult;
import com.project.spring.core.model.result.session.SessionRefreshResult;
import com.project.spring.core.service.SessionController;
import com.project.spring.process.callback.ProcessCallback;
import com.project.spring.process.callback.ProcessCallbackSupport;
import com.project.spring.process.callback.ProcessFacade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestMapping("/session")
public class SessionControllerImpl extends ProcessFacade implements SessionController {
    @Override
    @PostMapping("/login")
    public SessionLoginResult login(@RequestBody SessionLoginRequest request) {
        return (SessionLoginResult) ProcessCallbackSupport.process(request, ProcessTypeEnum.USER_LOGIN, new ProcessCallback() {
            @Override
            public BaseResult initResult() {
                return new SessionLoginResult();
            }

            @Override
            public void process(ProcessTypeEnum processType, BaseResult result) throws Exception {
                doProcess(request, result, processType);
            }
        });
    }

    @Override
    @PostMapping("/logout")
    public SessionLogoutResult logout(@RequestBody SessionLogoutRequest request) {
        return (SessionLogoutResult) ProcessCallbackSupport.process(request, ProcessTypeEnum.USER_LOGOUT, new ProcessCallback() {
            @Override
            public BaseResult initResult() {
                return new SessionLogoutResult();
            }

            @Override
            public void process(ProcessTypeEnum processType, BaseResult result) throws Exception {
                doProcess(request, result, processType);
            }
        });
    }

    @Override
    @PostMapping("/refresh")
    public SessionRefreshResult refresh(@RequestBody SessionRefreshRequest request) {
        return (SessionRefreshResult) ProcessCallbackSupport.process(request, ProcessTypeEnum.SESSION_REFRESH, new ProcessCallback() {
            @Override
            public BaseResult initResult() {
                return new SessionRefreshResult();
            }

            @Override
            public void process(ProcessTypeEnum processType, BaseResult result) throws Exception {
                doProcess(request, result, processType);
            }
        });
    }

    @Override
    public SessionQueryResult query(@RequestBody SessionQueryRequest request) {
        return (SessionQueryResult) ProcessCallbackSupport.process(request, ProcessTypeEnum.SESSION_QUERY, new ProcessCallback() {
            @Override
            public BaseResult initResult() {
                return new SessionQueryResult();
            }

            @Override
            public void process(ProcessTypeEnum processType, BaseResult result) throws Exception {
                doProcess(request, result, processType);
            }
        });
    }
}
