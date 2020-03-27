package com.zhuguang.jack.service;

import com.zhuguang.jack.pojo.ConsultConfigArea;

public interface UserService {
    String queryUser(String userId);

    String addArea(ConsultConfigArea area);
}
