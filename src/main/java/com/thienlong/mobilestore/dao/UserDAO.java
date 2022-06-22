package com.thienlong.mobilestore.dao;

import com.thienlong.mobilestore.entity.Userss;
import com.thienlong.mobilestore.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UserDAO extends JdbcDaoSupport {

    @Autowired
    public UserDAO(DataSource dataSource){
        this.setDataSource(dataSource);
    }

    public Userss findUserAccount(String userName) {
        String sql = UserMapper.SQL + " where u.user_name = ? ";
        Object[] params = new Object[] {userName};
        UserMapper mapper = new UserMapper();
        try {
            Userss usersInfo = this.getJdbcTemplate().queryForObject(sql, params, mapper);
            return usersInfo;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
