package com.project.fiction.Config;

import com.project.fiction.pojo.bookuser;
import com.project.fiction.serviceimpl.informationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义用户认证服务UserDetailsService
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private informationServiceImpl informationService;
    
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername.................................");
        List<bookuser> bookuserList = informationService.getUserRole(userName);
        return changeToUser(bookuserList);
    }
    
    private UserDetails changeToUser(List<bookuser> bookuserList){
        // 权限列表
        /*for (Integer i = 1; i < 5; i++) {
            GrantedAuthority authority = new SimpleGrantedAuthority("role"+i.toString());
            authorityList.add(authority);
        }*/
        UserDetails userDetails = null;
        for (com.project.fiction.pojo.bookuser bookuser : bookuserList) {
            List<GrantedAuthority> authorityList = new ArrayList<>();
            GrantedAuthority authority = new SimpleGrantedAuthority("role"+bookuser.getUserrole().toString());
            authorityList.add(authority);
            System.out.println("进入UserDetailsService.........................");
            userDetails = new User(bookuser.getUsername(),
                    bookuser.getPassword(), authorityList);
        }
        if (userDetails == null) {
            /*List<GrantedAuthority> authorityList = new ArrayList<>();
            GrantedAuthority authority = new SimpleGrantedAuthority("role5");
            authorityList.add(authority);
            userDetails = new User("hhh" , "123456", authorityList);*/
            return null;
        }
        return userDetails;
    }
    
}
