/*
 * Copyright (c) 2017, 2023, zxy.cn All rights reserved.
 *
 */
package cn.zxy;

import cn.zxy.mapper.DbMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * <p>Description:</p>
 * <p>Class:</p>
 * <p>Powered by zxy On 2023/4/18 21:12 </p>
 *
 * @author zxy [zxy06291@163.com]
 * @version 1.0
 * @since 17
 */
public class MyDemo {
    public static void main(String[] args) {
        try(var is = Resources.getResourceAsStream("mybatis-config.xml")){
            var sf = new SqlSessionFactoryBuilder().build(is);
            var ss = sf.openSession();
            DbMapper db = ss.getMapper(DbMapper.class);
            System.out.println(db.version());

            System.out.println(db.dbs());

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
