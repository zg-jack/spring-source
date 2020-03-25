package com.zhuguang.jack.intfClass;

import com.zhuguang.jack.bean.Student;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

//@Component("factoryBeanClass")
public class FactoryBeanClass implements FactoryBean {

    /*
    * 需要代理的时候
    * mybatis跟spring整合的时候，生成代理
    *
    * 比如说  feign
    *
    * dubbo里面，生成了客户端的代理
    * */
    /*
    * 这个方法是返回类的实例
    * */
    @Override
    public Object getObject() throws Exception {
        Student student = new Student();
        student.setUsername("peter");
        student.setPassword("123");
        return student;
    }

    @Override
    public Class<?> getObjectType() {
        return Student.class;
    }
}
