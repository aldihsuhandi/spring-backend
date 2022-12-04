package com.project.spring.dalgen.service.impl;

import com.project.spring.common.constant.DatabaseConst;
import com.project.spring.common.database.StatementBuilder;
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

import java.sql.Timestamp;
import java.util.List;

@Service
@Qualifier("sessionDAO")
public class SessionDAOImpl implements SessionDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(SessionDAORequest request) throws SpringException {
        String statement = new StatementBuilder(DatabaseConst.TABLE_SESSION, DatabaseConst.STATEMENT_INSERT)
                .addValueStatement(DatabaseConst.USER_ID)
                .addValueStatement(DatabaseConst.SESSION_ID)
                .addValueStatement(DatabaseConst.SESSION_DT)
                .addValueStatement(DatabaseConst.IS_REMEMBERED)
                .buildStatement();

        int result = 0;
        try {
            result = jdbcTemplate.update(statement, ps -> {
                ps.setString(1, request.getUserId());
                ps.setString(2, request.getSessionId());
                ps.setTimestamp(3, new Timestamp(request.getSessionDt().getTime()));
                ps.setBoolean(4, request.isRemembered());
            });
        } catch (Exception e) {
            throw new SpringException(e.getCause().getMessage(),
                    SpringErrorCodeEnum.INSERT_FAILED);
        }

        AssertUtil.isNotExpected(result, 0,
                "insert result", SpringErrorCodeEnum.INSERT_FAILED);
    }

    @Override
    public SessionDO query(SessionDAORequest request) {
        String statement = new StatementBuilder(DatabaseConst.TABLE_SESSION, DatabaseConst.STATEMENT_SELECT)
                .addSelectStatement(DatabaseConst.DATABASE_SELECT_ALL)
                .addWhereStatement(DatabaseConst.APPEND_OPERATOR_AND, DatabaseConst.SESSION_ID, DatabaseConst.COMPARATOR_EQUAL)
                .buildStatement();

        List<SessionDO> sessionDOS = jdbcTemplate.query(statement, ps -> ps.
                setString(1, request.getSessionId()), new SessionDORowMapper());

        if (sessionDOS == null || sessionDOS.isEmpty()) {
            return null;
        }

        return sessionDOS.get(0);
    }

    @Override
    public void logout(SessionDAORequest request) throws SpringException {
        String statement = new StatementBuilder(DatabaseConst.TABLE_SESSION, DatabaseConst.STATEMENT_UPDATE)
                .addSetStatement(DatabaseConst.IS_ACTIVE)
                .addSetStatement(DatabaseConst.GMT_MODIFIED)
                .addWhereStatement(DatabaseConst.APPEND_OPERATOR_AND, DatabaseConst.SESSION_ID, DatabaseConst.COMPARATOR_EQUAL)
                .buildStatement();

        int result = 0;
        try {
            result = jdbcTemplate.update(statement, ps -> {
                ps.setBoolean(1, false);
                ps.setTimestamp(2, new Timestamp(request.getGmtModified().getTime()));
                ps.setString(3, request.getSessionId());
            });
        } catch (Exception e) {
            throw new SpringException(e.getCause().getMessage(), SpringErrorCodeEnum.UPDATE_FAILED);
        }

        AssertUtil.isExpected(result, 1, "update result", SpringErrorCodeEnum.UPDATE_FAILED);
    }

    @Override
    public void refresh(SessionDAORequest request) throws SpringException {
        String statement = new StatementBuilder(DatabaseConst.TABLE_SESSION, DatabaseConst.STATEMENT_UPDATE)
                .addSetStatement(DatabaseConst.SESSION_DT)
                .addSetStatement(DatabaseConst.GMT_MODIFIED)
                .addWhereStatement(DatabaseConst.APPEND_OPERATOR_AND, DatabaseConst.SESSION_ID, DatabaseConst.COMPARATOR_EQUAL)
                .buildStatement();

        int result = 0;
        try {
            result = jdbcTemplate.update(statement, ps -> {
                ps.setTimestamp(1, new Timestamp(request.getSessionDt().getTime()));
                ps.setTimestamp(2, new Timestamp(request.getGmtModified().getTime()));
                ps.setString(3, request.getSessionId());
            });
        } catch (Exception e) {
            throw new SpringException(e.getCause().getMessage(), SpringErrorCodeEnum.UPDATE_FAILED);
        }

        AssertUtil.isExpected(result, 1, "update result", SpringErrorCodeEnum.UPDATE_FAILED);
    }

    @Override
    public void deactivate(SessionDAORequest request) throws SpringException {
        String statement = new StatementBuilder(DatabaseConst.TABLE_SESSION, DatabaseConst.STATEMENT_UPDATE)
                .addSetStatement(DatabaseConst.IS_ACTIVE)
                .addSetStatement(DatabaseConst.GMT_MODIFIED)
                .addWhereStatement(DatabaseConst.APPEND_OPERATOR_AND, DatabaseConst.GMT_MODIFIED, DatabaseConst.COMPARATOR_LESSER_THAN)
                .addWhereStatement(DatabaseConst.APPEND_OPERATOR_AND, DatabaseConst.IS_REMEMBERED, DatabaseConst.COMPARATOR_EQUAL)
                .buildStatement();

        try {
            jdbcTemplate.update(statement, ps -> {
                ps.setBoolean(1, false);
                ps.setTimestamp(2, new Timestamp(request.getSessionDt().getTime()));
                ps.setTimestamp(3, new Timestamp(request.getGmtModified().getTime()));
                ps.setBoolean(4, false);
            });
        } catch (Exception e) {
            throw new SpringException(e.getCause().getMessage(), SpringErrorCodeEnum.UPDATE_FAILED);
        }
    }
}
