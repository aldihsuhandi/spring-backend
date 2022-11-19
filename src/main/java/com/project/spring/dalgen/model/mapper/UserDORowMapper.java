package com.project.spring.dalgen.model.mapper;

import com.project.spring.dalgen.model.response.UserDO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDORowMapper implements RowMapper<UserDO> {
    @Override
    public UserDO mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserDO userDO = new UserDO();

        userDO.setUserId(rs.getString("user_id"));
        userDO.setEmail(rs.getString("email"));
        userDO.setUsername(rs.getString("username"));
        userDO.setProfilePicture(rs.getString("profile_picture"));
        userDO.setBanner(rs.getString("banner"));
        userDO.setStatus(rs.getString("status"));
        userDO.setPassword(rs.getString("password"));
        userDO.setGmtCreate(rs.getDate("gmt_create"));
        userDO.setGmtModified(rs.getDate("gmt_modified"));

        return userDO;
    }
}
