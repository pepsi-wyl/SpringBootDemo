package com.wyl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;


/**
 * @author by wyl
 * @date 2021/11/21.09点53分
 */


/**
 * 拓展MVC   DispatchServlet
 */

@Configuration(value = "myMvcConfig", proxyBeanMethods = true)
public class MyMvcConfig implements WebMvcConfigurer {


    /**
     * addViewControllers
     * 实现实现无业务逻辑跳转  映射路径
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        /**
         * 配置首页login页面
         * "/ /index /index.html"可以跳转到index.html页面
         */
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");

        /**
         * 配置注册页面
         */
        registry.addViewController("/toRegister").setViewName("registrer");

        /**
         * 配置忘记密码页面
         */
        registry.addViewController("/toRetrieve").setViewName("retrievePassword");

        /**
         * 登陆成功进入dashboard.html主页面
         */
        registry.addViewController("/main.html").setViewName("main");

    }


    /**
     * 配置国际化i18n 注册自定义LocaleResolver
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new LocaleResolver() {
            @Override
            public Locale resolveLocale(HttpServletRequest request) {
                String language = request.getParameter("l");
                return (StringUtils.isEmpty(language) == true) ? Locale.getDefault() : new Locale(language.split("_")[0], language.split("_")[1]);
            }
            @Override
            public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

            }
        };
    }


    /**
     * 配置拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {
                    @Override
                    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                        if (request.getSession().getAttribute("loginUser") != null) {  //登陆放行
                            return true;
                        } else {  //没有登陆返回首页
                            request.setAttribute("msg", "没有登陆，请先登陆!!!");
                            request.getRequestDispatcher("/index").forward(request, response);
                            return false;
                        }
                    }
                }).addPathPatterns("/**").
                excludePathPatterns("/", "/index", "/index.html", "/user/login", "/loginCpacha").
                excludePathPatterns("/toRegister", "/user/userIsExit", "/user/emailIsExit", "/emailCpacha", "/user/register").
                excludePathPatterns("/toRetrieve","/user/retrieve").
                excludePathPatterns("/css/*", "/js/*", "/img/*");
    }


}
