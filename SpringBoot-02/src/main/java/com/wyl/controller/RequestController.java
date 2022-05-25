package com.wyl.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author by wyl
 * @date 2021/11/18.19点26分
 */

@Scope("singleton")
@Controller(value = "requestController")
@RequestMapping("/requestController")
public class RequestController {


    //http://127.0.0.1/requestController/params
    @GetMapping(value = "/params")
    public String param_T
    (
            Map<String, Object> map,
            Model model,
            //BindingAwareModelMap  (map+model)
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        map.put("map", "mapParam");
        model.addAttribute("model", "modelParam");
        request.setAttribute("request", "requestParam");
        response.addCookie(new Cookie("cookie", "cookieParam"));
        return "forward:/requestController/successParams";
    }

    @ResponseBody
    @GetMapping(value = "/successParams")
    public Map<String, Object> successParams
            (
                    HttpServletRequest request
            ) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("map", request.getAttribute("map"));
        hashMap.put("model", request.getAttribute("model"));
        hashMap.put("request", request.getAttribute("request"));
        return hashMap;
    }

}
