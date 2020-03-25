package com.zhuguang.jack.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String queryUser(String userId) {
        return "return =========UserServiceImpl.queryUser";
    }
}
