/*
 * Copyright (c) 2017, 2023, zxy.cn All rights reserved.
 *
 */
package cn.zxy;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * <p>Description:</p>
 * <p>Class:</p>
 * <p>Powered by zxy On 2023/4/25 1:22 </p>
 *
 * @author zxy [zxy06291@163.com]
 * @version 1.0
 * @since 17
 */
public class MyDemo {
    public static Logger log = LogManager.getLogger();
    public static void main(String[] args) {
        log.log(Level.ERROR,"no");
        log.debug("dddebug");
        for (int i = 1; i <= 10; i++) {
            log.log(Level.ERROR,"hello {[%03d]}",i);
        }
    }
}
