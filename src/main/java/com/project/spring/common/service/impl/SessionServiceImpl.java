package com.project.spring.common.service.impl;

import com.project.spring.common.converter.SessionVOConverter;
import com.project.spring.common.model.exception.SpringException;
import com.project.spring.common.model.request.session.SessionLoginInnerRequest;
import com.project.spring.common.model.request.session.SessionQueryInnerRequest;
import com.project.spring.common.model.viewobject.SessionVO;
import com.project.spring.common.service.SessionService;
import com.project.spring.dalgen.converter.SessionDaoRequestConverter;
import com.project.spring.dalgen.model.request.SessionDAORequest;
import com.project.spring.dalgen.model.response.SessionDO;
import com.project.spring.dalgen.service.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Qualifier("sessionService")
public class SessionServiceImpl implements SessionService {

    @Autowired
    @Qualifier("sessionDAO")
    SessionDAO sessionDAO;

    @Override
    public void login(SessionLoginInnerRequest request) throws SpringException {
        SessionDAORequest daoRequest = SessionDaoRequestConverter.toDAORequest(request);
        sessionDAO.insert(daoRequest);
    }

    @Override
    public SessionVO query(SessionQueryInnerRequest request) throws SpringException {
        SessionDAORequest daoRequest = SessionDaoRequestConverter.toDAORequest(request);
        SessionDO sessionDO = sessionDAO.query(daoRequest);

        return SessionVOConverter.toResult(sessionDO);
    }

    @Override
    public String generateUUID() {
        return UUID.randomUUID().toString();
    }
}
