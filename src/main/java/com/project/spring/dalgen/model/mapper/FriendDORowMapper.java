package com.project.spring.dalgen.model.mapper;

import com.project.spring.common.constant.DatabaseConst;
import com.project.spring.dalgen.model.response.FriendDO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FriendDORowMapper implements RowMapper<FriendDO> {
    @Override
    public FriendDO mapRow(ResultSet rs, int rowNum) throws SQLException {
        FriendDO friendDO = new FriendDO();
        friendDO.setUserId(rs.getString(DatabaseConst.USER_ID));
        friendDO.setFriendId(rs.getString(DatabaseConst.FRIEND_ID));
        friendDO.setBlocked(rs.getBoolean(DatabaseConst.IS_BLOCKED));
        friendDO.setGmtCreate(rs.getTimestamp(DatabaseConst.GMT_CREATE));
        friendDO.setGmtModified(rs.getTime(DatabaseConst.GMT_MODIFIED));

        return friendDO;
    }
}
