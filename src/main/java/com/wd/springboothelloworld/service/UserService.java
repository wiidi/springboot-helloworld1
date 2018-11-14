package com.wd.springboothelloworld.service;

import com.wd.springboothelloworld.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public int insert(String name,Integer age){
        int result=userMapper.insert(name, age);
        log.info("##########result:{}##############",result);
        return result;
    }

}
