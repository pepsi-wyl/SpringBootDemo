package com.wyl.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author by wyl
 * @date 2021/11/15.20点56分
 */

@Scope("singleton")
@Controller(value = "restController")
@RequestMapping(value = "/restController")
public class RESTController {

    /**
     * 获取
     */
    @ResponseBody
//    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @GetMapping(value = "/user")
    public String get() {
        return "Get";
    }

    /**
     * 保存
     */
    @ResponseBody
//    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @PostMapping(value = "/user")
    public String save() {
        return "Post";
    }

    /**
     * 修改
     */
    @ResponseBody
//    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @PutMapping(value = "/user")
    public String put() {
        return "Put";
    }

    /**
     * 删除
     */
    @ResponseBody
//    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    @DeleteMapping(value = "/user")
    public String delete() {
        return "Delete";
    }

}
