package com.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstInterceptor implements HandlerInterceptor {

    /*
    * preHandle方法在目标方法执行之前被调用。
    *      若返回值为false，则不会再调用后续的拦截器和目标方法，也不会postHandle，afterCompletion
    *      若返回值为true，则继续再调用后续的拦截器和目标方法
    *
    * 该方法可以考虑做权限，日志，事务问题
    *
    * */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("FirstInterceptor preHandle");

        return true;

    }

    /*
    * postHandle执行在 调用目标方法之后，但渲染图之前
    * 可以对请求域中的属性或视图进行操作
    *
    * */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("FirstInterceptor postHandle");

    }

    /*
    *
    * 渲染视图之后调用的
    * 释放资源
    *
    * */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        System.out.println("FirstInterceptor afterCompletion");

    }
}
