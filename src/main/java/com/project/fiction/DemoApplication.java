package com.project.fiction;

import com.project.fiction.Config.UserDetailsServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@MapperScan(basePackages = "com.project.fiction.dao.")
@SpringBootApplication
public class DemoApplication{

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


}
