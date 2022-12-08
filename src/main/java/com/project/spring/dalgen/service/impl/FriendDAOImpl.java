package com.project.spring.dalgen.service.impl;

import com.project.spring.common.constant.DatabaseConst;
import com.project.spring.common.database.StatementBuilder;
import com.project.spring.common.model.enumeration.SpringErrorCodeEnum;
import com.project.spring.common.model.exception.SpringException;
import com.project.spring.common.util.AssertUtil;
import com.project.spring.dalgen.model.mapper.FriendDORowMapper;
import com.project.spring.dalgen.model.request.FriendDAORequest;
import com.project.spring.dalgen.model.response.FriendDO;
import com.project.spring.dalgen.service.FriendDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("friendDAO")
public class FriendDAOImpl implements FriendDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(FriendDAORequest request) throws SpringException {
        String statement = new StatementBuilder(DatabaseConst.TABLE_FRIEND_LIST, DatabaseConst.STATEMENT_INSERT)
                .addValueStatement(DatabaseConst.USER_ID)
                .addValueStatement(DatabaseConst.FRIEND_ID)
                .addValueStatement(DatabaseConst.IS_BLOCKED)
                .buildStatement();

        int result;
        try {
            result = jdbcTemplate.update(statement, ps -> {
                ps.setString(1, request.getUserId());
                ps.setString(2, request.getFriendId());
                ps.setBoolean(3, false);
            });
        } catch (Exception e) {
            throw new SpringException(e.getCause().getMessage(),
                    SpringErrorCodeEnum.INSERT_FAILED);
        }

        AssertUtil.isNotExpected(result, 0,
                "insert result", SpringErrorCodeEnum.INSERT_FAILED);
    }

    @Override
    public List<FriendDO> query(FriendDAORequest request) {
        String statement = new StatementBuilder(DatabaseConst.TABLE_FRIEND_LIST, DatabaseConst.STATEMENT_SELECT)
                .addValueStatement(DatabaseConst.FRIEND_ID)
                .addWhereStatement(DatabaseConst.APPEND_OPERATOR_AND, DatabaseConst.USER_ID, DatabaseConst.COMPARATOR_EQUAL)
                .buildStatement();

        return jdbcTemplate.query(statement, ps ->
                ps.setString(1, request.getUserId()), new FriendDORowMapper());
    }
}
