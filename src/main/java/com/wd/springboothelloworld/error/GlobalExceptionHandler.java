package com.wd.springboothelloworld.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:全局捕获异常
 * @Author: 吴迪 625553347@qq.com 18040509188
 * @CreateDate: 2018/11/12 12:28
 * @UpdateUser:
 * @UpdateDate: 2018/11/12 12:28
 * @UpdateRemark:
 * @Version: 1.0
 * Copyright (c) 2018,武汉中地云申科技有限公司
 * All rights reserved.
 **/
//监控com.wd.springboothelloworld.controller下的所有方法，捕获异常
//还可以深入研究
@ControllerAdvice(basePackages = "com.wd.springboothelloworld.controller")
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody  //返回json格式

    public Map<String, Object> errorResult() {
        //在实际项目中，在此将异常写入到日志中。
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("errorCode", "500");
        map.put("error", "系统错误");
        return map;
    }
}
