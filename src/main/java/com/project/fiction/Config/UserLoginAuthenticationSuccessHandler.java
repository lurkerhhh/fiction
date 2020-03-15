package com.project.fiction.Config;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 认证成功处理类
 */
@Component("UserLoginAuthenticationSuccessHandler")
public class UserLoginAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse httpServletResponse
            , Authentication authentication) throws IOException, ServletException {

        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        out.write("{'status':200,'msg':'true'}");
        out.flush();
        out.close();
        //super.onAuthenticationSuccess(request, response, authentication);
    }
}
