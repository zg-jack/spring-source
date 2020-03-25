package com.zhuguang.jack.test;

import com.zhuguang.jack.bean.Account;
import com.zhuguang.jack.bean.ScopeBean;
import com.zhuguang.jack.bean.Student;
import com.zhuguang.jack.bean.Teacher;
import com.zhuguang.jack.intfClass.InitClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {

    @Test
    public void test1() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.zhuguang.jack");
        Student bean = applicationContext.getBean(Student.class);
        System.out.println(bean.getUsername() + ":" + bean.getPassword());
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.zhuguang.jack");
        System.out.println(applicationContext.getBean("&factoryBeanClass"));
        System.out.println(applicationContext.getBean(InitClass.class));

        System.out.println(applicationContext.getBean(Teacher.class));
        System.out.println(applicationContext.getBean(Account.class));
    }

    @Test
    public void test3() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.zhuguang.jack");
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {

                if (finalI % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + "-->" + applicationContext.getBean("scopeBean"));
                    System.out.println(Thread.currentThread().getName() + "-->" + applicationContext.getBean("scopeBean"));
                } else {
                    System.out.println(Thread.currentThread().getName() + "-->" + applicationContext.getBean("scopeBean"));
                }
            }).start();
        }

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.zhuguang.jack");
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "-->" + applicationContext.getBean(Student.class));
            }).start();
        }

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
