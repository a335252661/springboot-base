package com.example.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2019/11/7
 */
//表示这个类为一个配置类
@Configuration
@PropertySource(value = { "classpath:application.properties" })
//接口所在位置
@MapperScan(basePackages = "com.example.demo.mapper.mysql", sqlSessionTemplateRef  = "mysqlSqlSessionTemplate")
public class DataSourceMySqlConfig {

    @Value("${customize.mybatis.mapper-locations}")
	private String mapperLocations;

    //定义mysql的数据源
    @Bean(name = "mysqlDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    //表示主数据源
    @Primary
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "mysqlSqlSessionFactory")
    @Primary
    // @Qualifier表示查找Spring容器中名字为 mysqlDataSource 的对象
    public SqlSessionFactory mysqlSqlSessionFactory(@Qualifier("mysqlDataSource") DataSource dataSource) throws Exception {

        //如果使用MyBatis-Plus 方式进行单表操作 ， 则需要 调整 SqlSessionFactory 为 MyBatis-Plus 的 SqlSessionFactory
        com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean bean =
                new com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean();

        //正常形式
        //SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(
                mapperLocations
        ));
        return bean.getObject();
    }

    @Bean(name = "mysqlTransactionManager")
    @Primary
    public DataSourceTransactionManager mysqlTransactionManager(@Qualifier("mysqlDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "mysqlSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate mysqlSqlSessionTemplate(@Qualifier("mysqlSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
