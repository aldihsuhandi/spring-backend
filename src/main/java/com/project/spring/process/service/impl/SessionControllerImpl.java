package com.project.spring.process.service.impl;

import com.project.spring.common.model.enumeration.ProcessTypeEnum;
import com.project.spring.core.model.request.session.SessionLoginRequest;
import com.project.spring.core.model.result.BaseResult;
import com.project.spring.core.model.result.session.SessionLoginResult;
import com.project.spring.core.service.SessionController;
import com.project.spring.process.callback.ProcessCallback;
import com.project.spring.process.callback.ProcessCallbackSupport;
import com.project.spring.process.callback.ProcessFacade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
