package com.project.spring.common.service;

import com.project.spring.common.model.exception.SpringException;
import com.project.spring.common.model.request.session.SessionLoginInnerRequest;
import com.project.spring.common.model.request.session.SessionLogoutInnerRequest;
import com.project.spring.common.model.request.session.SessionQueryInnerRequest;
import com.project.spring.common.model.request.session.SessionRefreshInnerRequest;
import com.project.spring.common.model.request.session.SessionUpdateInnerRequest;
import com.project.spring.common.model.viewobject.SessionVO;

public interface SessionService {
    void login(SessionLoginInnerRequest request) throws SpringException;

    SessionVO query(SessionQueryInnerRequest request) throws SpringException;

    void logout(SessionLogoutInnerRequest request) throws SpringException;

    void refresh(SessionRefreshInnerRequest request) throws SpringException;

    void deactivate(SessionUpdateInnerRequest request) throws SpringException;

    String generateUUID();
}
