/*
 * Copyright (c) 2017, 2023, zxy.cn All rights reserved.
 *
 */
package cn.zxy;

import cn.zxy.mapper.DbMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * <p>Description:</p>
 * <p>Class:</p>
 * <p>Powered by zxy On 2023/4/18 11:38 </p>
 *
 * @author zxy [zxy06291@163.com]
 * @version 1.0
 * @since 17
 */
public class Demo {
    public static void main(String[] args) {
        try( var is = Resources.getResourceAsStream("mybatis-config.xml")){
            //建立sql会话工厂类
            var sf = new SqlSessionFactoryBuilder().build(is);
            //建立sql 会话对象
            var ss = sf.openSession();
            //通过SqlSession 对象实例执行CRUD操作

            DbMapper db = ss.getMapper(DbMapper.class);
            System.out.println(db.dbs());
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
