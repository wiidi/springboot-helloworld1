package com.wd.springboothelloworld.mapper;

import com.wd.springboothelloworld.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description:Mybatis
 * @Author: 吴迪 625553347@qq.com 18040509188
 * @CreateDate: 2018/11/13 14:54
 * @UpdateUser:
 * @UpdateDate: 2018/11/13 14:54
 * @UpdateRemark:
 * @Version: 1.0
 * Copyright (c) 2018,武汉中地云申科技有限公司
 * All rights reserved.
 **/
//@Component
//@MapperScan

public interface UserMapper {
    //查询
    @Select("SELECT * FROM USER WHERE NAME = #{name}")
    User findByName(@Param("name") String name);

    @Select("SELECT * FROM USER")
    List<User> findUserList();

    //添加
    @Insert("INSERT INTO USER (NAME,AGE) VALUES(#{name},#{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);
}
