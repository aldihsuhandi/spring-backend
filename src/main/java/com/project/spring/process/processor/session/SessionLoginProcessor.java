package com.project.spring.process.processor.session;

import com.project.spring.common.constant.CommonConst;
import com.project.spring.common.model.exception.SpringException;
import com.project.spring.common.model.request.session.SessionLoginInnerRequest;
import com.project.spring.common.model.viewobject.SessionVO;
import com.project.spring.common.model.viewobject.UserVO;
import com.project.spring.common.service.SessionService;
import com.project.spring.common.service.UserService;
import com.project.spring.core.converter.SessionRequestConverter;
import com.project.spring.core.converter.UserRequestConverter;
import com.project.spring.core.model.request.BaseRequest;
import com.project.spring.core.model.request.session.SessionLoginRequest;
import com.project.spring.core.model.result.BaseResult;
import com.project.spring.core.model.result.session.SessionLoginResult;
import com.project.spring.process.processor.BaseProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class SessionLoginProcessor implements BaseProcessor {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    @Qualifier("sessionService")
    private SessionService sessionService;

    @Override
    public void doProcess(BaseResult result, BaseRequest request) throws SpringException {
        SessionLoginRequest sessionLoginRequest = (SessionLoginRequest) request;
        SessionLoginResult sessionLoginResult = (SessionLoginResult) result;
        UserVO userVO = userService.queryByUsername(UserRequestConverter.
                toInnerRequest(sessionLoginRequest.getUsername(), CommonConst.USERNAME));

        String uuid = sessionService.generateUUID();
        SessionLoginInnerRequest loginInnerRequest = SessionRequestConverter.toInnerRequest(userVO, uuid);

        sessionService.login(loginInnerRequest);

        SessionVO sessionVO = sessionService.query(SessionRequestConverter.toInnerRequest(uuid));

        composeResult(sessionLoginResult, sessionVO);
    }

    private void composeResult(SessionLoginResult result, SessionVO sessionVO) {
        result.setSessionDt(sessionVO.getSessionDt());
        result.setSessionId(sessionVO.getSessionId());
    }
}
