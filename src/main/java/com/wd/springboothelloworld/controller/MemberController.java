package com.wd.springboothelloworld.controller;

import com.wd.springboothelloworld.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:演示Springboot异步调用技术
 * @Author: 吴迪 625553347@qq.com 18040509188
 * @CreateDate: 2018/11/8 16:24
 * @UpdateUser:
 * @UpdateDate: 2018/11/8 16:24
 * @UpdateRemark:
 * @Version: 1.0
 * Copyright (c) 2018,武汉中地云申科技有限公司
 * All rights reserved.
 **/
@RestController
@Slf4j
//@EnableAutoConfiguration
//@ComponentScan("com.wd.springboothelloworld.controller")
public class MemberController {
    @Autowired
    MemberService memberService;

    //@RestController注解表示该类中的所有方法返回Json格式
    @RequestMapping("/memberIndex")
    public String memberIndex() {
        return "返回memberIndex";
    }

    @RequestMapping("/addMemberAndEmail")
    public String addMemberAndEmail() {
        log.info("1");
        String result=memberService.addMemberAndEmail();
        log.info("4");
        return result;
    }
//    public static void main(String[] args) {
//        SpringApplication.run(MemberController.class,args);
//    }
}
