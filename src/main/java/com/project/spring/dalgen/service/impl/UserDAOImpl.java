package com.project.spring.dalgen.service.impl;

import com.project.spring.common.constant.DatabaseConst;
import com.project.spring.common.database.StatementBuilder;
import com.project.spring.common.model.enumeration.SpringErrorCodeEnum;
import com.project.spring.common.model.exception.SpringException;
import com.project.spring.common.util.AssertUtil;
import com.project.spring.dalgen.model.mapper.UserDORowMapper;
import com.project.spring.dalgen.model.request.UserDAORequest;
import com.project.spring.dalgen.model.response.UserDO;
import com.project.spring.dalgen.service.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@Qualifier("userDAO")
public class UserDAOImpl implements UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserDO createUser(UserDAORequest request) throws SpringException {
        String statement = new StatementBuilder(DatabaseConst.TABLE_USER, DatabaseConst.STATEMENT_INSERT)
                .addValueStatement(DatabaseConst.USER_ID)
                .addValueStatement(DatabaseConst.EMAIL)
                .addValueStatement(DatabaseConst.USERNAME)
                .addValueStatement(DatabaseConst.PASSWORD)
                .addValueStatement(DatabaseConst.GMT_CREATE)
                .addValueStatement(DatabaseConst.GMT_MODIFIED)
                .buildStatement();
        int result = 0;
        try {
            result = jdbcTemplate.update(statement, ps -> {
                ps.setString(1, request.getUserId());
                ps.setString(2, request.getEmail());
                ps.setString(3, request.getUsername());
                ps.setString(4, request.getPassword());
                ps.setTimestamp(5, new Timestamp(request.getGmtCreate().getTime()));
                ps.setTimestamp(6, new Timestamp(request.getGmtModified().getTime()));
            });
        } catch (Exception e) {
            throw new SpringException(e.getCause().getMessage(), SpringErrorCodeEnum.INSERT_FAILED);
        }

        AssertUtil.isNotExpected(result, 0, "update result", SpringErrorCodeEnum.INSERT_FAILED);

        UserDO userDO = new UserDO();
        userDO.setUserId(request.getUserId());

        return userDO;
    }

    @Override
    public UserDO queryByUserId(UserDAORequest request) {
        String statement = new StatementBuilder(DatabaseConst.TABLE_USER, DatabaseConst.STATEMENT_SELECT)
                .addSelectStatement(DatabaseConst.DATABASE_SELECT_ALL)
                .addWhereStatement(DatabaseConst.APPEND_OPERATOR_AND, DatabaseConst.USER_ID, DatabaseConst.COMPARATOR_EQUAL)
                .buildStatement();
        List<UserDO> userDOS = jdbcTemplate.query(statement, ps -> ps.
                setString(1, request.getUserId()), new UserDORowMapper());
        if (userDOS == null || userDOS.isEmpty()) {
            return null;
        }

        return userDOS.get(0);
    }

    @Override
    public UserDO queryByUsername(UserDAORequest request) {
        String statement = new StatementBuilder(DatabaseConst.TABLE_USER, DatabaseConst.STATEMENT_SELECT)
                .addSelectStatement(DatabaseConst.DATABASE_SELECT_ALL)
                .addWhereStatement(DatabaseConst.APPEND_OPERATOR_AND, DatabaseConst.USERNAME, DatabaseConst.COMPARATOR_EQUAL)
                .buildStatement();
        List<UserDO> userDOS = jdbcTemplate.query(statement, ps -> ps.setString(1, request.getUsername()), new UserDORowMapper());

        if (userDOS == null || userDOS.isEmpty()) {
            return null;
        }

        return userDOS.get(0);
    }

    @Override
    public UserDO queryByEmail(UserDAORequest request) {
        String statement = new StatementBuilder(DatabaseConst.TABLE_USER, DatabaseConst.STATEMENT_SELECT)
                .addSelectStatement(DatabaseConst.DATABASE_SELECT_ALL)
                .addWhereStatement(DatabaseConst.APPEND_OPERATOR_AND, DatabaseConst.EMAIL, DatabaseConst.COMPARATOR_EQUAL)
                .buildStatement();
        List<UserDO> userDOS = jdbcTemplate.query(statement, ps -> ps.setString(1, request.getEmail()), new UserDORowMapper());

        if (userDOS == null || userDOS.isEmpty()) {
            return null;
        }

        return userDOS.get(0);
    }

    @Override
    public List<UserDO> queryUsersById(List<UserDAORequest> requests) {
        return null;
    }

    @Override
    public void update(UserDAORequest request) throws SpringException {
        String statement = new StatementBuilder(DatabaseConst.TABLE_USER, DatabaseConst.STATEMENT_UPDATE)
                .addSetStatement(DatabaseConst.EMAIL)
                .addSetStatement(DatabaseConst.USERNAME)
                .addSetStatement(DatabaseConst.PASSWORD)
                .addSetStatement(DatabaseConst.PROFILE_PICTURE)
                .addSetStatement(DatabaseConst.BANNER)
                .addSetStatement(DatabaseConst.STATUS)
                .addSetStatement(DatabaseConst.GMT_MODIFIED)
                .addWhereStatement(DatabaseConst.APPEND_OPERATOR_AND, DatabaseConst.USER_ID, DatabaseConst.COMPARATOR_EQUAL)
                .buildStatement();

        int result = 0;
        try {
            result = jdbcTemplate.update(statement, ps -> {
                ps.setString(1, request.getEmail());
                ps.setString(2, request.getUsername());
                ps.setString(3, request.getPassword());
                ps.setString(4, request.getProfilePicture());
                ps.setString(5, request.getBanner());
                ps.setString(6, request.getStatus());
                ps.setTimestamp(7, new Timestamp(request.getGmtModified().getTime()));
                ps.setString(8, request.getUserId());
            });
        } catch (Exception e) {
            throw new SpringException(e.getCause().getMessage(), SpringErrorCodeEnum.UPDATE_FAILED);
        }

        AssertUtil.isExpected(result, 1, "update result", SpringErrorCodeEnum.UPDATE_FAILED);
    }

    @Override
    public void delete(UserDAORequest request) throws SpringException {
        String statement = new StatementBuilder(DatabaseConst.TABLE_USER, DatabaseConst.STATEMENT_UPDATE)
                .addSetStatement(DatabaseConst.IS_ACTIVE)
                .addSetStatement(DatabaseConst.GMT_MODIFIED)
                .addWhereStatement(DatabaseConst.APPEND_OPERATOR_AND, DatabaseConst.USER_ID, DatabaseConst.COMPARATOR_EQUAL)
                .buildStatement();
        int result = 0;
        try {
            result = jdbcTemplate.update(statement, ps -> {
                ps.setBoolean(1, request.isActive());
                ps.setTimestamp(2, new Timestamp(request.getGmtModified().getTime()));
                ps.setString(3, request.getUserId());
            });
        } catch (Exception e) {
            throw new SpringException(e.getCause().getMessage(), SpringErrorCodeEnum.UPDATE_FAILED);
        }

        AssertUtil.isExpected(result, 1, "update result", SpringErrorCodeEnum.UPDATE_FAILED);
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
