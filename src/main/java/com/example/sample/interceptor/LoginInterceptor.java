package com.example.sample.interceptor;

import com.example.sample.enums.LoginEnum;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute(LoginEnum.LOGIN_INFO.code()) == null) {
            request.setAttribute(LoginEnum.INTERCEPTOR.code(), true);
            log.info("INTERCEPTOR 세팅!!");
        } else {
            request.removeAttribute(LoginEnum.INTERCEPTOR.code());
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

}
