package com.project.spring.dalgen.converter;

import com.project.spring.common.model.request.session.SessionLoginInnerRequest;
import com.project.spring.common.model.request.session.SessionLogoutInnerRequest;
import com.project.spring.common.model.request.session.SessionQueryInnerRequest;
import com.project.spring.common.model.request.session.SessionRefreshInnerRequest;
import com.project.spring.dalgen.model.request.SessionDAORequest;

public class SessionDaoRequestConverter {
    public static SessionDAORequest toDAORequest(SessionLoginInnerRequest innerRequest) {
        SessionDAORequest request = new SessionDAORequest();
        request.setSessionId(innerRequest.getSessionId());
        request.setUserId(innerRequest.getUserId());
        request.setSessionDt(innerRequest.getSessionDt());
        request.setActive(innerRequest.isActive());

        return request;
    }

    public static SessionDAORequest toDAORequest(SessionQueryInnerRequest innerRequest) {
        SessionDAORequest request = new SessionDAORequest();
        request.setSessionId(innerRequest.getSessionId());

        return request;
    }

    public static SessionDAORequest toDAORequest(SessionLogoutInnerRequest innerRequest) {
        SessionDAORequest request = new SessionDAORequest();
        request.setSessionId(innerRequest.getSessionId());
        request.setGmtModified(innerRequest.getGmtModified());

        return request;
    }

    public static SessionDAORequest toDAORequest(SessionRefreshInnerRequest innerRequest) {
        SessionDAORequest request = new SessionDAORequest();
        request.setSessionId(innerRequest.getSessionId());
        request.setGmtModified(innerRequest.getGmtModified());
        request.setSessionDt(innerRequest.getSessionDt());

        return request;
    }
}
