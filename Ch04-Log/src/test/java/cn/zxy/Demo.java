/*
 * Copyright (c) 2017, 2023, zxy.cn All rights reserved.
 *
 */
package cn.zxy;

import cn.zxy.mapper.BookMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;
/**
 * <p>Description:</p>
 * <p>Class:</p>
 * <p>Powered by zxy On 2023/4/18 15:11 </p>
 *
 * @author zxy [zxy06291@163.com]
 * @version 1.0
 * @since 17
 */
public class Demo {
    public final static Logger log = LogManager.getLogger();

    public static void main(String[] args) {
        //logback log4j2
        try (var is = Resources.getResourceAsStream("mybatis-config.xml")) {
            var sf = new SqlSessionFactoryBuilder().build(is);
            var ss = sf.openSession();
            BookMapper bm = ss.getMapper(BookMapper.class);
            System.out.println(bm.queryAll());

            log.debug("{}", bm.queryAll());

            log.debug("{}", bm.queryBook());
            log.log(Level.ERROR, "error");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
