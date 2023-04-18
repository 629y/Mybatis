/*
 * Copyright (c) 2017, 2023, zxy.cn All rights reserved.
 *
 */
package cn.zxy;

import cn.zxy.mapper.DbMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.lang.module.Configuration;

/**
 * <p>Description:</p>
 * <p>Class:</p>
 * <p>Powered by zxy On 2023/4/18 14:49 </p>
 *
 * @author zxy [zxy06291@163.com]
 * @version 1.0
 * @since 17
 */
public class Test {
    public static void main(String[] args) {
//        PooledDataSource ds = new PooledDataSource("com.mysql.cj.jdbc.Driver","jdbc:mysql:/db","root","root");
//        TransactionFactory tx = new JdbcTransactionFactory();
//        Environment env = new Environment("dev",tx,ds);
//        Configuration cfg = new org.apache.ibatis.session.Configuration(env);
//        cfg.addMappers("cn.zxy.mapper");
//
//        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(cfg);
//        SqlSession ss = sf.openSession();
//        DbMapper dm = ss.getMapper(DbMapper.class);
//        System.out.println(dm.dbs());
//
//        BookMapper bm = ss.getMapper(BookMapper.class);
//        System.out.println(bm.queryAll());
    }
}
