package com.thienlong.mobilestore.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
@Repository
public class RoleDAO extends JdbcDaoSupport {

    @Autowired
    public RoleDAO(DataSource dataSource){
        this.setDataSource(dataSource);
    }

    public List<String> getRoleName(Integer userID){
        String sql = "SELECT r.role_name "
                + " FROM Users ur, Roles r "
                + " WHERE ur.role_id = r.role_id and ur.user_id = ? ";
        Object[] params = new Object[] { userID };
        List<String> roles = this.getJdbcTemplate().queryForList(sql, params, String.class);
        return roles;
    }
}
