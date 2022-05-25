package com.wyl.controller;

import com.wyl.service.email.MailService;
import com.wyl.utils.CpachaUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author by wyl
 * @date 2021/10/17.18点31分
 */
@Slf4j
@Controller
public class CpachaController {

    /**
     * email服务
     */
    @Resource(name = "mailService")
    MailService mailService;

    @RequestMapping("/loginCpacha")
    public void getLoginCpacha(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        CpachaUtil cpachaUtil = new CpachaUtil();
        String generatorVCode = cpachaUtil.generatorVCode();                   //获取验证码
        req.getSession().setAttribute("loginCpacha", generatorVCode);       //给Session设置验证码
        log.info("生成验证码： " + generatorVCode + "   " + " Session: " + req.getSession().getAttribute("loginCpacha"));
        BufferedImage generatorRotateVCodeImage = cpachaUtil.generatorRotateVCodeImage(generatorVCode, true);   //得到旋转验证码
        ImageIO.write(generatorRotateVCodeImage, "gif", resp.getOutputStream());     //写出验证码
    }

    @ResponseBody
    @RequestMapping("/emailCpacha")
    public String getEmailCpacha(HttpServletRequest req,
                                 @RequestParam("email") String email,
                                 @RequestParam("doThing") String doThing) {
        CpachaUtil cpachaUtil = new CpachaUtil();
        cpachaUtil.setVcodeLen(6);                                             //长度为6
        String generatorVCode = cpachaUtil.generatorVCode();                   //获取验证码
        req.getSession().setAttribute(doThing+"emailCpacha", generatorVCode);       //给Session设置验证码
        req.getSession().setAttribute(doThing+"email", email);                      //给Session设置email
        log.info("邮箱号码： " + email + "   " + " Session: " + req.getSession().getAttribute(doThing+"email"));
        log.info("生成验证码： " + generatorVCode + "   " + " Session: " + req.getSession().getAttribute(doThing+"emailCpacha"));
        return "" + mailService.sendMail(email, doThing, generatorVCode, true, null);
    }

}
