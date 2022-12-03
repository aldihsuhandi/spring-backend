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

        int result = 0;
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
}
