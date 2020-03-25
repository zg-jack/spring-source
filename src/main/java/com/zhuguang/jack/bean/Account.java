package com.zhuguang.jack.bean;

import com.zhuguang.jack.annotation.MyComponent;
import lombok.Data;

@Data
@MyComponent
public class Account {
    private String accountId = "123";
}
