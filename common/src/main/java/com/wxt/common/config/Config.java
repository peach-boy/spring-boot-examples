package com.wxt.common.config;

import com.wxt.common.config.interceptor.AuthorizationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description: TODO
 * @Auther: ThomasWu
 * @Date: 2019/9/3 20:43
 * @Email:1414924381@qq.com
 */
@Configuration
public class Config {

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new AuthorizationInterceptor());
            }
        };
    }
}
