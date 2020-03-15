package com.project.fiction.Config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.fiction.pojo.bookuser;
import com.project.fiction.serviceimpl.informationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import sun.dc.pr.PRError;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsServicea;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserLoginAuthenticationSuccessHandler userLoginAuthenticationSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.authorizeRequests().antMatchers("/fiction/Administrator/**").hasAuthority("4")
                .antMatchers("/fiction/Authod/**").hasRole("3")
                .antMatchers("/fiction/User/**").hasAnyRole("2","4")
                .antMatchers("/fiction/User/**").hasRole("1")
                .anyRequest().permitAll()
                .and().anonymous();
        http.csrf().ignoringAntMatchers("/fiction/login");
        http.exceptionHandling().authenticationEntryPoint(new UnauthorizedEntryPoint())
                .and().formLogin().usernameParameter("username").passwordParameter("password")
                .loginPage("/fiction/doindex")
                .loginProcessingUrl("/fiction/login").failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest
                            , HttpServletResponse httpServletResponse, AuthenticationException authentication) throws IOException, ServletException {
                        Map<String, Object> map = new HashMap<>();
                        map.put("code","0");
                        map.put("msg","登录失败");
                        map.put("data",authentication);
                        httpServletResponse.setContentType("text/plain; charset=utf-8");
                        httpServletResponse.getWriter().write("登录失败");
                    }
                }).defaultSuccessUrl("/fiction/doindex");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        System.out.println("6666666666666666666666666"+userDetailsServicea);
        auth.userDetailsService(userDetailsServicea).passwordEncoder(new MyPasswordEncoder());
    }
    /*@Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        //super.configure(auth);
        List<bookuser> Rolelist = informationServiceImpl.getUserRole();
        for(bookuser bookRole: Rolelist) {
            authenticationManagerBuilder.inMemoryAuthentication().withUser(bookRole.getUsername())
                    .password(bookRole.getPassword()).roles((bookRole.getUserrole()).toString());
        }
    }*/
}
