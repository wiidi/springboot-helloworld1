package com.wd.springboothelloworld;

import com.wd.springboothelloworld.dbconfig.DBConfig1;
import com.wd.springboothelloworld.dbconfig.DBConfig2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableAsync
@ComponentScan
//@EnableAdminServer
//@EnableAutoConfiguration
@MapperScan(basePackages = {"com.wd.springboothelloworld.mapper","com.wd.springboothelloworld.test1.mapper"})
@EnableConfigurationProperties(value = { DBConfig1.class, DBConfig2.class })
public class SpringbootHelloworldApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHelloworldApplication.class, args);
	}
}
