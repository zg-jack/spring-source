package com.zhuguang.jack.intfClass;

import com.zhuguang.jack.bean.Teacher;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/*
* 调用时序，是在bean实例化之前掉的
*
* 这个是在实例化之前掉的
* */
@Component
public class BeanDefinitionDemo implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        String[] beanDefinitionNames = registry.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = registry.getBeanDefinition(beanDefinitionName);

            if(beanDefinitionName.equals("student")) {
                GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
                genericBeanDefinition.setBeanClass(Teacher.class);
                MutablePropertyValues propertyValues = genericBeanDefinition.getPropertyValues();
                propertyValues.addPropertyValue("username","peter");
                propertyValues.addPropertyValue("password","567");

                registry.registerBeanDefinition("teacher",genericBeanDefinition);
            }
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
