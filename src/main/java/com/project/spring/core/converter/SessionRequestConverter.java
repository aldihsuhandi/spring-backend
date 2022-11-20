package com.project.spring.core.converter;

import com.project.spring.common.model.request.session.SessionLoginInnerRequest;
import com.project.spring.common.model.request.session.SessionQueryInnerRequest;
import com.project.spring.common.model.viewobject.UserVO;

import java.util.Date;

public class SessionRequestConverter {
    public static SessionLoginInnerRequest toInnerRequest(UserVO userVO, String uuid) {
        SessionLoginInnerRequest innerRequest = new SessionLoginInnerRequest();
        innerRequest.setSessionId(uuid);
        innerRequest.setUserId(userVO.getUserId());
        innerRequest.setSessionDt(new Date());
        innerRequest.setActive(true);

        return innerRequest;
    }

    public static SessionQueryInnerRequest toInnerRequest(String uuid) {
        SessionQueryInnerRequest innerRequest = new SessionQueryInnerRequest();
        innerRequest.setSessionId(uuid);

        return innerRequest;
    }
}
