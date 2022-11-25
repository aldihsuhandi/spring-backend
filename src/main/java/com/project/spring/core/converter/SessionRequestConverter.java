package com.project.spring.core.converter;

import com.project.spring.common.model.request.session.SessionLoginInnerRequest;
import com.project.spring.common.model.request.session.SessionLogoutInnerRequest;
import com.project.spring.common.model.request.session.SessionQueryInnerRequest;
import com.project.spring.common.model.request.session.SessionRefreshInnerRequest;
import com.project.spring.common.model.viewobject.UserVO;
import com.project.spring.core.model.request.session.SessionLogoutRequest;
import com.project.spring.core.model.request.session.SessionRefreshRequest;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class SessionRequestConverter {
    public static SessionLoginInnerRequest toInnerRequest(UserVO userVO, String uuid) {
        SessionLoginInnerRequest innerRequest = new SessionLoginInnerRequest();
        innerRequest.setSessionId(uuid);
        innerRequest.setUserId(userVO.getUserId());
        innerRequest.setSessionDt(Date.from(LocalDateTime.now().plus(Duration.
                        of(10, ChronoUnit.MINUTES)).
                atZone(ZoneId.systemDefault()).toInstant()));
        innerRequest.setActive(true);

        return innerRequest;
    }

    public static SessionQueryInnerRequest toInnerRequest(String uuid) {
        SessionQueryInnerRequest innerRequest = new SessionQueryInnerRequest();
        innerRequest.setSessionId(uuid);

        return innerRequest;
    }

    public static SessionLogoutInnerRequest toInnerRequest(SessionLogoutRequest request) {
        SessionLogoutInnerRequest innerRequest = new SessionLogoutInnerRequest();
        innerRequest.setSessionId(request.getSessionId());
        innerRequest.setGmtModified(new Date());

        return innerRequest;
    }

    public static SessionRefreshInnerRequest toInnerRequest(SessionRefreshRequest request) {
        SessionRefreshInnerRequest innerRequest = new SessionRefreshInnerRequest();
        innerRequest.setSessionId(request.getSessionId());
        innerRequest.setSessionDt(Date.from(LocalDateTime.now().plus(Duration.
                        of(10, ChronoUnit.MINUTES)).
                atZone(ZoneId.systemDefault()).toInstant()));
        innerRequest.setGmtModified(new Date());

        return innerRequest;
    }
}
