package com.zhuguang.jack.aop;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
/*
* 就是告诉spring开启AOP的功能
* */
@EnableAspectJAutoProxy
public class EnableAspectJAutoProxyBean {
}
