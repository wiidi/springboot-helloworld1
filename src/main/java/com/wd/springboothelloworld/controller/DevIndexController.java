package com.wd.springboothelloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: 吴迪 625553347@qq.com 18040509188
 * @CreateDate: 2018/11/14 17:59
 * @UpdateUser:
 * @UpdateDate: 2018/11/14 17:59
 * @UpdateRemark:
 * @Version: 1.0
 * Copyright (c) 2018,武汉中地云申科技有限公司
 * All rights reserved.
 **/
@RestController
@RequestMapping("/dev")
public class DevIndexController {
    @RequestMapping("/index")
    public String indexDev(){
        String result = "springbootV2.0";
        return result;
    }

    //测试热部署
//    @RequestMapping("/myIndex")
//    public String myIndexDev(){
//        String result = "springbootV2.0-V1.0";
//        return result;
//    }
}
