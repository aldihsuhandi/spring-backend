package com.project.spring.dalgen.service.impl;

import com.project.spring.common.model.exception.SpringException;
import com.project.spring.common.util.AssertUtil;
import com.project.spring.dalgen.model.request.UserDAORequest;
import com.project.spring.dalgen.model.response.UserDO;
import com.project.spring.dalgen.service.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Qualifier("userDAO")
public class UserDAOImpl implements UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserDO createUser(UserDAORequest request) throws SpringException {
        String statement = "INSERT INTO users(user_id, email, username, password, gmt_create, gmt_modified) VALUES(?, ?, ?, ?, ?, ?)";
        int result = jdbcTemplate.update(statement, request.getUserId(), request.getEmail(), request.getUsername(), request.getPassword(), request.getGmtCreate(), request.getGmtModified());

        AssertUtil.isNotExpected(result, 0, "update result");

        UserDO userDO = new UserDO();
        userDO.setUserId(request.getUserId());

        return userDO;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
