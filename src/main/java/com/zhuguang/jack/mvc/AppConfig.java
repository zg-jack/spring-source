package com.zhuguang.jack.mvc;

import com.zhuguang.jack.interceptor.UserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
/*
约定大于配置

* 1、创建HandlerMapping
* 2、创建HandlerAdapter
* 3、创建视图解析
* 4、创建消息转换器
* 。。。。。。。
*
* 把springmvc的功能，给我加上来
* */
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private UserInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor).addPathPatterns("/user/**");
    }
}
