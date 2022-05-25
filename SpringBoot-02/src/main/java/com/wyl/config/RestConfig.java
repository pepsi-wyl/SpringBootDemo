package com.wyl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

/**
 * @author by wyl
 * @date 2021/11/16.10点25分
 */

/**
 * 修改TEST的默认配置  defaultMethodParam="_method"
 * HiddenHttpMethodFilter  .setMethodParam("XXX");
 */

@Configuration(proxyBeanMethods = false)
public class RestConfig implements WebMvcConfigurer {
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        hiddenHttpMethodFilter.setMethodParam("method");
        return hiddenHttpMethodFilter;
    }
}



