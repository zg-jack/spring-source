package com.zhuguang.jack.service;

import com.alibaba.fastjson.JSONObject;
import com.zhuguang.jack.annotation.TargetSource;
import com.zhuguang.jack.dao.CommonMapper;
import com.zhuguang.jack.pojo.ConsultConfigArea;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private CommonMapper commonMapper;

    /*
    * 1、判断缓存有没有
     2、如果没有调用业务方法查询数据库
     3、把数据库返回的值加入到缓存
    * */
    @Cacheable(cacheNames = "mapCache",key = "'user:' + #areaCode")
    @TargetSource("ds2")
    @Transactional
    @Override
    public String queryUser(String areaCode) {
        System.out.println("=========UserServiceImpl.queryUser=====");
        Map map = new HashMap<>();
        map.put("areaCode",areaCode);
        List<ConsultConfigArea> areas = commonMapper.queryAreaByAreaCode(map);
        return JSONObject.toJSONString(areas);
    }

    @TargetSource("ds1")
    @Transactional
    @Override
    public String addArea(ConsultConfigArea area) {
        commonMapper.addArea(area);
        return "OK";
    }
}
