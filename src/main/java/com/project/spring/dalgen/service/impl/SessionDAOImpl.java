package com.project.spring.dalgen.service.impl;

import com.project.spring.common.model.enumeration.SpringErrorCodeEnum;
import com.project.spring.common.model.exception.SpringException;
import com.project.spring.common.util.AssertUtil;
import com.project.spring.dalgen.model.mapper.SessionDORowMapper;
import com.project.spring.dalgen.model.request.SessionDAORequest;
import com.project.spring.dalgen.model.response.SessionDO;
import com.project.spring.dalgen.service.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("sessionDAO")
public class SessionDAOImpl implements SessionDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(SessionDAORequest request) throws SpringException {
        String statement = "INSERT INTO sessions(user_id, session_id) VALUES(?, ?)";
        int result = 0;
        try {
            result = jdbcTemplate.update(statement,
                    request.getUserId(), request.getSessionId());
        } catch (Exception e) {
            throw new SpringException(e.getCause().getMessage(),
                    SpringErrorCodeEnum.INSERT_FAILED);
        }

        AssertUtil.isNotExpected(result, 0,
                "insert result", SpringErrorCodeEnum.INSERT_FAILED);
    }

    @Override
    public SessionDO query(SessionDAORequest request) {
        String statement = "SELECT * FROM sessions WHERE session_id = ?";
        List<SessionDO> sessionDOS = jdbcTemplate.query(statement, ps -> ps.
                setString(1, request.getSessionId()), new SessionDORowMapper());

        if (sessionDOS == null || sessionDOS.isEmpty()) {
            return null;
        }

        return sessionDOS.get(0);
    }
}
