package com.project.spring.core.service;

import com.project.spring.core.model.request.session.SessionLoginRequest;
import com.project.spring.core.model.result.session.SessionLoginResult;

public interface SessionController {
    SessionLoginResult login(SessionLoginRequest request);
}
