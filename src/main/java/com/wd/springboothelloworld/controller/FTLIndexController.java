package com.wd.springboothelloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @Description:
 * @Author: 吴迪 625553347@qq.com 18040509188
 * @CreateDate: 2018/11/8 17:28
 * @UpdateUser:
 * @UpdateDate: 2018/11/8 17:28
 * @UpdateRemark:
 * @Version: 1.0
 * Copyright (c) 2018,武汉中地云申科技有限公司
 * All rights reserved.
 **/
@Controller
public class FTLIndexController {
    @RequestMapping("/ftlIndex")
    public String ftlIndex(Map<String, Object> map) {
        map.put("name", "wudi");
        map.put("age", "25");
        map.put("sex", "0");
//        return "test/ftl/hello";
        return "flt1";
//        return "test/html/hello";
    }
}
