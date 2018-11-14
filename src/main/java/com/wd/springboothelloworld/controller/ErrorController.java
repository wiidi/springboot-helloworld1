package com.wd.springboothelloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: 吴迪 625553347@qq.com 18040509188
 * @CreateDate: 2018/11/12 11:46
 * @UpdateUser:
 * @UpdateDate: 2018/11/12 11:46
 * @UpdateRemark:
 * @Version: 1.0
 * Copyright (c) 2018,武汉中地云申科技有限公司
 * All rights reserved.
 **/
@RestController
@RequestMapping("error")
public class ErrorController {
    @RequestMapping("/getUser")
    public String getUser(int i) {
        int j = 1 / i;
        return "success " + j;
    }
}
