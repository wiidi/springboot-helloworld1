package com.wd.springboothelloworld.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description:
 * @Author: 吴迪 625553347@qq.com 18040509188
 * @CreateDate: 2018/11/12 15:05
 * @UpdateUser:
 * @UpdateDate: 2018/11/12 15:05
 * @UpdateRemark:
 * @Version: 1.0
 * Copyright (c) 2018,武汉中地云申科技有限公司
 * All rights reserved.
 **/
@Data
@Slf4j
public class User {
    private String name;
    private Integer age;
    private Integer id;

//    //lombok 底层使用字节码ASM 修改字节码文件，生成get和set方法
//    public static void main(String[] args) {
//        User user = new User();
//        user.setName("wudi");
//        user.setAge(25);
//        log.info(user.toString());
//    }
}
