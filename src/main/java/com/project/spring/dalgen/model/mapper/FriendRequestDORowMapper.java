package com.project.spring.dalgen.model.mapper;

import com.project.spring.common.constant.DatabaseConst;
import com.project.spring.dalgen.model.response.FriendRequestDO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FriendRequestDORowMapper implements RowMapper<FriendRequestDO> {
    @Override
    public FriendRequestDO mapRow(ResultSet rs, int rowNum) throws SQLException {
        FriendRequestDO friendRequestDO = new FriendRequestDO();
        friendRequestDO.setRequesterId(rs.getString(DatabaseConst.REQUESTER_ID));
        friendRequestDO.setReceiverId(rs.getString(DatabaseConst.RECEIVER_ID));
        friendRequestDO.setAccepted(rs.getBoolean(DatabaseConst.IS_ACCEPTED));
        friendRequestDO.setDeleted(rs.getBoolean(DatabaseConst.IS_DELETED));
        friendRequestDO.setGmtCreate(rs.getTimestamp(DatabaseConst.GMT_CREATE));
        friendRequestDO.setGmtModified(rs.getTimestamp(DatabaseConst.GMT_MODIFIED));

        return friendRequestDO;
    }
}
