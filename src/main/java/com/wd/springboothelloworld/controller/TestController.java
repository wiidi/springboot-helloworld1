package com.wd.springboothelloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description:
 * @Author: 吴迪 625553347@qq.com 18040509188
 * @CreateDate: 2018/11/12 10:47
 * @UpdateUser:
 * @UpdateDate: 2018/11/12 10:47
 * @UpdateRemark:
 * @Version: 1.0
 * Copyright (c) 2018,武汉中地云申科技有限公司
 * All rights reserved.
 **/

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/ftl") //返回ftl页面
    public ModelAndView test() {
        return new ModelAndView("test/ftl/hello");
    }

    @RequestMapping("/html") //返回HTML页面
    public String html() {

        return "test/html/hello";
    }

    @RequestMapping("/string") //返回字符串
    @ResponseBody
    public String rest() {
        return "string";
    }

    @RequestMapping("/jsp")
    public String jsp() {

        return "hello";
    }
}

