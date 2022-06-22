package com.thienlong.mobilestore.config;

import com.thienlong.mobilestore.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        // Setting Service to find User in the database.
        // And Setting PassswordEncoder
        // Set đặt dịch vụ để tìm kiếm User trong Database.
        // Và sét đặt PasswordEncoder.
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return authProvider;
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        // The pages does not require login
//        // Các trang không yêu cầu login
//        http.authorizeRequests().antMatchers("/", "/login", "/logout").permitAll();
//        // /userInfo page requires login as ROLE_USER or ROLE_ADMIN.
//        // If no login, it will redirect to /login page.
//        // Trang /userInfo yêu cầu phải login với vai trò ROLE_USER hoặc ROLE_ADMIN.
//        // Nếu chưa login, nó sẽ redirect tới trang /login.
//        http.authorizeRequests().antMatchers("/userInfo").access("hasAnyRole('US', 'AD')");
//        // For ADMIN only.
//        http.authorizeRequests().antMatchers("/admin").access("hasRole('AD')");
//        // Config for Login Form
//        // Cấu hình cho Login Form.
//        http.authorizeRequests()
//                .and()
//                .formLogin()
//                    .permitAll()
//                    .loginPage("/login")
//                    .usernameParameter("userName")
//                    .passwordParameter("password")
//                    .loginProcessingUrl("/doLogin") // Submit URL
//                    .defaultSuccessUrl("/")
//                    .failureUrl("/login?error=true")
//                // Config for Logout Page
//                // Cấu hình cho Logout Page.
//                    .and()
//                    .logout().logoutUrl("/logout").logoutSuccessUrl("/");
//        // When the user has logged in as XX.
//        // But access a page that requires role YY,
//        // AccessDeniedException will be thrown.
//        // Khi người dùng đã login, với vai trò XX.
//        // Nhưng truy cập vào trang yêu cầu vai trò YY,
//        // Ngoại lệ AccessDeniedException sẽ ném ra.
//        http.authorizeRequests()
//                .and()
//                .exceptionHandling()
//                .accessDeniedPage("/403Page");
//    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/", "/login", "/logout").permitAll() // CHo phép tất cả các user truy cập
                //.antMatchers("/userInfo").access("hasAnyRole('US', 'AD')")
                //.antMatchers("/admin").access("hasRole('AD')")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .loginPage("/login")
                .usernameParameter("userName")
                .passwordParameter("password")
                .loginProcessingUrl("/doLogin")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error=true")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");
        http.authorizeRequests()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/403Page");
    }
}
