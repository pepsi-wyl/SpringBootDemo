package com.wyl.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author by wyl
 * @date 2021/11/16.16点52分
 */


@Scope("singleton")
@Controller(value = "parameterController")
@RequestMapping(value = "/parameterController")
public class ParameterController {

    /**
     * 获取参数值
     */
    @ResponseBody         //json字符串
    @RequestMapping(value = "/get/{id}/{name}", method = RequestMethod.GET)
    public Map<String, Object> get(
            //路径变量   @PathVariable
            @PathVariable("id") Integer id,
            @PathVariable("name") String name,
//            @PathVariable Map<String, String> KV,
            //获取请求头  @RequestHeader
            @RequestHeader("User-Agent") String userAgent,
            @RequestHeader Map<String, String> headers,
            //获取请求参数 @RequestParam
            @RequestParam("age") Integer age,
            @RequestParam("inters") List<String> inters,
            @RequestParam Map<String, String> params
            //获取Cookie的值
//            @CookieValue("cookieName") String cookie,
//            @CookieValue("cookieName") Cookie cookie,
    ) {
        HashMap<String, Object> hashMap = new HashMap<>();
        /**
         * 获取路径变量
         */
        hashMap.put("id", id);
        hashMap.put("name", name);
//        hashMap.put("map", KV);

        /**
         * 获取请求头
         */
//        hashMap.put("userAgent", userAgent);
//        hashMap.put("headers", headers);

        /**
         * 获取请求参数
         */
//        hashMap.put("age", age);
//        hashMap.put("inters", inters);
//        hashMap.put("params", params);

        /**
         * 获取Cookie值
         */
//        hashMap.put("cookie", cookie);
//        hashMap.put("cookie", cookie.getName() + cookie.getValue());
        return hashMap;
    }

    /**
     * 获取请求体
     */
    @ResponseBody        //json字符串
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Map<String, Object> save
    (
            @RequestBody String form
    ) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("form", form);
        return hashMap;
    }

    /**
     * http://127.0.0.1/parameterController/cars/1;name=zhazha;password=888888;password=999999
     * 矩阵变量     默认关闭   需要手动开启   removeSemicolonContent(移除分号内容)
     * 页面开发过程中，Cookie被禁用，把Cookie的值实验矩阵变量的方式进行传递
     */
    @ResponseBody
    @RequestMapping(value = "/cars/{id}", method = RequestMethod.GET)
    public Map<String, Object> MatrixVariable
    (
            @PathVariable("id") String id,
            @MatrixVariable("name") String name,
            @MatrixVariable("password") List<String> password
    ) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("name", name);
        hashMap.put("password", password);
        hashMap.put("id", id);
        return hashMap;
    }

    /**
     * http://127.0.0.1/parameterController/cars/sell;low1=1;rand1=byd,audi/sells;low2=2;rand2=yd
     * 矩阵变量     默认关闭   需要手动开启   removeSemicolonContent(移除分号内容)
     * 页面开发过程中，Cookie被禁用，把Cookie的值实验矩阵变量的方式进行传递
     * 必须要有URL路径变量
     */
    @ResponseBody
    @RequestMapping(value = "/cars/{parameter1}/{parameter2}", method = RequestMethod.GET)
    public Map<String, Object> MatrixVariable2
    (
            @PathVariable("parameter1") String parameter1,
            @PathVariable("parameter2") String parameter2,
            @MatrixVariable(value = "low1", pathVar = "parameter1") Integer low1,
            @MatrixVariable(value = "rand1", pathVar = "parameter1") List<String> brand1,
            @MatrixVariable(value = "low2", pathVar = "parameter2") Integer low2,
            @MatrixVariable(value = "rand2", pathVar = "parameter2") List<String> brand2
    ) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("low1", low1);
        hashMap.put("rand1", brand1);
        hashMap.put("low2", low2);
        hashMap.put("rand2", brand2);
        hashMap.put("parameter1", parameter1);
        hashMap.put("parameter2", parameter2);
        return hashMap;
    }

}
