//package com.wd.springboothelloworld.conf;
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
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
//
///**
// * @Description:
// * @Author: 吴迪 625553347@qq.com 18040509188
// * @CreateDate: 2018/11/14 13:40
// * @UpdateUser:
// * @UpdateDate: 2018/11/14 13:40
// * @UpdateRemark:
// * @Version: 1.0
// * Copyright (c) 2018,武汉中地云申科技有限公司
// * All rights reserved.
// **/
//@Configuration // 注册到springboot容器中
//@MapperScan(basePackages = "com.wd.springboothelloworld.test1", sqlSessionFactoryRef = "test1SqlSessionFactory")
//public class DataSource1Config {
//
//    /**
//     * @methodDesc: 功能描述:(配置test1数据库)
//     */
//    @Bean(name = "test1DataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.test1")
////    @Primary
//    public DataSource testDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    /**
//     * @methodDesc: 功能描述:(test1 sql会话工厂)
//     */
//    @Bean(name = "test1SqlSessionFactory")
////    @Primary
//    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test1DataSource") DataSource dataSource)
//            throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        // bean.setMapperLocations(
//        // new
//        // PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/test1/*.xml"));
//        return bean.getObject();
//    }
//
//    /**
//     * @methodDesc: 功能描述:(test1 事物管理)
//     */
//    @Bean(name = "test1TransactionManager")
////    @Primary
//    public DataSourceTransactionManager testTransactionManager(@Qualifier("test1DataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "test1SqlSessionTemplate")
////    @Primary
//    public SqlSessionTemplate testSqlSessionTemplate(
//            @Qualifier("test1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//}
//
