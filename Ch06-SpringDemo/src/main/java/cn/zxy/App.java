/*
 * Copyright (c) 2017, 2023, zxy.cn All rights reserved.
 *
 */
package cn.zxy;

import cn.zxy.config.AppConfig;
import cn.zxy.mapper.DbMapper;
import cn.zxy.service.MyService;
import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.SpringVersion;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

/**
 * <p>Description:</p>
 * <p>Class:</p>
 * <p>Powered by zxy On 2023/4/19 9:14 </p>
 *
 * @author zxy [zxy06291@163.com]
 * @version 1.0
 * @since 17
 */
@Configuration
@ComponentScan("cn.zxy")
@MapperScan("cn.zxy.mapper")
@PropertySource("classpath:db.properties")
public class App {
    @Value("${db.driver}")
    private String driver;
    @Value("${db.url}")
    private String url;
    @Value("${db.username:root}")
    private String username;
    @Value("${db.password:root}")
    private String password;


    @Bean(name = "ds", initMethod = "init", destroyMethod = "close")
    @Primary
    public DruidDataSource ds() {
        DruidDataSource ds = new DruidDataSource();
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setUrl(url);
        ds.setDriverClassName(driver);
        return ds;
    }

    @Bean(name = "sf")
    @Primary
    public SqlSessionFactoryBean sf(DruidDataSource ds) throws IOException {
        SqlSessionFactoryBean sf = new SqlSessionFactoryBean();
        sf.setDataSource(ds);
        sf.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*Mapper*.xml"));
        return sf;
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        System.out.println(SpringVersion.getVersion());

        DbMapper dm = ctx.getBean("dbMapper", DbMapper.class);
        System.out.println(dm.dbs());
        System.out.println();

        System.out.println(dm.tbs());
        System.out.println(dm.tbs("mysql"));

        //System.out.println(ctx.getBeanDefinitionCount());
        //System.out.println(Arrays.toString(ctx.getBeanDefinitionNames()));
    }
}
