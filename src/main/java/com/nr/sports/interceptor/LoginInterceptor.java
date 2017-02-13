package com.nr.sports.interceptor;

import com.nr.sports.controller.LoginController;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by nr on 2017/02/13 0013.
 */
public class LoginInterceptor implements HandlerInterceptor{


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        Object o = request.getSession().getAttribute(LoginController.USERID);
        if(o == null){
            RequestDispatcher rd = request.getRequestDispatcher("/login/loginUI.html");
            rd.forward(request, response);
            return false ;
        }else{
            return true;
        }
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
