package com.oa.global;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author lcyang
 * @Date 2018/7/18 17:11
 * @Description
 */
public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        /** 过滤有关键字login的请求 **/
        String url = httpServletRequest.getRequestURI();
        if (url.toLowerCase().indexOf("login")>=0){
            return true;
        }
        /** 放行登陆用户的请求 **/
        HttpSession session = httpServletRequest.getSession();
        if (session.getAttribute("employee")!=null){
            return true;
        }
        httpServletResponse.sendRedirect("/to_login");
        return false;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
