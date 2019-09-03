package com.wxt.common.config.interceptor;

import com.wxt.common.config.anotation.Authorization;
import com.wxt.common.exception.BusinessRuntimeException;
import com.wxt.common.exception.ErrorCode;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: TODO
 * @Auther: ThomasWu
 * @Date: 2019/9/3 20:46
 * @Email:1414924381@qq.com
 */
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
    public AuthorizationInterceptor() {
        super();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        String urlString = request.getRequestURL().toString();
        if (urlString.contains("swagger")) {
            return true;
        }

        if (((HandlerMethod) handler).getMethod().getAnnotation(Authorization.class) != null) {
            if (checkAuth(request)) {
                return true;
            } else {
                throw new BusinessRuntimeException(ErrorCode.USER_NOT_LOGIN);
            }
        } else {
            return true;
        }

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    private boolean checkAuth(HttpServletRequest request) {
        String accessToken = request.getHeader("x-token");
        if (accessToken != null) {
            return true;
        }
        return false;
    }
}
