package com.wyl.controller;

import com.wyl.pojo.Person;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author by wyl
 * @date 2021/11/15.15点17分
 */

@Scope("singleton")
@Controller(value = "yamlController")
@RequestMapping(value = "/yamlController")
public class YamlController {

    @Resource
    Person person;

    @ResponseBody     //返回Json字符串
    @RequestMapping(value = "/t")
    public String t() {
        return person.toString();
    }

}
