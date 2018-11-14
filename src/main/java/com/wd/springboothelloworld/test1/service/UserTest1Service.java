package com.wd.springboothelloworld.test1.service;


import com.wd.springboothelloworld.test1.mapper.UserTest1Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @Author: 吴迪 625553347@qq.com 18040509188
 * @CreateDate: 2018/11/13 14:57
 * @UpdateUser:
 * @UpdateDate: 2018/11/13 14:57
 * @UpdateRemark:
 * @Version: 1.0
 * Copyright (c) 2018,武汉中地云申科技有限公司
 * All rights reserved.
 **/
@Service
@Slf4j
public class UserTest1Service {
    @Autowired
    UserTest1Mapper userTest1Mapper;

    //指定事务管理器
//    @Transactional(transactionManager = "test1TransactionManager")
    @Transactional()
    public int insert(String name,Integer age){
        int result=userTest1Mapper.insert(name, age);
        log.info("##########result:{}##############",result);
        int i=1/age;
        return result;
    }

}
