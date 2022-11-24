package com.project.spring.core.service;

import com.project.spring.core.model.request.session.SessionLoginRequest;
import com.project.spring.core.model.request.session.SessionLogoutRequest;
import com.project.spring.core.model.request.session.SessionRefreshRequest;
import com.project.spring.core.model.result.session.SessionLoginResult;
import com.project.spring.core.model.result.session.SessionLogoutResult;
import com.project.spring.core.model.result.session.SessionRefreshResult;

public interface SessionController {
    SessionLoginResult login(SessionLoginRequest request);

    SessionLogoutResult logout(SessionLogoutRequest request);

    SessionRefreshResult refresh(SessionRefreshRequest request);
}
