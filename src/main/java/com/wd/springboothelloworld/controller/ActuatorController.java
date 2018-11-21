package com.wd.springboothelloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: 吴迪 625553347@qq.com 18040509188
 * @CreateDate: 2018/11/21 11:43
 * @UpdateUser:
 * @UpdateDate: 2018/11/21 11:43
 * @UpdateRemark:
 * @Version: 1.0
 * Copyright (c) 2018,武汉中地云申科技有限公司
 * All rights reserved.
 **/
@RestController
public class ActuatorController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
