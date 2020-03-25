package com.zhuguang.jack.intfClass;

import com.zhuguang.jack.annotation.MyComponent;
import com.zhuguang.jack.bean.Teacher;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

/*
* 调用时序，是在bean实例化之前掉的
*
* 这个是在实例化之前掉的
* */
@Component
public class BeanDefinitionDemo1 implements BeanDefinitionRegistryPostProcessor {


    /*
    * 自定义扫描器
    * */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        ClassPathBeanDefinitionScanner classPathBeanDefinitionScanner = new ClassPathBeanDefinitionScanner(registry);
        classPathBeanDefinitionScanner.addIncludeFilter(new AnnotationTypeFilter(MyComponent.class));
        classPathBeanDefinitionScanner.scan("com.zhuguang.jack");
    }

    /*
    *
    * Springcloud springbus 进行刷新的时候
    * */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        beanFactory.registerScope("jackScope",new CustomScope());
    }
}
