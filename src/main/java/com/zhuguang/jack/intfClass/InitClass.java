package com.zhuguang.jack.intfClass;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitClass implements InitializingBean {

    /*
    * 当前类实例化完成后调用的
    *
    * 做资源加载
    * 做日志打印
    * 做xml解析
    * */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("========InitClass========");
    }


    /*
     * 当前类实例化完成后调用的
     *
     * 做资源加载
     * 做日志打印
     * 做xml解析
     * */
    @PostConstruct
    public void postConstruct() {
        System.out.println("========postConstruct========");
    }
}
