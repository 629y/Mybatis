/*
 * Copyright (c) 2017, 2023, zxy.cn All rights reserved.
 *
 */
package cn.zxy.mapper;

import cn.zxy.entity.Book;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>Description:</p>
 *
 * <p>Powered by zxy On 2023/4/18 15:10 </p>
 *
 * @author zxy [zxy06291@163.com]
 * @version 1.0
 * @since 17
 */
public interface BookMapper {
    @Select("select name,price from t_book")
    public List<Map<String,Object>> queryAll();

    @Select("select name from t_book where name like '%java%'")
    public List<String> queryBook();

}
