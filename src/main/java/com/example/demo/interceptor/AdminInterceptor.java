package com.example.demo.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @description 登录session拦截器，如果session中没有登录后的实体，则重定向回登录界面,拦截页面是除了/manager/index请求
 */
public class AdminInterceptor extends HandlerInterceptorAdapter {
    private boolean handleAJAX(HttpServletRequest request, HttpServletResponse response){
        String requestType = request.getHeader("X-Requested-With");
        if ("XMLHttpRequest".equals(requestType)){//是ajax请求
            try {
                response.setContentType("application/json;charset=utf-8");//指定返回的格式为JSON格式
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();
                out.write("{\"code\":0,\"msg\":\" not exist\",\"data\":[]}");
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }else{
            return false;
        }
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (request.getSession().getAttribute("userInfo") == null||request.getSession().getAttribute("adminInfo") == null||request.getSession().getAttribute("agencyInfo") == null){
            if (!handleAJAX(request, response)) {
                response.sendRedirect("/house/user/viewLogin");
            }
            return false;
        }
        return super.preHandle(request, response, handler);
    }


}