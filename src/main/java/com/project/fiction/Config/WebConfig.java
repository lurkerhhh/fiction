package com.project.fiction.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 *  web配置类
 */
public class WebConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //super.addResourceHandlers(registry);
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    /**
     * 配置拦截器
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //super.addInterceptors(registry);
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/Authod/**","/Admin/**");

    }
}
