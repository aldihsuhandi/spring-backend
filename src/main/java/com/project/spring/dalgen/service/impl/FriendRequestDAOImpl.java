package com.project.spring.dalgen.service.impl;

import com.project.spring.common.constant.DatabaseConst;
import com.project.spring.common.database.StatementBuilder;
import com.project.spring.common.model.enumeration.SpringErrorCodeEnum;
import com.project.spring.common.model.exception.SpringException;
import com.project.spring.common.util.AssertUtil;
import com.project.spring.dalgen.model.request.FriendRequestDAORequest;
import com.project.spring.dalgen.service.FriendRequestDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Qualifier("friendRequestDAO")
public class FriendRequestDAOImpl implements FriendRequestDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(FriendRequestDAORequest request) throws SpringException {
        String statement = new StatementBuilder(DatabaseConst.TABLE_FRIEND_REQUEST, DatabaseConst.STATEMENT_INSERT)
                .addValueStatement(DatabaseConst.REQUESTER_ID)
                .addValueStatement(DatabaseConst.RECEIVER_ID)
                .buildStatement();

        int result;
        try {
            result = jdbcTemplate.update(statement, ps -> {
                ps.setString(1, request.getRequesterId());
                ps.setString(2, request.getReceiverId());
            });
        } catch (Exception e) {
            throw new SpringException(e.getCause().getMessage(),
                    SpringErrorCodeEnum.INSERT_FAILED);
        }

        AssertUtil.isNotExpected(result, 0,
                "insert result", SpringErrorCodeEnum.INSERT_FAILED);
    }

    @Override
    public void update(FriendRequestDAORequest request) throws SpringException {
        String statement = new StatementBuilder(DatabaseConst.TABLE_FRIEND_REQUEST, DatabaseConst.STATEMENT_UPDATE)
                .addSetStatement(DatabaseConst.IS_ACCEPTED)
                .addSetStatement(DatabaseConst.IS_DELETED)
                .addWhereStatement(DatabaseConst.APPEND_OPERATOR_AND, DatabaseConst.RECEIVER_ID, DatabaseConst.COMPARATOR_EQUAL)
                .addWhereStatement(DatabaseConst.APPEND_OPERATOR_AND, DatabaseConst.REQUESTER_ID, DatabaseConst.COMPARATOR_EQUAL)
                .buildStatement();

        int result;
        try {
            result = jdbcTemplate.update(statement, ps -> {
                ps.setBoolean(1, request.isAccepted());
                ps.setBoolean(2, request.isDeleted());
                ps.setString(3, request.getReceiverId());
                ps.setString(4, request.getRequesterId());
            });
        } catch (Exception e) {
            throw new SpringException(e.getCause().getMessage(),
                    SpringErrorCodeEnum.UPDATE_FAILED);
        }

        AssertUtil.isNotExpected(result, 0,
                "update result", SpringErrorCodeEnum.UPDATE_FAILED);
    }
}
