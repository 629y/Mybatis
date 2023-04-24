/*
 * Copyright (c) 2017, 2023, zxy.cn All rights reserved.
 *
 */
package cn.zxy;

import cn.zxy.entity.Book;
import cn.zxy.mapper.BookMapper;
import cn.zxy.mapper.DbMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.time.LocalDate;


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
        //建立数据源
        PooledDataSource ds = new PooledDataSource("com.mysql.cj.jdbc.Driver","jdbc:mysql:/db","root","root");
        //建立事务管理对象
        TransactionFactory tx = new JdbcTransactionFactory();
        //建立环境
        Environment env = new Environment("dev",tx,ds);
        //建立cfg
        Configuration cfg = new Configuration(env);
        cfg.addMappers("cn.zxy.mapper");
        //cfg.addMapper(DbMapper.class);
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(cfg);
        SqlSession ss = sf.openSession(true);
        DbMapper dm = ss.getMapper(DbMapper.class);
        System.out.println(dm.dbs());
        System.out.println(dm.tbs("db"));

        BookMapper bm = ss.getMapper(BookMapper.class);
        System.out.println(bm.queryAll());
        System.out.println(bm.queryAll().size());

        //添加数据
        Book book = new Book();
        book.setId(2);
        book.setName("《mybatis入门教程》");
        book.setPrice(25.0D);
        book.setAuthor("jack");
        book.setPdate(LocalDate.now());

        int rows = bm.add(book);
        System.out.println(rows);

        ss.close();
    }
}
