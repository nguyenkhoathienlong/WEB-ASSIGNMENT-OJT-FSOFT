package com.thienlong.mobilestore.service;

import com.thienlong.mobilestore.dao.RoleDAO;
import com.thienlong.mobilestore.dao.UserDAO;
import com.thienlong.mobilestore.entity.Role;
import com.thienlong.mobilestore.entity.Userss;
import com.thienlong.mobilestore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // đầu tiên mình query xuống database xem có user  đó không
        Userss appUser = this.userDAO.findUserAccount(userName);
        //Nếu không tìm thấy User thì mình thông báo lỗi
        if (appUser == null) {
            System.out.println("User " + userName + " was not found in the database");
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }
        // Khi đã có user rồi thì mình query xem user đó có những quyền gì (Admin hay User)
        List<String> roleNames = this.roleDAO.getRoleName(appUser.getID());
        // Dựa vào list quyền trả về mình tạo đối tượng GrantedAuthority  của spring cho quyền đó
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleNames != null) {
            for (String role : roleNames) {
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }
        //Cuối cùng mình tạo đối tượng UserDetails của Spring và mình cung cấp cá thông số như tên , password và quyền
        // Đối tượng userDetails sẽ chứa đựng các thông tin cần thiết về user từ đó giúp Spring Security quản lý được phân quyền như ta đã
        // cấu hình trong bước 4 method configure
        UserDetails userDetails = (UserDetails) new User(appUser.getUserName(),
                appUser.getPassword(), grantList);
        return userDetails;
    }
}
