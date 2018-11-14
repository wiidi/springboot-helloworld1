//package com.wd.springboothelloworld.conf;
//
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
//
///**
// * @Description: 解决Mapper找不到sqlSessionFactoryRef问题
// * @Author: 吴迪 625553347@qq.com 18040509188
// * @CreateDate: 2018/11/14 13:43
// * @UpdateUser:
// * @UpdateDate: 2018/11/14 13:43
// * @UpdateRemark:
// * @Version: 1.0
// * Copyright (c) 2018,武汉中地云申科技有限公司
// * All rights reserved.
// **/
////DataSource3
//@Configuration // 注册到springboot容器中
//@MapperScan(basePackages = "com.wd.springboothelloworld.mapper", sqlSessionFactoryRef = "test3SqlSessionFactory")
//public class DataSource3Config {
//
//    /**
//     * @methodDesc: 功能描述:(配置test3数据库)
//     */
//    @Bean(name = "test3DataSource")
////    @ConfigurationProperties(prefix = "spring.datasource.test3")
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource testDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    /**
//     * @methodDesc: 功能描述:(test3 sql会话工厂)
//     */
//    @Bean(name = "test3SqlSessionFactory")
//    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test3DataSource") DataSource dataSource)
//            throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        // bean.setMapperLocations(
//        // new
//        // PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/test3/*.xml"));
//        return bean.getObject();
//    }
//
//    /**
//     * @methodDesc: 功能描述:(test3 事物管理)
//     */
//    @Bean(name = "test3TransactionManager")
//    public DataSourceTransactionManager testTransactionManager(@Qualifier("test3DataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "test3SqlSessionTemplate")
//    public SqlSessionTemplate testSqlSessionTemplate(
//            @Qualifier("test3SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//}
//
