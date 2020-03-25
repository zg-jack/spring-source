package com.zhuguang.jack.bean;

import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/*
*
* <bean class="com.zhuguang.jack.bean.Student" id="" denpOn="" init-method="">
* */
@Component
//@Service
//@Controller
//@Repository
//@Configuration
public class Student {

    private String username = "jack";

    private String password = "123";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
