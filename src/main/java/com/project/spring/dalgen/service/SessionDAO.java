package com.project.spring.dalgen.service;

import com.project.spring.common.model.exception.SpringException;
import com.project.spring.dalgen.model.request.SessionDAORequest;
import com.project.spring.dalgen.model.response.SessionDO;

public interface SessionDAO {
    void insert(SessionDAORequest request) throws SpringException;

    SessionDO query(SessionDAORequest request);

    void logout(SessionDAORequest request) throws SpringException;

    void refresh(SessionDAORequest request) throws SpringException;
}
