/*
 * Copyright (c) 2017, 2023, zxy.cn All rights reserved.
 *
 */
package cn.zxy;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.List;

/**
 * <p>Description:</p>
 * <p>Class:</p>
 * <p>Powered by zxy On 2023/4/18 10:04 </p>
 *
 * @author zxy [zxy06291@163.com]
 * @version 1.0
 * @since 17
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        try( InputStream is = Resources.getResourceAsStream("mybatis-conf.xml")){
            //建立sql会话工厂类
            SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);
            //建立sql 会话对象
            SqlSession ss = sf.openSession();
            //通过SqlSession 对象实例执行CRUD操作
            String version = ss.selectOne("version",String.class);
            System.out.println(version);

            List<String> dbs = ss.selectList("dbs");
            System.out.println(dbs);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
