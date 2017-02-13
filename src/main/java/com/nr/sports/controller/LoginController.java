package com.nr.sports.controller;

import com.nr.sports.model.User;
import com.nr.sports.utils.DB;
import com.nr.sports.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by nr on 2017/02/13 0013.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private DB db ;
    public static final String USERID = "userId";
    public static final String USERNAME ="userName";
    /**
     * 返回登录视图
     * @return
     */
    @RequestMapping("/loginUI")
    public String addUI(){
        return "/login/login";
    }
    /**
     * 登录处理
     * @param user
     * @param modelMap
     * @return 根据验证结果返回不同的视图
     */
    @RequestMapping("/login")
    public String addUser(User user, ModelMap modelMap, HttpServletRequest request, HttpSession httpSession){
        String url = "/login/loginsuccess";
        try {
            String password = Utils.encrypt(user.getPassword());
            String username = user.getUsername();
            List<User> us = db.getAllUser();
            boolean success = false ;
            for(User u : us){
                if(username.equals(u.getUsername()) && password.equals(u.getPassword())){
                    user.setId(u.getId());
                    modelMap.put("user", user);
                    success = true ;
                    break ;
                }
            }
            if(!success)
                url = "/login/loginfail" ;
            if(success == true)
                httpSession.setAttribute(LoginController.USERID, user.getId());
            httpSession.setAttribute(LoginController.USERNAME, user.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return url;
    }
    /**
     * 登录处理
     * @param user
     * @param modelMap
     * @return 根据验证结果返回不同的视图
     */
    @RequestMapping("/otherHandUI")
    public String otherHandUI(){
        return "/login/other";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.removeAttribute(USERID);
        httpSession.removeAttribute(USERNAME);
        return "/../../index";
    }

}
