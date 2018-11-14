package com.wd.springboothelloworld.test2.controller;

import com.wd.springboothelloworld.test2.service.UserTest2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:测试mybatis整合springboot
 * @Author: 吴迪 625553347@qq.com 18040509188
 * @CreateDate: 2018/11/13 15:05
 * @UpdateUser:
 * @UpdateDate: 2018/11/13 15:05
 * @UpdateRemark:
 * @Version: 1.0
 * Copyright (c) 2018,武汉中地云申科技有限公司
 * All rights reserved.
 **/
@RestController
@RequestMapping("/test2")
public class UserTest2Controller {
    @Autowired
    UserTest2Service userTest2Service;
    @RequestMapping("/insert")
    public Integer insert(String name,Integer age){
        return userTest2Service.insert(name, age);
    }
}
