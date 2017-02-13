package com.nr.sports.controller;

import com.nr.sports.model.User;
import com.nr.sports.utils.DB;
import com.nr.sports.utils.KeyGeneratorImpl;
import com.nr.sports.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

/**
 * Created by nr on 2017/02/13 0013.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private DB db;
    @Autowired
    Validator validator;
    /**
     * 返回添加人员视图
     * @return
     */
    @RequestMapping("/addUserUI")
    public String addUI(){
        return "/user/addUser";
    }

    /**
     * 对添加人员进行处理
     * @param user
     * @param modelMap
     * @return 服务器端定向到展示所有用户页面
     */
    @RequestMapping("/addUser")
    public String addUser(User user,ModelMap modelMap){
        String url = "redirect:/user/showUsers.html" ;
        //服务器端验证
        String error = validate(user);
        if(!"".equals(error.toString())){
            modelMap.addAttribute("errors", "用户保存失败！<br>"+error.toString());
            return "/user/addUser";
        }
        KeyGeneratorImpl k = new KeyGeneratorImpl();
        try {
            user.setId(k.getKey());
            user.setPassword(Utils.encrypt(user.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(db.getUserByUserOrEmail(user.getUsername()) == null)
            db.saveOrUpdateUser(user);
        else{
            modelMap.addAttribute("user", user);
            modelMap.addAttribute("flag", "1");
            url = "/user/addUser";
        }

        return url;
    }
    /**
     * 返回所有人员页面的视图
     * @param modelMap
     * @return
     */
    @RequestMapping("/showUsers")
    public String showUsers(ModelMap modelMap){
        List<User> users = db.getAllUser();
        modelMap.addAttribute("users",users);
        return "/user/showUsers";
    }
    /**
     * 通过人员ID删除人员
     * @param modelMap
     * @param userId
     * @return
     */
    @RequestMapping("/delUser/{userId}")
    public ModelAndView showUsers(ModelMap modelMap, @PathVariable String userId){
        db.delUser(userId);
        return new ModelAndView("redirect:/user/showUsers.html");
    }
    /**
     * 返回编辑页面视图
     * @param modelMap
     * @param userId
     * @return
     */
    @RequestMapping("/editUserUI/{userId}")
    public String editUserUI(ModelMap modelMap,@PathVariable String userId){
        User user = db.getUserById(userId);
        modelMap.addAttribute("user",user);
        return "/user/editUser";
    }
    /**
     * 对编辑人员进行处理
     * @param user
     * @param modelMap
     * @return
     */
    @RequestMapping("/editUser")
    public String editUserUI(User user,ModelMap modelMap){
        //服务器端验证
        String error = validate(user);
        if(!"".equals(error.toString())){
            modelMap.addAttribute("errors", "修改用户失败！<br>"+error.toString());
            return "/user/editUser";
        }
        db.saveOrUpdateUser(user);
        modelMap.addAttribute("flag", "1");
        return "/user/editUser";
    }
    public String validate(User user){
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        StringBuffer buf = new StringBuffer();
        for(ConstraintViolation<User> violation: violations) {
            String f = violation.getPropertyPath().toString() ;
            buf.append(f +":"+ violation.getMessage() +"<br>" );
        }
        return buf.toString();
    }

}
