package com.thienlong.mobilestore.service.mapper;

import com.thienlong.mobilestore.entity.Userss;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<Userss> {

    public static final String SQL = "Select u.user_id, u.user_name, u.full_name, u.password, u.role_id From Users u ";

    @Override
    public Userss mapRow(ResultSet rs, int rowNum) throws SQLException {
        Integer userID = rs.getInt("user_id");
        String userName = rs.getString("user_name");
        String fullName = rs.getString("full_name");
        String password = rs.getString("password");
        Integer roleID = rs.getInt("role_id");
        return new Userss(userID, userName, fullName, password, roleID);
    }
}
