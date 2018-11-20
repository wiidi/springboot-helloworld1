package com.wd.springboothelloworld.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wd.springboothelloworld.entity.User;
import com.wd.springboothelloworld.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
public class UserService {
    @Autowired
    private UserMapper userMapper;

    //指定事务管理器
    @Transactional(transactionManager = "test3TransactionManager")
    public int insert(String name,Integer age){

        int result=userMapper.insert(name, age);
        log.info("##########result:{}##############",result);
        return result;
    }

    /**
     * springboot整合pageHepler
     * page 当前页数
     * pageSize 当前展示数量
     */
    public PageInfo<User>findUserList(int page, int pageSize) {
        //mysql 查询limit
        PageHelper.startPage(page, pageSize);//地层实现原理改写语句
        List<User> listUser =userMapper.findUserList();
        PageInfo<User> pageInfoUserList=new PageInfo<User>(listUser);
        return pageInfoUserList;
    }
}
