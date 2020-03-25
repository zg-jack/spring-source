package com.zhuguang.jack.intfClass;


import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import java.lang.annotation.Annotation;
import java.lang.reflect.TypeVariable;

public class CustomScope implements Scope {

    private ThreadLocal local = new ThreadLocal();

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {

        if(local.get() != null) {
            return local.get();
        } else {
            //创建实例
            Object object = objectFactory.getObject();
            local.set(object);
            return object;
        }
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
