package com.wd.springboothelloworld.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: 吴迪 625553347@qq.com 18040509188
 * @CreateDate: 2018/11/12 15:37
 * @UpdateUser:
 * @UpdateDate: 2018/11/12 15:37
 * @UpdateRemark:
 * @Version: 1.0
 * Copyright (c) 2018,武汉中地云申科技有限公司
 * All rights reserved.
 **/
@Service
@Slf4j
public class MemberService {
    //添加用户会发送邮件
    public String addMemberAndEmail() {
        log.info("2");
    try{
        Thread.sleep(5000);
    }catch (Exception e){
//        e.printStackTrace();
    }
        return "wudi";
    }
}
