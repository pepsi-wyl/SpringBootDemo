package com.wyl.controller;

import com.wyl.mapper.UserMapper;
import com.wyl.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * @author by wyl
 * @date 2021/11/21.20点09分
 */

@Slf4j

@Scope("singleton")
@Controller(value = "userController")
@RequestMapping(value = "/user")

/**
 * UserController
 */
public class UserController {

    /**
     * 调用Mapper的方法
     */
    @Resource(name = "userMapper")
    UserMapper userMapper;

    /**
     * loginController  登陆
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "username", required = true) String userName,
                        @RequestParam(value = "password", required = true) String password,
                        @RequestParam(value = "vcode", required = true) String vcode,
                        Model model,
                        HttpSession session) {
        if (vcode.trim().toUpperCase(Locale.ROOT).equals(session.getAttribute("loginCpacha").toString().toUpperCase(Locale.ROOT))) {  //验证码正确
            if (userMapper.getUserByUserNameAndPwd(new User(0, userName.trim(), null, password.trim(), 0)) != null) {
                session.setAttribute("loginUser", userName);   //UserName存入Session
                return "redirect:/main.html";   //重定向到mian页面
            } else {
                model.addAttribute("msg", "userName or password error!");
            }
        } else {   //验证码错误
            model.addAttribute("msg", "Cpacha error!");
        }
        return "/index";
    }

    /**
     * loginOutController  注销
     */
    @RequestMapping(value = "/loginOut", method = RequestMethod.GET)
    public String loginOut(HttpSession session) {
        if (session.getAttribute("loginUser") != null) {
            session.removeAttribute("loginUser");          //移除Session 转到登陆界面
        }
        return "redirect:/index";
    }

    /**
     * 查询用户是否存在
     */
    @ResponseBody
    @RequestMapping(value = "/userIsExit", method = RequestMethod.GET)
    public String userIsExit(@RequestParam("username") String userName) {
        if (userName != "" && userName != null) {
            return userMapper.userIsExit(userName) > 0 ? "true" : "false";   //
        }
        return "error";
    }

    /**
     * 查询邮箱是否存在
     */
    @ResponseBody
    @RequestMapping(value = "/emailIsExit", method = RequestMethod.GET)
    public String emailIsExit(@RequestParam("email") String email) {
        if (email != "" && email != null) {
            return userMapper.emailIsExit(email) > 0 ? "true" : "false";
        }
        return "error";
    }

    /**
     * 注册
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam(value = "username") String username,
                           @RequestParam(value = "email") String email,
                           @RequestParam(value = "emailCode") String emailCode,
                           @RequestParam(value = "password") String password,
                           HttpSession session,
                           Model model) {

        String sessionEmail = (String) session.getAttribute("Registeremail");
        String sessionEmailCpacha = (String) session.getAttribute("RegisteremailCpacha");

        if (sessionEmail.equals(email) && sessionEmailCpacha.toUpperCase(Locale.ROOT).equals(emailCode.trim().toUpperCase())) {
            userMapper.adduser(new User(0, username, email, password, 1));     //注册用户
            return "/index";
        }else {
            model.addAttribute("msg","Cpacha error!");
            return "/registrer";
        }
    }

    /**
     * 注册
     */
    @RequestMapping(value = "/retrieve", method = RequestMethod.POST)
    public String retrieve(@RequestParam(value = "email") String email,
                           @RequestParam(value = "emailCode") String emailCode,
                           @RequestParam(value = "password") String password,
                           HttpSession session,
                           Model model) {

        String sessionEmail = (String) session.getAttribute("Retrieveemail");
        String sessionEmailCpacha = (String) session.getAttribute("RetrieveemailCpacha");

        if (sessionEmail.equals(email) && sessionEmailCpacha.toUpperCase(Locale.ROOT).equals(emailCode.trim().toUpperCase())) {
            userMapper.updateUser(new User(0, null, email, password, 0));      //修改密码
            return "/index";
        }else {
            model.addAttribute("msg","Cpacha error!");
            return "/retrievePassword";
        }
    }


}
