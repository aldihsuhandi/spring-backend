package com.project.spring.dalgen.model.mapper;

import com.project.spring.common.constant.DatabaseConst;
import com.project.spring.dalgen.model.response.UserDO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDORowMapper implements RowMapper<UserDO> {
    @Override
    public UserDO mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserDO userDO = new UserDO();

        userDO.setUserId(rs.getString(DatabaseConst.USER_ID));
        userDO.setEmail(rs.getString(DatabaseConst.EMAIL));
        userDO.setUsername(rs.getString(DatabaseConst.USERNAME));
        userDO.setProfilePicture(rs.getString(DatabaseConst.PROFILE_PICTURE));
        userDO.setBanner(rs.getString(DatabaseConst.BANNER));
        userDO.setStatus(rs.getString(DatabaseConst.STATUS));
        userDO.setPassword(rs.getString(DatabaseConst.PASSWORD));
        userDO.setActive(rs.getBoolean(DatabaseConst.IS_ACTIVE));
        userDO.setGmtCreate(rs.getTimestamp(DatabaseConst.GMT_CREATE));
        userDO.setGmtModified(rs.getTimestamp(DatabaseConst.GMT_MODIFIED));

        return userDO;
    }
}
