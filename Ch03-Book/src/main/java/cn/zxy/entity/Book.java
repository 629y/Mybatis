/*
 * Copyright (c) 2017, 2023, zxy.cn All rights reserved.
 *
 */
package cn.zxy.entity;

import lombok.Data;

import java.time.LocalDate;

/**
 * <p>Description:</p>
 * <p>Class:</p>
 * <p>Powered by zxy On 2023/4/20 10:44 </p>
 *
 * @author zxy [zxy06291@163.com]
 * @version 1.0
 * @since 17
 */
@Data
public class Book {
    private Integer id;
    private  String name;
    private  double price;
    private String author;
    private LocalDate pdate;
}
