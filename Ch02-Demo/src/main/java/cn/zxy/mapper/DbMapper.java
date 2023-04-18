/*
 * Copyright (c) 2017, 2023, zxy.cn All rights reserved.
 *
 */
package cn.zxy.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>Description:</p>
 *
 * <p>Powered by zxy On 2023/4/18 21:09 </p>
 *
 * @author zxy [zxy06291@163.com]
 * @version 1.0
 * @since 17
 */
public interface DbMapper {
    public List<String> dbs();

    @Select("select version()")
    public String version();
}
