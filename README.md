现阶段所存在的框架：

##### 1.ssh - spring struts hibernate

##### 2.ssm - spring springmvc mybatis mybatis

##### 3.springboot

##### 4.spring  cloud分布式开发

##### 5.orm技术

# Mybatis 持久层框架技术

## 1、Mybatis概述

### 1.1 ORM是什么

​	常见的ORM框架有：**Mybatis** 、 Hibernate、TopLink、Castor JDO、Apache OJB等。  

​	ORM 是 Object Relational Mapping 的缩写，译为`对象关系映射`，它解决了对象和关系型数据库之间的数据交互问题。

​	使用面向对象编程时，数据很多时候都存储在对象里面，具体来说是存储在对象的各个属性（也称成员变量）中。例如有一个 User 类，它的 id、username、password、email 属性都可以用来记录用户信息。当我们需要把对象中的数据存储到数据库时，按照传统思路，就得手动编写 SQL 语句，将对象的属性值提取到 SQL 语句中，然后再调用相关方法执行 SQL 语句。

​	而有了 ORM 技术以后，只要提前配置好对象和数据库之间的映射关系，`ORM 就可以自动生成 SQL 语句`，并将对象中的数据自动存储到数据库中，整个过程不需要人工干预。在 Java 中，ORM 一般使用 XML 或者注解来配置对象和数据库之间的映射关系。

![image-20230418122307237](D:\新建文件夹\java\ssms-mybatis\mybatis\README\image-20230418122307237.png)

和自动生成 SQL 语句相比，手动编写 SQL 语句的缺点是非常明显的，主要体现在以下两个方面：

- 对象的属性名和数据表的字段名往往不一致，在编写 SQL 语句时需要非常小心，要逐一核对属性名和字段名，确保它们不会出错，而且彼此之间要一一对应。
- 此外，当 SQL 语句出错时，数据库的提示信息往往也不精准，这给排错带来了不小的困难。

ORM 的出现，恰好解决了这些难题。

​	面向对象编程和关系型数据库都是广泛使用的两种技术，ORM 使得两者之间的数据交互变得自动化，同时也让源代码中不再出现 SQL 语句。

​	ORM 是一种双向数据交互技术，它不仅可以将对象中的数据存储到数据库中，也可以反过来将数据库中的数据提取到对象中。

下表说明了关系型数据库和对象之间的对应关系：

| 数据库                       | 类/对象                   |
| ---------------------------- | ------------------------- |
| 表（table）                  | 类（class）               |
| 表中的记录（record，也称行） | 对象（object）            |
| 表中的字段（field，也称列）  | 对象中的属性（attribute） |

例如，现在有一张 user 表，它包含 id、user_id 和 user_name 三个字段，另外还有一个 Java User 类，它包含 id、userId 和 userName 三个属性，下图演示了它们之间的对应关系：

![image-20230418122803497](D:\新建文件夹\java\ssms-mybatis\mybatis\README\image-20230418122803497.png)
                                         user 表和 User 类之间的对应关系

​	数据表和类用来描述数据的表现形式，它们之间是相互对应的；记录和对象用来真正地存储数据，它们之间也是相互对应的。

### 1.2 ORM 的缺点

ORM 在提高开发效率的同时，也带来以下缺点：

- ORM 增加了大家的学习成本，为了使用 ORM 技术，您至少需要掌握一种 ORM 框架。
- 自动生成 SQL 语句会消耗计算资源，这势必会对程序性能造成一定的影响。
- 对于复杂的数据库操作，ORM 通常难以处理，即使能处理，自动生成的 SQL 语句在性能方面也不如手写的原生 SQL。
- 生成 SQL 语句的过程是自动进行的，不能人工干预，这使得开发人员无法定制一些特殊的 SQL 语句。

### 1.3 ORM 框架

ORM 技术通常使用单独的框架，或者框架的某个模块来实现，常用的 ORM 框架：

- 常用的 Java ORM 框架有 [Hibernate](http://c.biancheng.net/hibernate/) 和 [Mybatis](http://c.biancheng.net/mybatis/)。
- 常用的 Python ORM 实现有 SQLAlchemy 框架、Peewee 框架、[Django](http://c.biancheng.net/django/) 框架的 ORM 模块等。
- 常用的 PHP ORM 实现有 Laravel 框架、Yii 框架的 ORM 模块、ThinkPHP 框架的 ORM 模块等。

### 1.4 mybatis介绍

中文官网参考：https://mybatis.org/mybatis-3/zh/index.html

​	MyBatis 是一款优秀的持久层框架，它支持自定义 SQL、存储过程以及高级映射。MyBatis 免除了几乎所有的 JDBC 代码以及设置参数和获取结果集的工作。MyBatis 可以通过简单的 XML 或注解来配置和映射原始类型、接口和 Java POJO（Plain Old Java Objects，普通老式 Java 对象）为数据库中的记录

![image-20230418125528942](D:\新建文件夹\java\ssms-mybatis\mybatis\README\image-20230418125528942.png)

![image-20230418125611764](D:\新建文件夹\java\ssms-mybatis\mybatis\README\image-20230418125611764.png)

​	**JPA**:JPA是Java Persistence API的简称，中文名Java持久层API，是JDK 5.0注解或XML描述对象-关系
表的映射关系，并将运行期的实体对象持久化到数据库中。
​	Sun引入新的JPA ORM规范出于两个原因:

- 简化现有Java EE和Java SE应用开发工作;

- Sun希望整合ORM技术，实现天下归一。  

###### mybatis-plus   https://baomidou.com/ 官网

![image-20230418125829415](D:\新建文件夹\java\ssms-mybatis\mybatis\README\image-20230418125829415.png)

## 2、mybatis开发环境准备

### 2.1 idea maven conf

`maven/conf/settings.xml`

![image-20230418130543003](D:\新建文件夹\java\ssms-mybatis\mybatis\README\image-20230418130543003.png)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<settings xmlns="http://maven.apache.org/SETTINGS/1.2.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.2.0 https://maven.apache.org/xsd/settings-1.2.0.xsd">
	<localRepository>d:/maven/repo</localRepository>
	<mirrors>
		<!-- 阿里镜像仓库 -->
		<mirror>
			<id>alimaven</id>
			<name>aliyun maven</name>
			<url>http://maven.aliyun.com/nexus/content/groups/public/</url>
			<mirrorOf>central</mirrorOf>
		</mirror>
	</mirrors>	
	<profiles>
	    <!-- maven项目全局默认配置jdk版本信息  -->
		<profile>
			<id>jdk-17</id>
			<activation>
				<activeByDefault>true</activeByDefault>
				<jdk>17</jdk>
			</activation>
			<properties>
				<maven.compiler.source>17</maven.compiler.source>
				<maven.compiler.target>17</maven.compiler.target>
				<maven.compiler.compilerVersion>17</maven.compiler.compilerVersion>
			</properties>
		</profile>
	</profiles>
</settings>

```

### 2.2 mybatis项目开发依赖

`pom.xml`

```xml
<!-- org.mybatis/mybatis -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.13</version>
</dependency>

```

### 2.3 mysql driver

`pom.xml`

```xml
<!-- mysql-connector-java -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.32</version>
</dependency>

```

## 3、mybatis入门程序案例

### 3.1 helloworld

> 第一步 建立项目，pom.xml添加依赖

```xml
<!-- org.projectlombok/lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.24</version>
        <scope>provided</scope>
    </dependency>

    <!-- org.mybatis/mybatis -->
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>3.5.13</version>
    </dependency>


    <!-- mysql-connector-java -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.32</version>
    </dependency>
```

父模块pom.xml文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>cn.zxy</groupId>
    <artifactId>mybatis</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>pom</packaging>
    <modules>
        <module>Ch01-Hello</module>
        <module>Ch02-Demo</module>
        <module>Ch03-Book</module>
        <module>Ch04-Log</module>
    </modules>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <!-- mysql-connector-java -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.32</version>
        </dependency>

        <!-- org.mybatis/mybatis -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.13</version>
        </dependency>


        <!-- org.projectlombok/lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.24</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>

    <build>
        <resources>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.xml</include>
                </includes>
            </resource>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.xml</include>
                </includes>
            </resource>
        </resources>
    </build>
</project>
```

> 第二步 编写DbMapper 映射配置文件

`DbMapper.xml 映射配置文件`

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="cn.zxy.mapper.DbMapper">
    <select id="version" resultType="string">
        select version()
    </select>

    <select id="dbs" resultType="java.lang.String">
        show databases
    </select>
</mapper>
```

> 第三步 建立mybatis配置文件

`/src/main/resources/mybatis-conf.xml`

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306"/>
                <property name="username" value="root"/>
                <property name="password" value="root"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <mapper resource="cn/zxy/mapper/DbMapper.xml"/>
    </mappers>
</configuration>
```

> 第四步 测试程序

`src/main/java/cn/zxy/Demo.java`

```java
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
```

![image-20230418210207909](D:\新建文件夹\java\ssms-mybatis\mybatis\README\image-20230418210207909.png)

### **3.2 demo案例**

`ch02-demo`

> 第一步 建立项目 pom.xml文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>cn.webrx</groupId>
        <artifactId>myatis2023</artifactId>
        <version>1.0</version>
    </parent>

    <groupId>cn.webrx</groupId>
    <artifactId>ch02-demo</artifactId>


    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <java.version>17</java.version>
    </properties>

    <build>
        <resources>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.xml</include>
                </includes>
            </resource>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*</include>
                </includes>
            </resource>
        </resources>
    </build>

</project>

```

> 第二步 在resources 建立db.properties 建立mybatis-config.xml核心配置文件

`src/main/resources/db.properties`

```yml
db.driver=com.mysql.cj.jdbc.Driver
db.url=jdbc:mysql:/db
db.username=root
db.password=root
```

`src/main/resources/mybatis-config.xml`

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <properties resource="db.properties"/>

    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="${db.driver}"/>
                <property name="url" value="${db.url}"/>
                <property name="username" value="${db.username}"/>
                <property name="password" value="${db.password}"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <!--<mapper resource="cn/zxy/mapper/DbMapper.xml"/>-->

        <!-- mybatis 核心配置文件，会自动加载mapper下的所有接口及和接口同名的xml配置 -->
        <package name="cn.zxy.mapper"/>

        <!--<mapper class="cn.zxy.mapper.DbMapper"/>-->
        <!--<mapper resource="cn/zxy/mapper/DbMapper.xml"/>-->
    </mappers>
</configuration>
```

> 第三步 编写接口DbMapper.java 及 DbMapper.xml

`src/main/java/cn/zxy/mapper/DbMapper.java`

```java
/*
 * Copyright (c) 2006, 2023, webrx.cn All rights reserved.
 *
 */
package cn.webrx.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p></p>
 * <p>Powered by webrx On 2023-04-18 11:34:24</p>
 *
 * @author webrx [webrx@126.com]
 * @version 1.0
 * @since 17
 */
public interface DbMapper {
    public List<String> dbs();

    @Select("select version()")
    public String version();
}
```

`src/main/java/cn/zxy/mapper/DbMapper.xml`

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="cn.zxy.mapper.DbMapper">
    <select id="dbs">show databases</select>
</mapper>
```

> 第四步 编写程序进行测试 `src/main/java/cn/zxy/MyDemo.java`

```java
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
```

![image-20230419214821647](D:\新建文件夹\java\ssms-mybatis\mybatis\README\image-20230419214821647.png)

###  3.3 编程方式

建立项目，不写配置文件mybatis-config.xml，直接编写使用mybatis，编写接口和接口的映射xml

> 第一步 ：建立项目，pom.xml内容如下

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>cn.webrx</groupId>
    <artifactId>logbackdemo</artifactId>
    <version>1.0</version>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <java.version>17</java.version>
    </properties>

    <dependencies>
 
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.13</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.32</version>
        </dependency>

    </dependencies>

    <build>
        <finalName>${project.artifactId}</finalName>
        <testSourceDirectory>src/test/java</testSourceDirectory>
        <sourceDirectory>src/main/java</sourceDirectory>
        <!-- 处理无法加载资源配置文件 -->
        <resources>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.xml</include>
                    <include>**/*.html</include>
                    <include>**/*.properties</include>
                </includes>
            </resource>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.xml</include>
                    <include>**/*.html</include>
                    <include>**/*.properties</include>
                </includes>
            </resource>
        </resources>
    </build>
</project>
```

> 第二步：编写接口和接口映射文件

`src/main/java/cn/zxy/mapper/DbMapper.java `接口

```java
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
 * <p>Powered by zxy On 2023/4/18 14:47 </p>
 *
 * @author zxy [zxy06291@163.com]
 * @version 1.0
 * @since 17
 */
public interface DbMapper {
    @Select("show databases")
    public List<String> dbs();
    public List<String> tbs(String db);
}
```

`src/main/java/cn/zxy/mapper/DbMapper.xml `映射接口

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="cn.zxy.mapper.DbMapper">
    <select id="tbs" resultType="string">
        show tables from ${db}
    </select>

    <!--<select id="dbs" resultType="string">show databases</select>-->
</mapper>
```

`src/main/java/cn/zxy/mapper/BookMapper.java`

```java
/*
 * Copyright (c) 2017, 2023, zxy.cn All rights reserved.
 *
 */
package cn.zxy.mapper;

import cn.zxy.entity.Book;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>Description:</p>
 *
 * <p>Powered by zxy On 2023/4/20 17:18 </p>
 *
 * @author zxy [zxy06291@163.com]
 * @version 1.0
 * @since 17
 */
public interface BookMapper {
    @Select("select * from t_st ")
    List<Book> queryAll();

    int count();

    int add(Book book);
}
```

`src/main/java/cn/zxy/mapper/BookMapper.xml`

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="cn.zxy.mapper.BookMapper">
    <insert id="add">
        insert into t_book set id=#{id}, name = #{name},price=#{price},author=#{author},pdate=#{pdate}
    </insert>
    <select id="count" resultType="int">
        select count(*) from t_book
    </select>

    <!--<select id="dbs" resultType="string">show databases</select>-->
</mapper>
```

`src/main/java/cn/zxy/entity/Book.java`

```java
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
```

> 第三步：编写主测试程序 `test/java/cn/zxy/Test.java`

```java
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
```

![image-20230424204907558](D:\新建文件夹\java\ssms-mybatis\mybatis\README\image-20230424204907558.png)

### 3.4 整合日志框架显示SQL语句

> 第一步 ： 建立项目，添加依赖log4j2

`pom.xml`

```xml
<!-- org.apache.logging.log4j/log4j-core -->
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.20.0</version>
</dependency>
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>cn.zxy</groupId>
        <artifactId>mybatis</artifactId>
        <version>1.0-SNAPSHOT</version>
    </parent>

    <artifactId>Ch04-Log</artifactId>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <!-- org.apache.logging.log4j/log4j-core -->
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-core</artifactId>
            <version>2.20.0</version>
        </dependency>

    </dependencies>
    <build>
        <finalName>${project.artifactId}</finalName>
        <testSourceDirectory>src/test/java</testSourceDirectory>
        <sourceDirectory>src/main/java</sourceDirectory>
        <!-- 处理无法加载资源配置文件 -->
        <resources>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.xml</include>
                    <include>**/*.html</include>
                    <include>**/*.properties</include>
                </includes>
            </resource>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.xml</include>
                    <include>**/*.html</include>
                    <include>**/*.properties</include>
                </includes>
            </resource>
        </resources>
    </build>
</project>
```

> 第二步：在resources/建立log4j2.xml文件

`src/main/resources/log4j2.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="WARN">
    <Appenders>
        <Console name="LogToConsole" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
        </Console>
        <File name="LogToFile" fileName="log/test.log">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
        </File>
    </Appenders>
    <Loggers>
        <Logger name="orgb" level="error">
            <AppenderRef ref="LogToConsole"/>
        </Logger>
        <Logger name="orga" level="debug" additivity="false">
            <AppenderRef ref="LogToConsole"/>
            <AppenderRef ref="LogToFile"/>
        </Logger>

        <Logger name="cn.zxy.mapper" level="debug">
            <AppenderRef ref="LogToConsole"/>
            <AppenderRef ref="LogToFile"/>
        </Logger>

        <Logger name="org.zxy.Demo" level="debug">
            <AppenderRef ref="LogToConsole"/>
            <AppenderRef ref="LogToFile"/>
        </Logger>

        <Root level="error">
            <AppenderRef ref="LogToConsole"/>
        </Root>
    </Loggers>
</Configuration>
```

`src/main/resources/mybatis-config.xml`

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <properties resource="db.properties"/>

    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="${db.driver}"/>
                <property name="url" value="${db.url}"/>
                <property name="username" value="${db.username}"/>
                <property name="password" value="${db.password}"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
       <package name="cn.zxy.mapper"/>
    </mappers>
</configuration>
```

`src/main/resources/db.properties`

```properties
db.driver=com.mysql.cj.jdbc.Driver
db.url=jdbc:mysql://localhost:3306/db
db.username=root
db.password=root
```

`src/main/java/cn/zxy/mapper/BookMapper.java`

```java
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
```

`src/main/java/cn/zxy/mapper/BookMapper.xml`

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="cn.zxy.mapper.BookMapper">
    <select id="count" resultType="int">
        select count(*)
        from t_book
    </select>

</mapper>
```

> 第三步：直接演示使用

`test/java/cn/zxy/Demo.java`

```java
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
```

![image-20230424214249463](D:\新建文件夹\java\ssms-mybatis\mybatis\README\image-20230424214249463.png)

### 3.5 批量加载mappers xml

在项目上`resources/mapper/mapper/Xxx.xml`

```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <properties resource="db.properties"/>

    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="${db.driver}"/>
                <property name="url" value="${db.url}"/>
                <property name="username" value="${db.username}"/>
                <property name="password" value="${db.password}"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <package name="cn.webrx.mapper"/>
        <!--<mapper class="cn.webrx.mapper.DbMapper"/>-->
        <!--<mapper resource="mapper/DbMapper.xml"/>-->

        <!--<mapper class="cn.webrx.mapper.BookMapper"/>-->
        <!--<mapper resource="mapper/BookMapper.xml"/>-->
    </mappers>
</configuration>
```

演示程序

```
/*
 * Copyright (c) 2006, 2023, webrx.cn All rights reserved.
 *
 */
package cn;

import cn.webrx.mapper.BookMapper;
import cn.webrx.mapper.DbMapper;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.File;
import java.io.InputStream;


/**
 * <p></p>
 * <p>Powered by webrx On 2023-04-18 15:11:15</p>
 *
 * @author webrx [webrx@126.com]
 * @version 1.0
 * @since 17
 */

public class Demo {
    public static void main(String[] args) {
        //logback log4j2
        try (var is = Resources.getResourceAsStream("mybatis-config.xml")) {
            var sf = new SqlSessionFactoryBuilder().build(is);

           
            //-----------------------------批量扫描src/main/resources/mapper/*.xml文件
			Configuration cfg = sf.getConfiguration();
            String xml = "mapper/";
            String p = Thread.currentThread().getContextClassLoader().getResource(xml).getPath();
            File f = new File(p);
            for (String s : f.list()) {
                var t = xml + s;
                InputStream is2 = Thread.currentThread().getContextClassLoader().getResourceAsStream(t);
                new XMLMapperBuilder(is2, cfg, t, cfg.getSqlFragments()).parse();
            }
            //-----------------------------

            var ss = sf.openSession();
            BookMapper bm = ss.getMapper(BookMapper.class);

            System.out.println(bm.queryBook());

            DbMapper dm = ss.getMapper(DbMapper.class);
            System.out.println(dm.version());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### 3.6 spring demo整合

#### 3.6.1 基本的spring 项目

`Ch06-SpringDemo`初始

(1) pom.xml 添加spring项目依赖

```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>6.0.8</version>
</dependency>
```

(2) `src/main/java/cn/zxy/config/AppConfig.java`

```java
/*
 * Copyright (c) 2017, 2023, zxy.cn All rights reserved.
 *
 */
package cn.zxy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Description:</p>
 * <p>Class:</p>
 * <p>Powered by zxy On 2023/4/19 9:14 </p>
 *
 * @author zxy [zxy06291@163.com]
 * @version 1.0
 * @since 17
 */
@Configuration
@ComponentScan("cn.zxy")
public class AppConfig {
}
```

(3) `src/main/java/cn/zxy/servcie/MyService.java`

```java
/*
 * Copyright (c) 2017, 2023, zxy.cn All rights reserved.
 *
 */
package cn.zxy.service;

import org.springframework.stereotype.Service;

/**
 * <p>Description:</p>
 * <p>Class:</p>
 * <p>Powered by zxy On 2023/4/19 9:14 </p>
 *
 * @author zxy [zxy06291@163.com]
 * @version 1.0
 * @since 17
 */
@Service("ms")
public class MyService {
    public int pf(int i) {
        return i * i;
    }
}
```

(4) 主程序`/src/main/java/cn/zxy/App.java`

```java
/*
 * Copyright (c) 2017, 2023, zxy.cn All rights reserved.
 *
 */
package cn.zxy;

import cn.zxy.config.AppConfig;
import cn.zxy.service.MyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.SpringVersion;

/**
 * <p>Description:</p>
 * <p>Class:</p>
 * <p>Powered by zxy On 2023/4/19 9:14 </p>
 *
 * @author zxy [zxy06291@163.com]
 * @version 1.0
 * @since 17
 */
public class App {
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(SpringVersion.getVersion());
        MyService ms = ctx.getBean("ms", MyService.class);
        System.out.println(ms.pf(3));

        //System.out.println(ctx.getBeanDefinitionCount());
        //System.out.println(Arrays.toString(ctx.getBeanDefinitionNames()));
    }
}
```

![image-20230419102343274](D:\新建文件夹\java\ssms-mybatis\mybatis\README\image-20230419102343274.png)

#### 3.6.2 spring整合mybatis

`Ch06-SpringDemo`加强

> 第一步 建立spring项目，pom.xml文件内容如下

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>cn.zxy</groupId>
        <artifactId>mybatis</artifactId>
        <version>1.0-SNAPSHOT</version>
    </parent>

    <artifactId>Ch06-SpringDemo</artifactId>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>6.0.8</version>
        </dependency>

        <!--spring 整合mybatis spring jdbc-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>6.0.8</version>
        </dependency>

        <!-- com.alibaba/druid -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.2.17</version>
        </dependency>

        <!-- mybatis-spring -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>3.0.1</version>
        </dependency>

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.32</version>
        </dependency>

        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.13</version>
        </dependency>

        <!-- org.apache.logging.log4j/log4j-core -->
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-core</artifactId>
            <version>2.20.0</version>
        </dependency>

        <!-- org.projectlombok/lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.24</version>
            <scope>provided</scope>
        </dependency>

    </dependencies>
</project>
```

`pom.xml(mybatis)`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>cn.zxy</groupId>
    <artifactId>mybatis</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>pom</packaging>
    <modules>
        <module>Ch01-Hello</module>
        <module>Ch02-Demo</module>
        <module>Ch03-Book</module>
        <module>Ch04-Log</module>
        <module>Ch06-SpringDemo</module>
    </modules>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <!-- mysql-connector-java -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.32</version>
        </dependency>

        <!-- org.mybatis/mybatis -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.13</version>
        </dependency>


        <!-- org.projectlombok/lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.24</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>

    <build>
        <resources>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.xml</include>
                </includes>
            </resource>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.xml</include>
                    <include>**/*.properties</include>
                </includes>
            </resource>
        </resources>
    </build>
</project>
```

`src/main/resources/log4j2.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="WARN">
    <Appenders>
        <Console name="LogToConsole" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
        </Console>
        <File name="LogToFile" fileName="log/test.log">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
        </File>
    </Appenders>
    <Loggers>
        <Root level="debug">
            <AppenderRef ref="LogToConsole"/>
        </Root>
    </Loggers>
</Configuration>
```

> 　第二步：编写mybatis mapper 接口 mapper xml接口映射文件

｀`src/main/java/cn/zxy/mapper/DbMapper.java`｀

```java
/*
 * Copyright (c) 2017, 2023, zxy.cn All rights reserved.
 *
 */
package cn.zxy.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>Description:</p>
 *
 * <p>Powered by zxy On 2023/4/19 9:36 </p>
 *
 * @author zxy [zxy06291@163.com]
 * @version 1.0
 * @since 17
 */
@Repository
public interface DbMapper {
    public List<String> dbs();

    public List<String> tbs(String db);

    public List<String> tbs();
}
```

`src/main/resources/mapper/DbMapper.xml`

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="cn.zxy.mapper.DbMapper">
    <select id="dbs" resultType="string">show databases</select>
    <select id="tbs" resultType="string" parameterType="string">
        show tables <if test="db!=null">from ${db}</if>
    </select>
</mapper>
```

`src/main/java/cn/zxy/config/AppConfig.java`

```java
/*
 * Copyright (c) 2017, 2023, zxy.cn All rights reserved.
 *
 */
package cn.zxy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Description:</p>
 * <p>Class:</p>
 * <p>Powered by zxy On 2023/4/19 9:14 </p>
 *
 * @author zxy [zxy06291@163.com]
 * @version 1.0
 * @since 17
 */
@Configuration
@ComponentScan("cn.zxy")
public class AppConfig {
}
```

`src/main/resources/db.properties`

```java
db.driver=com.mysql.cj.jdbc.Driver
db.url=jdbc:mysql:/db
db.username=root
db.password=root
```

> 第三步：编写主程序和配置文件

早期spring框架常用的配置文件：`spring-beans.xml` `beans.xml` `appliationContext.xml`

最新的springboot的配置主application.properties 或 application.yml application.yaml

`src/main/java/cn/webrx/App.java `主入口程序，也是spring的配置程序

```java
/*
 * Copyright (c) 2017, 2023, zxy.cn All rights reserved.
 *
 */
package cn.zxy;

import cn.zxy.config.AppConfig;
import cn.zxy.mapper.DbMapper;
import cn.zxy.service.MyService;
import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.SpringVersion;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

/**
 * <p>Description:</p>
 * <p>Class:</p>
 * <p>Powered by zxy On 2023/4/19 9:14 </p>
 *
 * @author zxy [zxy06291@163.com]
 * @version 1.0
 * @since 17
 */
@Configuration
@ComponentScan("cn.zxy")
@MapperScan("cn.webrx.mapper")
@PropertySource("classpath:db.properties")
public class App {
    @Value("${db.driver}")
    private String driver;
    @Value("${db.url}")
    private String url;
    @Value("${db.username:root}")
    private String username;
    @Value("${db.password:root}")
    private String password;


    @Bean(name = "ds", initMethod = "init", destroyMethod = "close")
    @Primary
    public DruidDataSource ds() {
        DruidDataSource ds = new DruidDataSource();
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setUrl(url);
        ds.setDriverClassName(driver);
        return ds;
    }

    @Bean(name = "sf")
    @Primary
    public SqlSessionFactoryBean sf(DruidDataSource ds) throws IOException {
        SqlSessionFactoryBean sf = new SqlSessionFactoryBean();
        sf.setDataSource(ds);
        sf.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*Mapper*.xml"));
        return sf;
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        System.out.println(SpringVersion.getVersion());

        DbMapper dm = ctx.getBean("dbMapper", DbMapper.class);
        System.out.println(dm.dbs());
        System.out.println();

        System.out.println(dm.tbs());
        System.out.println(dm.tbs("mysql"));

        //System.out.println(ctx.getBeanDefinitionCount());
        //System.out.println(Arrays.toString(ctx.getBeanDefinitionNames()));
    }
}
```

![image-20230419111153150](D:\新建文件夹\java\ssms-mybatis\mybatis\README\image-20230419111153150.png)

![image-20230419111211528](D:\新建文件夹\java\ssms-mybatis\mybatis\README\image-20230419111211528.png)

###  3.7 springboot 使用mybatis

`sp`

#### 3.7.1 建立项目

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.7.10</version>
        <relativePath/>
    </parent>

    <groupId>org.example</groupId>
    <artifactId>Sp</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>

        <!-- spring-boot-starter-log4j2 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-log4j2</artifactId>
            <version>3.0.5</version>
        </dependency>

        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>3.0.1</version>
            <exclusions>
                <exclusion>
                    <groupId>org.mybatis</groupId>
                    <artifactId>mybatis</artifactId>
                </exclusion>
                <exclusion>
                    <groupId>com.zaxxer</groupId>
                    <artifactId>HikariCP</artifactId>
                </exclusion>
            </exclusions>
        </dependency>

        <!-- com.alibaba/druid -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.2.17</version>
        </dependency>

        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.13</version>
        </dependency>

        <!-- HikariCP -->
        <dependency>
            <groupId>com.zaxxer</groupId>
            <artifactId>HikariCP</artifactId>
            <version>5.0.1</version>
        </dependency>

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.32</version>
        </dependency>

    </dependencies>

</project>
```

#### 3.7.2 application.yml

```yml
spring:
  datasource:
    type: com.alibaba.druid.pool.DruidDataSource
    url: jdbc:mysql:/db
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: root
    password: root

mybatis:
  mapper-locations: classpath:mapper/*.xml
```

#### 3.7.3 DbMapper.java

```java
/*
 * Copyright (c) 2017, 2023, zxy.cn All rights reserved.
 *
 */
package cn.zxy.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>Description:</p>
 *
 * <p>Powered by zxy On 2023/4/19 11:52 </p>
 *
 * @author zxy [zxy06291@163.com]
 * @version 1.0
 * @since 17
 */
@Mapper //此处不注解，也可以在入口类上 @MapperScan("cn.webrx.mapper")扫描
public interface DbMapper {
    public List<String> dbs();
}
```

#### 3.7.4 DbMapper.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="cn.zxy.mapper.DbMapper">
    <select id="dbs">
        show databases
    </select>
</mapper>
```

#### 3.7.5 App.java入口程序

```java
/*
 * Copyright (c) 2017, 2023, zxy.cn All rights reserved.
 *
 */
package cn.zxy;

import cn.zxy.mapper.DbMapper;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

/**
 * <p>Description:</p>
 * <p>Class:</p>
 * <p>Powered by zxy On 2023/4/19 11:44 </p>
 *
 * @author zxy [zxy06291@163.com]
 * @version 1.0
 * @since 17
 */
@SpringBootApplication
public class App implements ApplicationRunner {

    @Resource
    DbMapper dm;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(SpringBootVersion.getVersion());
        System.out.println(dm.dbs());
    }
}
```

![image-20230419212702621](D:\新建文件夹\java\ssms-mybatis\mybatis\README\image-20230419212702621.png)

其实这个东西不是必须的，引用这个的作用仅仅是为了版本对其，所以即使你parent了他之后，如果要使用什么功能还是需要dependencies去引包。spring boot中除了boot本身的jar之外，还有很多spring的包版本，如果想要不引用parent，则可以引入以下

```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-dependencies</artifactId>
            <version>2.7.10</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
<!-- pom.xml -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-dependencies</artifactId>
    <version>2.7.10</version>
    <type>pom</type>
    <scope>import</scope>
</dependency>
```

![image-20230419155051768](D:\新建文件夹\java\ssms-mybatis\mybatis\README\image-20230419155051768.png)

#### 3.7.6 springboot web案例

`Ch07-SpringBootDemo`

（1）`pom.xml`建立模块项目

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>Ch07-SpringBootDemo</artifactId>
    <version>1.0-SNAPSHOT</version>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.7.9</version>
    </parent>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-dependencies</artifactId>
            <version>2.7.10</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <version>2.7.10</version>
        </dependency>

        <!-- spring-boot-autoconfigure -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-autoconfigure</artifactId>
            <version>2.7.10</version>
        </dependency>


        <!-- mybatis-spring-boot-starter -->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>3.0.1</version>
            <exclusions>
                <exclusion>
                    <groupId>org.mybatis</groupId>
                    <artifactId>mybatis</artifactId>
                </exclusion>
                <exclusion>
                    <groupId>com.zaxxer</groupId>
                    <artifactId>HikariCP</artifactId>
                </exclusion>
            </exclusions>
        </dependency>

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.32</version>
        </dependency>

        <!-- org.mybatis/mybatis -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.13</version>
        </dependency>

        <!-- druid-spring-boot-starter -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
            <version>1.2.17</version>
        </dependency>
        
    </dependencies>
</project>
```

（2）`src/main/resources/application.yml`建立配置文件

```yml
spring:
  datasource:
    type: com.alibaba.druid.pool.DruidDataSource
    url: jdbc:mysql:/db
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: root
    password: root

mybatis:
  mapper-locations: classpath:mapper/*.xml

server:
  port: 8080
```

（3）`src/main/java/cn/zxy/mapper/DbMapper.java`编写Mapper接口映射文件

```java
/*
 * Copyright (c) 2017, 2023, zxy.cn All rights reserved.
 *
 */
package cn.zxy.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * <p>Description:</p>
 *
 * <p>Powered by zxy On 2023/4/19 11:52 </p>
 *
 * @author zxy [zxy06291@163.com]
 * @version 1.0
 * @since 17
 */
@Component
public interface DbMapper {
    @Select("select @@version")
    public String ver();

    public List<String> tbs();
    public List<String> tbs(String db);
    public List<String> dbs();
}
```

`src/main/resources/mapper/DbMapper.xml`

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="cn.zxy.mapper.DbMapper">
    <select id="dbs" resultType="string">
        show databases
    </select>

    <select id="tbs" resultType="string">
        show tables
        <if test="d!=null">from ${d}</if>
    </select>
</mapper>
```

（4）`src/main/java/cn/zxy/controller/IndexController.java`编写控制器

```java
/*
 * Copyright (c) 2017, 2023, zxy.cn All rights reserved.
 *
 */
package cn.zxy.controller;

import cn.zxy.mapper.DbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * <p>Description:</p>
 * <p>Class:</p>
 * <p>Powered by zxy On 2023/4/19 11:45 </p>
 *
 * @author zxy [zxy06291@163.com]
 * @version 1.0
 * @since 17
 */
@RestController
public class IndexController {
    @Autowired
    DbMapper dm;

    //http://localhost:8080/
    @GetMapping
    public String home(){
        return dm.ver();
    }

    //http://localhost:8080/dbs
    @GetMapping("/dbs")
    public List<String> dbs(){
        return dm.dbs();
    }

    //http://localhost:8080/tbs?name=mysql
    //http://localhost:8080/tbs
    @GetMapping("/tbs")
    public List<String> tbs(@RequestParam(value = "name", defaultValue = "db") String name){
        return dm.tbs(name);
    }

    //http://localhost:8080/tbs?name=mysql/version
    @GetMapping("/version")
    public String index(){
        return SpringBootVersion.getVersion();
    }
}
```

（5）`src/main/java/cn/zxy/App.java`编写程序入口

```java
/*
 * Copyright (c) 2017, 2023, zxy.cn All rights reserved.
 *
 */
package cn.zxy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>Description:</p>
 * <p>Class:</p>
 * <p>Powered by zxy On 2023/4/19 11:44 </p>
 *
 * @author zxy [zxy06291@163.com]
 * @version 1.0
 * @since 17
 */
@SpringBootApplication @MapperScan("cn.zxy.mapper")
public class App {
    public static void main(String[] args) {

        SpringApplication.run(App.class, args);
    }
}
```

（6）查看测试

![image-20230419212210075](D:\新建文件夹\java\ssms-mybatis\mybatis\README\image-20230419212210075.png)

![image-20230419212602690](D:\新建文件夹\java\ssms-mybatis\mybatis\README\image-20230419212602690.png)

##  第四章 mybatis常用CRUD操作

### 4.1 基本类型CRUD

#### 4.1.1 insert 插入

```
@Insert
```

插入数据在接口中，可以使用使用注解@Insert，如果访问是一个参数，不指定，多个参数需要使用@Param注解，也可以直接使用Map<String,Object>，也可以使用vo对象

```
@Insert("insert into t_book(name,price,author) value(#{name},#{price},#{author})")
@Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
public int insert(Map<String,Object> map);

@Insert("insert into t_book(name,price,author) value(#{name},#{price},#{author})")
public int save(@Param("name") String name,@Param("price") double price,@Param("author") String author);
<!-- 此处代码在XxxMapper.xml文件，使用<insert>标签，实现插入 -->
<insert id="add" parameterType="book" useGeneratedKeys="true" keyColumn="id" keyProperty="id">
        insert into t_book values(null,#{name},#{price},#{author},#{pdate})
</insert>
@Insert("insert into student(name) value(#{name}))
int save(String name)


@Insert("insert into student(sname,score) value(#{name},#{score}))
int save(@Param("name") String name,@Param("score")int score)

@Insert("insert into student(sname,score) value(#{name},#{score}))
int save(Map<String,Object> map)

map.put("name","");
map.put("score",90);

save(map);


@Insert("insert into student(sname,score) value(#{nn},#{ss}))
int save(StudentVo)

@Date
class StudentVo{
   private String nn;
   private int ss;
}

StudentVo sv = new StudentVo()
sv.set
sv.set

save(sv);
```

#### 4.1.2 delete 删除

删除数据

删除表 drop

建立表 create

```
@Delete("drop table if exists ${tn}")
public void delTable(String tn);

@Update("${sql}")
public void createTable(String sql);
```

删除记录 delelet

```
public int deleteById();
public int deleteById(int id);
public int deleteByName(String name);
<delete id="deleteByName">
    delete
    from t_book
    where name like #{name}
</delete>

<delete id="deleteById">
    delete from t_book
    <if test="id!=null">where id = #{id}</if>
</delete>
```

删除如果有多个参数条件，可以使用Map对象，也可以使用vo对象，注意属性名，key名和写的sql语句

```
@Delete("delete from ${tn} where id = #{id} and name like #{nn}")
int delBook(Map map);

int delBook(@Param("tn") String ....));


map.put("tn","t_book");
map.put("id",7);
map.put("nn","%java%")
delBook(map);
```

#### 4.1.3 update 修改更新

```
@Update("update t_student set name=#{name} where id = #{id}")
public int update(Student st);
<update id="update">
   update t_student set name=#{name},addr=#{addr} where id = #{id}
</update>
```

#### 4.1.4 select 查询

```
@Select("select name from t_book")
public List<String> getBookNames();
<select id="getStu" parameterType="int" resultType="cn.webrx.entity.Student">
    select stid as id,stname as name,isstu as stu,sphoto as photo,smoney money from t_st where stid = #{id}
</select>



<!-- 结果映射，什么用字段名和属性名不一样可以， -->
<resultMap id="" type=""></resultMap>

<!-- sql段 -->
<sql id="">

</sql>
```

### 4.2 插入数据获取自增主键ID

注解方式

XxxMapper.java

```
@Insert("insert into t_book(name,price,author) value(#{name},#{price},#{author})")
@Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
public int insert(Map<String,Object> map);
Map<String,Object> map = new HashMap<>();
map.put("name","《vue入门》");
map.put("author","李强");
map.put("price",66);

System.out.println(map);
int n = bm.insert(map);
System.out.println(n);
System.out.println(map);//查看发现map多了一个 id=84
```

配置映射文件XxxMapper.xml

```
<insert id="add" parameterType="book" useGeneratedKeys="true" keyColumn="id" keyProperty="id">
    insert into t_book values(null,#{name},#{price},#{author},#{pdate})
</insert>
Book b = new Book();
b.setName("《myatis ORM》");
b.setPrice(55D);
b.setAuthor("李四");
b.setPdate(LocalDate.of(2023, 5, 15));
//System.out.println(bm.add(b));
//System.out.println(b);插入成功前id是0 插入成功后再看Book id=82最新的id
```

### 4.3 date、datetime、timestamp

数据库date 对应java 1.8 中的java.time.LocalDate

数据库datetime 对应 java 1.8中的java.time.LocalDateTime

数据库timestamp 对应 java 1.8中的java.time.LocalDateTime

### 4.4 boolean、double

![image-20230419173934874](https://gitee.com/webrx/myatis2023/raw/master/assets/image-20230419173934874.png)

### 4.4 blob、longblob、longtext

sql

```
create table t_st(
stid int UNSIGNED auto_increment primary key,
stname varchar(30),
isstu boolean,
sphoto longblob,
smoney decimal(12,2)
)

show create table t_st;

CREATE TABLE `t_st` (
  `stid` int unsigned NOT NULL AUTO_INCREMENT,
  `stname` varchar(30) DEFAULT NULL,
  `isstu` tinyint(1) DEFAULT NULL,
  `sphoto` longblob,
  `smoney` decimal(12,2) DEFAULT NULL,
  PRIMARY KEY (`stid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3
```

pojo

```
@Data
public class Student {
    private int id;
    private String name;
    private boolean stu;
    private double money;
    private byte[] photo;
}
@Test
void m6() {
    Student st = new Student();
    st.setName("cat");
    st.setStu(true);
    st.setMoney(50D);
    try (FileInputStream fis = new FileInputStream("c:/12.png")) {
        //st.setPhoto(fis.readAllBytes());
        byte[] buf = new byte[10L];
        List<Byte> all = new ArrayList<>();
        int len = -1;
        while ((len = fis.read(buf)) > 0) {
            for (int i = 0; i < len; i++) {
                all.add(buf[i]);
            }
        }
        Byte[] temp = new Byte[all.size()];
        all.toArray(temp);
        st.setPhoto(temp);


    } catch (Exception e) {
    }
    int rows = sum.add(st);
    System.out.println(rows);

}
```

![image-20230420112108871](https://gitee.com/webrx/myatis2023/raw/master/assets/image-20230420112108871.png)

```
<select id="getStu" parameterType="int" resultType="cn.webrx.entity.Student">
    select stid as id,stname as name,isstu as stu,sphoto as photo,smoney money from t_st where stid = #{id}
</select>
@Test
void m7(){


Student ss = sum.getStu(3);
try{
    FileOutputStream fos = new FileOutputStream("c:/my.png");
    for(byte b : ss.getPhoto()){
        fos.write(b);
    }
}catch(Exception e){
    e.printStackTrace();
}
System.out.println();
}
```

### 4.5 类型别名（typeAliases）

```
<typeAliases>
        <!-- 相当于注解@Alias("us") -->
        <typeAlias type="cn.itsors.domain.Users" alias="us"/> 
        <package name="cn.itsors.domain"/> 
</typeAliases>
```

![image-20230419170348379](https://gitee.com/webrx/myatis2023/raw/master/assets/image-20230419170348379.png)

通过 SqlSessionFactory来设置批量，类型的别名，也可以在类上使用`@Alias("bv")`注解别是

```
 @Bean("sf")
    public SqlSessionFactoryBean sqlSessionFactoryBean(DruidDataSource ds) throws IOException {
        SqlSessionFactoryBean sf = new SqlSessionFactoryBean();
        sf.setDataSource(ds);

        //设置别名 cn.webrx.entity.Book 别名就 book cn.webrx.vo.BookVo 别名就是 bookVo bookvo
        sf.setTypeAliasesPackage("cn.webrx.entity,cn.webrx.vo");

        sf.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*Mapper*.xml"));
        return sf;
    }
/*
 * Copyright (c) 2006, 2023, webrx.cn All rights reserved.
 *
 */
package cn.webrx.vo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * <p></p>
 * <p>Powered by webrx On 2023-04-19 15:02:41</p>
 *
 * @author webrx [webrx@126.com]
 * @version 1.0
 * @since 17
 */
@Data @Alias("bv")
public class BookVo {
    private int id;
    private String name;
    private double price;
}
```

| 别名                      | 映射的类型   |
| ------------------------- | ------------ |
| _byte                     | byte         |
| _char (since 3.5.10)      | char         |
| _character (since 3.5.10) | char         |
| _long                     | long         |
| _short                    | short        |
| _int                      | int          |
| _integer                  | int          |
| _double                   | double       |
| _float                    | float        |
| _boolean                  | boolean      |
| string                    | String       |
| byte                      | Byte         |
| char (since 3.5.10)       | Character    |
| character (since 3.5.10)  | Character    |
| long                      | Long         |
| short                     | Short        |
| int                       | Integer      |
| integer                   | Integer      |
| double                    | Double       |
| float                     | Float        |
| boolean                   | Boolean      |
| date                      | Date         |
| decimal                   | BigDecimal   |
| bigdecimal                | BigDecimal   |
| biginteger                | BigInteger   |
| object                    | Object       |
| date[]                    | Date[]       |
| decimal[]                 | BigDecimal[] |
| bigdecimal[]              | BigDecimal[] |
| biginteger[]              | BigInteger[] |
| object[]                  | Object[]     |
| map                       | Map          |
| hashmap                   | HashMap      |
| list                      | List         |
| arraylist                 | ArrayList    |
| collection                | Collection   |
| iterator                  | Iterator     |

在XxxMapper.xml文件使用别名

```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="cn.webrx.mapper.BookMapper">
    <select id="show" resultType="bv">
        select id,name,price from t_book order by id desc
    </select>

    <insert id="add" parameterType="book" useGeneratedKeys="true" keyColumn="id" keyProperty="id">
        insert into  values(null,#{name},#{price},#{author},#{pdate})
    </insert>
</mapper>
map.put("tname","t_book")
```

### 4.6 `#{name}和${name}区别`

```
#{id} 是对应jdbc PreparedStatement 语句的点位符 ？ 会自动的添加单引号和不加单引
${table_name}是对应值的接引用字符串值
@Param() 注解经常使用在接口访问多个数来确定那个
@Select("select ${ff} from ${tn} ${ww}")
public List<Map<String,Object>> list(@Param("tn") String tn,@Param("ff") String field,@Param("ww") String where);
```

![image-20230419173230894](https://gitee.com/webrx/myatis2023/raw/master/assets/image-20230419173230894.png)

## 第五章 mybatis 数据分页

### 5.1 分页

```
    public int count();
    public List<Book> page(Map<String,Object> m);


    public List<Book> pages(Map<String,Object> m, RowBounds rows);
<select id="count" resultType="int">
    select count(*) from t_book
</select>

<select id="page" resultType="book">
    select * from t_book limit #{start},#{size}
</select>

<!-- 不推荐 -->
<select id="pages" resultType="book">
    select * from t_book
</select>
@Test
void m8() {
    int recordcount = bm.count();
    System.out.println(recordcount);
    int pagesize = 5;
    System.out.println(pagesize);
    int pagecount = recordcount % pagesize == 0 ? recordcount / pagesize : recordcount / pagesize + 1;
    System.out.println(pagecount);

    int currpage = 2;
    if (currpage < 1) currpage = 1;
    if (currpage > pagecount) currpage = pagecount;


    Map<String, Object> map = new HashMap<>();
    map.put("start", currpage * pagesize - pagesize);
    map.put("size", pagesize);
    List<Book> list = bm.page(map);
    System.out.println(list);

    System.out.println("==============================");

    //是mybatis内置分页功能，不推荐使用
    RowBounds rows = new RowBounds(currpage * pagesize - pagesize, pagesize);
    System.out.println(bm.pages(null,rows));
}
```

### 5.2 分页插件

插件是mybatis的拦截器.

mybatis.io 官方网站

pom.xml文件添加依赖

```
<!-- com.github.pagehelper/pagehelper -->
<dependency>
    <groupId>com.github.pagehelper</groupId>
    <artifactId>pagehelper</artifactId>
    <version>5.3.2</version>
</dependency>
@Select("select * from t_book")
public List<Book> query();
```

注册分页插件

```
@Bean("sf")
public SqlSessionFactoryBean sqlSessionFactoryBean(DruidDataSource ds) throws IOException {
    SqlSessionFactoryBean sf = new SqlSessionFactoryBean();
    sf.setDataSource(ds);

    //设置别名 cn.webrx.entity.Book 别名就 book cn.webrx.vo.BookVo 别名就是 bookVo bookvo
    sf.setTypeAliasesPackage("cn.webrx.entity,cn.webrx.vo");

    //注册PageHelper插件
    sf.setPlugins(new PageInterceptor());

    sf.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*Mapper*.xml"));
    return sf;
}
```

demo

```
@Test
void m9(){
    //使用分页插件
    PageHelper.startPage(2,5);
    //List<Book> data = bm.query();
    PageInfo<Book> pp = PageInfo.of(bm.query());
    //System.out.println(pp.getList());
    System.out.println(pp.getPageNum());//当前页 2
    System.out.println(pp.getPages());//共有多少页 7
    System.out.println(pp.getPageSize());//每页多少条 3
    System.out.println(pp.getTotal());//总记录数 总条数 19
    List<Book> list = pp.getList();//获取当前页的数据
    for(Book b : list){
    	System.out.println(b);
    }
}
```

![image-20230420161804049](https://gitee.com/webrx/myatis2023/raw/master/assets/image-20230420161804049.png)

```
@Test
void m9(){
    //使用分页插件
    //PageHelper.startPage(2,5);
    //PageHelper.startPage(2,5,"id desc,name asc");
    int currpage = 30;
    int pagesize = 20;

    //PageHelper.startPage(currpage,pagesize,"name asc");
    //PageHelper.startPage(currpage,pagesize,true,true,true);
    PageHelper.startPage(currpage,pagesize,true,true,false);
    //List<Book> data = bm.query();
    PageInfo<Book> pp = PageInfo.of(bm.query());
    //System.out.println(pp.getList());
    System.out.println(pp.getPageNum());//当前页 2
    System.out.println(pp.getPages());//共有多少页 7
    System.out.println(pp.getPageSize());//每页多少条 3
    System.out.println(pp.getTotal());//总记录数 总条数 19
    List<Book> list = pp.getList();//获取当前页的数据
    for(Book b : list){
        System.out.println(b);
    }
}
```

### 5.3 Mybatis拦截器

MyBatis允许使用者在映射语句执行过程中的某一些指定的节点进行拦截调用，通过织入拦截器，在不同节点修改一些执行过程中的关键属性，从而影响SQL的生成、执行和返回结果，如：来影响Mapper.xml到SQL语句的生成、执行SQL前对预编译的SQL执行参数的修改、SQL执行后返回结果到Mapper接口方法返参POJO对象的类型转换和封装等。

- Configuration：初始化基础配置，比如MyBatis的别名等，一些重要的类型对象，如插件，映射器，
- ObjectFactory和typeHandler对象，MyBatis所有的配置信息都维持在Configuration对象之中。
- SqlSessionFactory：SqlSession工厂。
- SqlSession：作为MyBatis工作的主要顶层API，表示和数据库交互的会话，完成必要的数据库增删改查功能。
- Executor：MyBatis的内部执行器，它负责调用StatementHandler操作数据库，并把结果集通过
- ResultSetHandler进行自动映射，另外，它还处理二级缓存的操作。
- StatementHandler：MyBatis直接在数据库执行SQL脚本的对象。另外它也实现了MyBatis的一级缓存。
- ParameterHandler：负责将用户传递的参数转换成JDBC Statement所需要的参数。是MyBatis实现SQL入参设置的对象。
- ResultSetHandler：负责将JDBC返回的ResultSet结果集对象转换成List类型的集合。是MyBatis把
- ResultSet集合映射成POJO的接口对象。
- TypeHandler：负责Java数据类型和JDBC数据类型之间的映射和转换。
- MappedStatement：MappedStatement维护了一条<select|update|delete|insert>节点的封装。
- SqlSource ：负责根据用户传递的parameterObject，动态地生成SQL语句，将信息封装到BoundSql对象中，并返回。
- BoundSql：表示动态生成的SQL语句以及相应的参数信息

![image-20230420124940416](https://gitee.com/webrx/myatis2023/raw/master/assets/image-20230420124940416.png)

**自定义一个mybatis的拦截器步骤**

1. 定义一个实现org.apache.ibatis.plugin.Interceptor接口的拦截器类，并实现其中的方法。
2. 添加@Intercepts注解，写上需要拦截的对象和方法，以及方法参数。
3. 在mybatis的全局配置xml中配置插件plugin；对于去xml的Spring工程，显示的注册这个拦截器Bean即可

```
@Intercepts	// 描述：标志该类是一个拦截器
@Signature 	// 描述：指明该拦截器需要拦截哪一个接口的哪一个方法

type; // 四种类型接口中的某一个接口，如Executor.class；
method; // 对应接口中的某一个方法名，比如Executor的query方法；
args; // 对应接口中的某一个方法的参数，比如Executor中query方法因为重载原因，有多个，args就是指明参数类型，从而确定是具体哪一个方法；

MyBatis拦截器默认会按顺序拦截以下的四个接口中的所有方法：
org.apache.ibatis.executor.Executor  //拦截执行器方法
org.apache.ibatis.executor.statement.StatementHandler  //拦截SQL语法构建处理
org.apache.ibatis.executor.parameter.ParameterHandler  //拦截参数处理
org.apache.ibatis.executor.resultset.ResultSetHandler  //拦截结果集处理

实际上，具体是拦截这四个接口对应的实现类
org.apache.ibatis.executor.CachingExecutor
org.apache.ibatis.executor.statement.RoutingStatementHandler
org.apache.ibatis.scripting.defaults.DefaultParameterHandler
org.apache.ibatis.executor.resultset.DefaultResultSetHandler
```

![image-20230420125240140](https://gitee.com/webrx/myatis2023/raw/master/assets/image-20230420125240140.png)

进行拦截的时候要执行的方法。该方法参数Invocation类中有三个字段：

```
private final Object target;
private final Method method;
private final Object[] args;
//可通过这三个字段分别获取下面的信息：
Object target = invocation.getTarget(); //被代理对象
Method method = invocation.getMethod(); //代理方法
Object[] args = invocation.getArgs(); //方法参数
```

方法实现的结尾处，一般要真正调用被代理类的方法，即"return invocation.proceed();"

MyBatis 允许你在已映射语句执行过程中的某一点进行拦截调用。默认情况下，MyBatis 允许使用插件来拦截的方法调用包括：

1. Executor (update, query, flushStatements, commit, rollback, getTransaction, close, isClosed)拦截执行器的方法
2. ParameterHandler (getParameterObject, setParameters) 拦截参数的处理
3. ResultSetHandler (handleResultSets, handleOutputParameters)拦截结果集的处理
4. StatementHandler (prepare, parameterize, batch, update, query)拦截Sql语法构建的处理

#### 5.3.1Executor.class

可以修改sql 语句案例

```
/*
 * Copyright (c) 2006, 2023, webrx.cn All rights reserved.
 *
 */
package cn.webrx.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;

import java.lang.reflect.Field;

/**
 * <p></p>
 * <p>Powered by webrx On 2023-04-20 17:30:19</p>
 *
 * @author webrx [webrx@126.com]
 * @version 1.0
 * @since 17
 */
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})
})
public class DemoInterceptor implements Interceptor {

    private String getBound(Invocation invocation) {
        Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement) args[0];
        Configuration configuration = ms.getConfiguration();
        Object parameter = args[1];
        Object target = invocation.getTarget();
        StatementHandler handler = configuration.newStatementHandler((Executor) target, ms, parameter, RowBounds.DEFAULT, null, null);
        return handler.getBoundSql().getSql();
    }

    /**
     * 回塞sql
     *
     * @param ms           MappedStatement
     * @param newSqlSource SqlSource
     * @return MappedStatement
     */
    private MappedStatement copyFromMappedStatement(MappedStatement ms, SqlSource newSqlSource) {
        MappedStatement.Builder builder = new MappedStatement.Builder(ms.getConfiguration(), ms.getId(), newSqlSource, ms.getSqlCommandType());
        builder.resource(ms.getResource());
        builder.fetchSize(ms.getFetchSize());
        builder.statementType(ms.getStatementType());
        builder.keyGenerator(ms.getKeyGenerator());
        if (ms.getKeyProperties() != null && ms.getKeyProperties().length > 0) {
            builder.keyProperty(ms.getKeyProperties()[0]);
        }
        builder.timeout(ms.getTimeout());
        builder.parameterMap(ms.getParameterMap());
        builder.resultMaps(ms.getResultMaps());
        builder.resultSetType(ms.getResultSetType());
        builder.cache(ms.getCache());
        builder.flushCacheRequired(ms.isFlushCacheRequired());
        builder.useCache(ms.isUseCache());
        return builder.build();
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        //System.out.println("Object intercept(Invocation invocation)...........................拦截器执行");
        //Method method = invocation.getMethod();
        //System.out.println(method.getName()); //update
        //Object target = invocation.getTarget();
        //System.out.println(target.getClass().getSimpleName());

        //Object[] args = invocation.getArgs();
        //System.out.println(Arrays.toString(args));
        //
        //MappedStatement ms = (MappedStatement) args[0];
        //cn.webrx.mapper.BookMapper.add
        //System.out.println(ms.getId());

        //StatementType statementType = ms.getStatementType();
        //System.out.println(statementType); //STATEMENT  PREPARED CALLABLE

        //SqlSource sqlSource = ms.getSqlSource();
        //BoundSql boundSql = sqlSource.getBoundSql(ms.getParameterMap());
        //System.out.println(boundSql.getSql());
        //System.out.println(getBound(invocation));


        Object[] args = invocation.getArgs();
        MappedStatement mappedStatement = (MappedStatement) args[0];
        BoundSql boundSql = mappedStatement.getBoundSql(args[1]);
        //  获取到原始sql
        String sql = boundSql.getSql();
        System.out.println(sql);


        //新sql语句
        Field field = boundSql.getClass().getDeclaredField("sql");
        field.setAccessible(true);
        // 改造的sql塞回去  newSql 为改造之后的sql
        field.set(boundSql, "insert into t_book values (123, ?, ?, ?, ?)");
        System.out.println(boundSql.getSql());


        //将旧的mappedStatement 换为 新的 copyFromMappedStatement(mappedStatement, new BoundSqlSqlSource(boundSql)) 返回新的将旧的mappedStatement
        args[0] = copyFromMappedStatement(mappedStatement, new BoundSqlSqlSource(boundSql));

        //ParameterMap param = ms.getParameterMap();
        //System.out.println("-------------");
        //System.out.println(param.getId());
        //System.out.println(param.getType());
        //System.out.println(param.getParameterMappings());

        //Book book = (Book)args[1];
        //Class<?> arg = args[1].getClass();

        //SqlCommandType sqlCommandType = ms.getSqlCommandType();
        //System.out.println(sqlCommandType);// SqlCommandType.INSERT SqlCommandType.DELETE SqlCommandType.UPDATE
        Object obj = invocation.proceed();
        return obj;
    }

    public static class BoundSqlSqlSource implements SqlSource {
        BoundSql boundSql;

        public BoundSqlSqlSource(BoundSql boundSql) {
            this.boundSql = boundSql;
        }

        public BoundSql getBoundSql(Object parameterObject) {
            return boundSql;
        }
    }
}
```

这些类中方法的细节可以通过查看每个方法的签名来发现，或者直接查看 MyBatis 发行包中的源代码。 如果你想做的不仅仅是监控方法的调用，那么你最好相当了解要重写的方法的行为。 因为在试图修改或重写已有方法的行为时，很可能会破坏 MyBatis 的核心模块。 这些都是更底层的类和方法，所以使用插件的时候要特别当心。

```
org.apache.ibatis.plugin.Interceptor接口
public interface Interceptor {
  Object intercept(Invocation invocation) throws Throwable;
  Object plugin(Object target);
  void setProperties(Properties properties);
}
```

拦截Executor的查询和更新方法

```
/*
 * Copyright (c) 2006, 2023, webrx.cn All rights reserved.
 *
 */
package cn.webrx.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.RowBounds;

import java.lang.reflect.Method;
import java.util.Properties;

/**
 * <p></p>
 * <p>Powered by webrx On 2023-04-21 08:33:46</p>
 *
 * @author webrx [webrx@126.com]
 * @version 1.0
 * @since 17
 */
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultSetHandler.class})
})
public class HelloInterceptor implements Interceptor {
    Properties properties = null;

    /**
     * 拦截方法逻辑
     * 这里主要是通过反射去获取要执行的SQL相关信息，然后进行操作
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object target = invocation.getTarget(); //被代理对象
        Method method = invocation.getMethod(); //代理方法
        Object[] args = invocation.getArgs(); //方法参数
        MappedStatement mappedStatement = (MappedStatement) args[0];
        Object parameterObject = args[1];
        // do something ...方法拦截前执行代码块
        Object result = invocation.proceed();
        // do something ...方法拦截后执行代码块
        return result;

    }

    /**
     * 生成MyBatis拦截器代理对象
     */
    @Override
    public Object plugin(Object target) {
        if (target instanceof Executor) {
            // 调用插件
            return Plugin.wrap(target, this);
        }
        return target;
    }

    /**
     * 设置插件属性（直接通过Spring的方式获取属性，所以这个方法一般也用不到）
     * 项目启动的时候数据就会被加载
     */
    @Override
    public void setProperties(Properties properties) {
        // 赋值成员变量，在其他方法使用
        this.properties = properties;
    }
}
/*
 * Copyright (c) 2006, 2023, webrx.cn All rights reserved.
 *
 */
package cn.webrx.interceptor;

import lombok.extern.slf4j.Slf4j;
 import org.apache.ibatis.binding.MapperMethod.ParamMap;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;

import org.apache.ibatis.plugin.*;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.TypeHandlerRegistry;

import java.lang.reflect.Method;
import java.util.Properties;

/**
 * <p></p>
 * <p>Powered by webrx On 2023-04-21 08:33:46</p>
 *
 * @author webrx [webrx@126.com]
 * @version 1.0
 * @since 17
 */

import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultSetHandler.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class})})
@Slf4j
public class MybatisClickHouseGetSqlInterceptor implements Interceptor {

    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        String format = simpleDateFormat.format(new Date());
        System.out.println(format);
    }

    @Override public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        //0.sql参数获取
        Object parameter = null;
        if (invocation.getArgs().length > 1) {
            parameter = invocation.getArgs()[1];
        }
        BoundSql boundSql = mappedStatement.getBoundSql(parameter);
        //1.方法没有参数或者第一个参数为false
        if (parameter == null || (parameter instanceof ParamMap && (((ParamMap) parameter).size() == 0 || ((ParamMap) parameter).get("param1") != Boolean.TRUE)) || (parameter instanceof Boolean && parameter != Boolean.TRUE) || (!(parameter instanceof Boolean) && !(parameter instanceof ParamMap))) {
            //集群提交任务
            return invocation.proceed();
        }
        Configuration configuration = mappedStatement.getConfiguration();
        //2. 返回sql语句
        Object[] params = getParams(configuration, boundSql);
        String rawsql = boundSql.getSql().replaceAll("[\\s]+", " ");
        String sql = PreparedStatementParser.parse(rawsql).buildSql(params);
        return Arrays.asList(sql);
    }

    @Override public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    @Override public void setProperties(Properties properties) {
    }
    private static Object[] getParams(Configuration configuration, BoundSql boundSql) {
        ArrayList<Object> list = new ArrayList<>();
        Object parameterObject = boundSql.getParameterObject();
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        if (!parameterMappings.isEmpty() && parameterObject != null) {
            TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
            if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
                list.add(parameterObject);
            } else {
                MetaObject metaObject = configuration.newMetaObject(parameterObject);
                for (ParameterMapping parameterMapping : parameterMappings) {
                    String propertyName = parameterMapping.getProperty();
                    if (metaObject.hasGetter(propertyName)) {
                        Object obj = metaObject.getValue(propertyName);
                        list.add(obj);
                    } else if (boundSql.hasAdditionalParameter(propertyName)) {
                        Object obj = boundSql.getAdditionalParameter(propertyName);
                        list.add(obj);
                    } else {
                        list.add("缺失");
                    }//打印出缺失，提醒该参数缺失并防止错位
                }
            }
        }
        return list.toArray();
    }
    /**
     * Parser for clickhouse JDBC SQL Strings
     * <p>
     * Tries to extract query parameters in a way that is usable for (batched)
     * prepared statements.
     */
    public final static class PreparedStatementParser {
        private static final Pattern VALUES = Pattern.compile("(?i)INSERT\\s+INTO\\s+.+VALUES\\s*\\(");
        private static final String PARAM_MARKER = "?";
        private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        private final SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        private final List<List<String>> parameters;
        private final List<String> parts;
        private boolean valuesMode;

        private PreparedStatementParser() {
            parameters = new ArrayList<List<String>>();
            parts = new ArrayList<String>();
            valuesMode = false;
            initTimeZone(TimeZone.getDefault());
        }

        public static PreparedStatementParser parse(String sql) {
            if (sql.isBlank()) {
                throw new IllegalArgumentException("SQL may not be blank");
            }
            PreparedStatementParser parser = new PreparedStatementParser();
            parser.parseSQL(sql);
            return parser;
        }

        private static String typeTransformParameterValue(String paramValue) {
            if (paramValue == null) {
                return null;
            }
            if (Boolean.TRUE.toString().equalsIgnoreCase(paramValue)) {
                return "1";
            }
            if (Boolean.FALSE.toString().equalsIgnoreCase(paramValue)) {
                return "0";
            }
            if ("NULL".equalsIgnoreCase(paramValue)) {
                return "\\N";
            }
            return paramValue;
        }

        private void initTimeZone(TimeZone timeZone) {
            dateTimeFormat.setTimeZone(timeZone);
            dateFormat.setTimeZone(timeZone);
        }


        private void reset() {
            parameters.clear();
            parts.clear();
            valuesMode = false;
        }

        private void parseSQL(String sql) {
            reset();
            List<String> currentParamList = new ArrayList<String>();
            boolean afterBackSlash = false;
            boolean inQuotes = false;
            boolean inBackQuotes = false;
            boolean inSingleLineComment = false;
            boolean inMultiLineComment = false;
            boolean whiteSpace = false;
            Matcher matcher = VALUES.matcher(sql);
            if (matcher.find()) {
                valuesMode = true;
            }
            int currentParensLevel = 0;
            int quotedStart = 0;
            int partStart = 0;
            for (int i = valuesMode ? matcher.end() - 1 : 0, idxStart = i, idxEnd = i; i < sql.length(); i++) {
                char c = sql.charAt(i);
                //注释
                if (inSingleLineComment) {
                    if (c == '\n') {
                        inSingleLineComment = false;
                    }
                } else if (inMultiLineComment) {
                    if (c == '*' && sql.length() > i + 1 && sql.charAt(i + 1) == '/') {
                        inMultiLineComment = false;
                        i++;
                    }
                    //反斜杠
                } else if (afterBackSlash) {
                    afterBackSlash = false;
                } else if (c == '\\') {
                    afterBackSlash = true;
                    //单引号
                } else if (c == '\'') {
                    inQuotes = !inQuotes;
                    if (inQuotes) {
                        quotedStart = i;
                    } else if (!afterBackSlash) {
                        idxStart = quotedStart;
                        idxEnd = i + 1;
                    }
                    //反引号
                } else if (c == '`') {
                    inBackQuotes = !inBackQuotes;
                    //不在单引号中
                } else if (!inQuotes && !inBackQuotes) {
                    if (c == '?') {
                        if (currentParensLevel > 0) {
                            idxStart = i;
                            idxEnd = i + 1;
                        }
                        if (!valuesMode) {
                            parts.add(sql.substring(partStart, i));
                            partStart = i + 1;
                            currentParamList.add(PARAM_MARKER);
                        }
                        //单行注释
                    } else if (c == '-' && sql.length() > i + 1 && sql.charAt(i + 1) == '-') {
                        inSingleLineComment = true;
                        i++;
                        //多行注释
                    } else if (c == '/' && sql.length() > i + 1 && sql.charAt(i + 1) == '*') {
                        inMultiLineComment = true;
                        i++;
                    } else if (c == ',') {
                        if (valuesMode && idxEnd > idxStart) {
                            currentParamList.add(typeTransformParameterValue(sql.substring(idxStart, idxEnd)));
                            parts.add(sql.substring(partStart, idxStart));
                            partStart = idxStart = idxEnd = i;
                        }
                        idxStart++;
                        idxEnd++;
                    } else if (c == '(') {
                        currentParensLevel++;
                        idxStart++;
                        idxEnd++;
                    } else if (c == ')') {
                        currentParensLevel--;
                        if (valuesMode && currentParensLevel == 0) {
                            if (idxEnd > idxStart) {
                                currentParamList.add(typeTransformParameterValue(sql.substring(idxStart, idxEnd)));
                                parts.add(sql.substring(partStart, idxStart));
                                partStart = idxStart = idxEnd = i;
                            }
                            if (!currentParamList.isEmpty()) {
                                parameters.add(currentParamList);
                                currentParamList = new ArrayList<String>(currentParamList.size());
                            }
                        }
                    } else if (Character.isWhitespace(c)) {
                        whiteSpace = true;
                    } else if (currentParensLevel > 0) {
                        if (whiteSpace) {
                            idxStart = i;
                            idxEnd = i + 1;
                        } else {
                            idxEnd++;
                        }
                        whiteSpace = false;
                    }
                }
            }
            if (!valuesMode && !currentParamList.isEmpty()) {
                parameters.add(currentParamList);
            }
            String lastPart = sql.substring(partStart);
            parts.add(lastPart);
        }
        private String buildSql(Object[] params) throws SQLException {
            if (parts.size() == 1) {
                return parts.get(0);
            }
            //checkBinded();检查参数是不是null
            StringBuilder sb = new StringBuilder(parts.get(0));
            for (int i = 1, p = 0; i < parts.size(); i++) {
                String pValue = getParameter(i - 1);
                if (PARAM_MARKER.equals(pValue)) {
                    appendBoundValue(sb, params[p++]);
                } else {
                    sb.append(pValue);
                }
                sb.append(parts.get(i));
            }
            String mySql = sb.toString();
            return mySql;
        }
        private String getParameter(int paramIndex) {
            for (int i = 0, count = paramIndex; i < parameters.size(); i++) {
                List<String> pList = parameters.get(i);
                count -= pList.size();
                if (count < 0) {
                    return pList.get(pList.size() + count);
                }
            }
            return null;
        }
        private void appendBoundValue(StringBuilder sb, Object params) {
            //需要根据参数类型来处理
            try {
                sb.append(getObject(params));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        private StringBuilder getBind(String bind, boolean quote) {
            StringBuilder sb = new StringBuilder();
            if (quote) {
                sb.append("'").append(bind).append("'");
            } else if (bind.equals("\\N")) {
                sb.append("null");
            } else {
                sb.append(bind);
            }
            return sb;
        }
        private StringBuilder getBind(String bind) {
            return getBind(bind, false);
        }
        public StringBuilder getNull(int sqlType) throws SQLException {
            return getBind("\\N");
        }
        public StringBuilder getBoolean(boolean x) throws SQLException {
            return getBind(x ? "1" : "0");
        }
        public StringBuilder getByte(byte x) throws SQLException {
            return getBind(Byte.toString(x));
        }
        public StringBuilder getShort(short x) throws SQLException {
            return getBind(Short.toString(x));
        }
        public StringBuilder getInt(int x) throws SQLException {
            return getBind(Integer.toString(x));
        }
        public StringBuilder getLong(long x) throws SQLException {
            return getBind(Long.toString(x));
        }
        public StringBuilder getFloat(float x) throws SQLException {
            return getBind(Float.toString(x));
        }
        public StringBuilder getDouble(double x) throws SQLException {
            return getBind(Double.toString(x));
        }
        public StringBuilder getBigDecimal(BigDecimal x) throws SQLException {
            return getBind(x.toPlainString());
        }
      
        public StringBuilder getDate(java.sql.Date x) throws SQLException {
            return getBind(dateFormat.format(x), true);
        }
        public StringBuilder getTime(Time x) throws SQLException {
            return getBind(dateTimeFormat.format(x), true);
        }
        public StringBuilder getTimestamp(Timestamp x) throws SQLException {
            return getBind(dateTimeFormat.format(x), true);
        }
        public StringBuilder getAsciiStream(InputStream x, int length) throws SQLException {
            throw new SQLFeatureNotSupportedException();
        }
        @Deprecated public StringBuilder getUnicodeStream(InputStream x, int length) throws SQLException {
            throw new SQLFeatureNotSupportedException();
        }
        public StringBuilder getBinaryStream(InputStream x, int length) throws SQLException {
            throw new SQLFeatureNotSupportedException();
        }
        public StringBuilder getObject(Object x, int targetSqlType) throws SQLException {
            return getObject(x);
        }
        
        public StringBuilder getClob(Clob x) throws SQLException {
            throw new SQLFeatureNotSupportedException();
        }
        public StringBuilder getBlob(Blob x) throws SQLException {
            throw new SQLFeatureNotSupportedException();
        }
        public StringBuilder getObject(Object x) throws SQLException {
            if (x == null) {
                return getNull(Types.OTHER);
            } else {
                if (x instanceof Byte) {
                    return getInt(((Byte) x).intValue());
                } else if (x instanceof String) {
                    return null;
                } else if (x instanceof BigDecimal) {
                    return getBigDecimal((BigDecimal) x);
                } else if (x instanceof Short) {
                    return getShort(((Short) x).shortValue());
                } else if (x instanceof Integer) {
                    return getInt(((Integer) x).intValue());
                } else if (x instanceof Long) {
                    return getLong(((Long) x).longValue());
                } else if (x instanceof Float) {
                    return getFloat(((Float) x).floatValue());
                } else if (x instanceof Double) {
                    return getDouble(((Double) x).doubleValue());
                } else if (x instanceof byte[]) {
                    return null;
                } else if (x instanceof java.sql.Date) {
                    return getDate((java.sql.Date) x);
                } else if (x instanceof Time) {
                    return getTime((Time) x);
                } else if (x instanceof Timestamp) {
                    return getTimestamp((Timestamp) x);
                } else if (x instanceof Boolean) {
                    return getBoolean(((Boolean) x).booleanValue());
                } else if (x instanceof InputStream) {
                    return getBinaryStream((InputStream) x, -1);
                } else if (x instanceof Blob) {
                    return getBlob((Blob) x);
                } else if (x instanceof Clob) {
                    return getClob((Clob) x);
                } else if (x instanceof BigInteger) {
                    return getBind(x.toString());
                } else if (x instanceof UUID) {
                    return null;
                } else if (x instanceof Collection) {
                    return null;
                } else if (x.getClass().isArray()) {
                    return null;
                } else {
                    throw new SQLDataException("Can't bind object of class " + x.getClass().getCanonicalName());
                }
            }
        }
    }
}
package cn.webrx.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.TypeHandlerRegistry;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Matcher;

@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
public class HelloInterceptor implements Interceptor {

    private static String[] officeIdNames = new String[]{"OFFICE_ID", "OFFICEID", "PK_OFFICE_ID"};

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        try {
            MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
            //0.sql参数获取
            Object parameter = null;
            if (invocation.getArgs().length > 1) {
                parameter = invocation.getArgs()[1];
            }

            //1.获取sqlId
            String sqlId = mappedStatement.getId();
            BoundSql boundSql = mappedStatement.getBoundSql(parameter);

            Configuration configuration = mappedStatement.getConfiguration();

            //获取真实的sql语句
            String sql = getSql(configuration, boundSql, sqlId, 0);


            //2.判断是否有officeId
            if (hasOfficeId(sql, officeIdNames)) {
                System.out.println(sql);
            } else {
                System.out.println(sql);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return invocation.proceed();
    }


    /**
     * 判断sql语句中是否包含officeId字段
     *
     * @param sql sql语句
     * @return
     */
    private boolean hasOfficeId(String sql, String[] officeIdNames) {
        //office ID 的可能名称
        if (sql == null || sql.trim().length() == 0) {
            return false;
        }

        String afterWhereStatement = sql.toUpperCase().substring(sql.indexOf("where"));

        for (String officeIdName : officeIdNames) {
            if (afterWhereStatement.indexOf(officeIdName) > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }

    private static String getSql(Configuration configuration, BoundSql boundSql, String sqlId, long time) {
        String sql = showSql(configuration, boundSql);
        StringBuilder str = new StringBuilder(100);
        str.append(sqlId);
        str.append(":");
        str.append(sql);
        return str.toString();
    }

    private static String getParameterValue(Object obj) {
        String value = null;
        if (obj instanceof String) {
            value = "'" + obj.toString() + "'";
        } else if (obj instanceof Date) {
            DateFormat formatter = DateFormat.getDateTimeInstance(
                    DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.CHINA);
            value = "'" + formatter.format(new Date()) + "'";
        } else {
            if (obj != null) {
                value = obj.toString();
            } else {
                value = "";
            }

        }
        return value;
    }

    private static String showSql(Configuration configuration, BoundSql boundSql) {
        Object parameterObject = boundSql.getParameterObject();
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        String sql = boundSql.getSql().replaceAll("[\\s]+", " ");
        if (!parameterMappings.isEmpty() && parameterObject != null) {
            TypeHandlerRegistry typeHandlerRegistry = configuration
                    .getTypeHandlerRegistry();
            if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
                sql = sql.replaceFirst("\\?",
                        Matcher.quoteReplacement(getParameterValue(parameterObject)));

            } else {
                MetaObject metaObject = configuration
                        .newMetaObject(parameterObject);
                for (ParameterMapping parameterMapping : parameterMappings) {
                    String propertyName = parameterMapping.getProperty();
                    if (metaObject.hasGetter(propertyName)) {
                        Object obj = metaObject.getValue(propertyName);
                        sql = sql.replaceFirst("\\?", Matcher.quoteReplacement(getParameterValue(obj)));
                    } else if (boundSql.hasAdditionalParameter(propertyName)) {
                        Object obj = boundSql
                                .getAdditionalParameter(propertyName);
                        sql = sql.replaceFirst("\\?", Matcher.quoteReplacement(getParameterValue(obj)));
                    } else {
                        sql = sql.replaceFirst("\\?", "缺失");
                    }//打印出缺失，提醒该参数缺失并防止错位
                }
            }
        }
        return sql;
    }
}
```

注册插件

```
<plugins>
    <plugin interceptor="com.xx.xx.xxxInterceptor">
        <property name="param1" value="value1"/>
    </plugin>
</plugins>
```

![image-20230420130127938](https://gitee.com/webrx/myatis2023/raw/master/assets/image-20230420130127938.png)

自定义分页:

```
/*
 * Copyright (c) 2006, 2023, webrx.cn All rights reserved.
 *
 */
package cn.webrx.interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.util.Properties;

/**
 * <p></p>
 * <p>Powered by webrx On 2023-04-20 17:56:39</p>
 *
 * @author webrx [webrx@126.com]
 * @version 1.0
 * @since 17
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
public class MyPager implements Interceptor {
    public static void startPage(int c, int p) {
        currpage = c;
        pagesize = p;
    }

    public static void startPage(int c) {
        currpage = c;
    }

    public static int currpage = 1;
    public static int pagesize = 10;
    public static int recordcount = 0;
    public static int pagecount = 1;

    public Object intercept(Invocation invocation) throws Throwable {
//System.out.println("拦截器:intercept(Invocation invocation)");
        var sh = invocation.getTarget();
        var mh = SystemMetaObject.forObject(sh);
        var ms = (MappedStatement) mh.getValue("delegate.mappedStatement");
        String msid = ms.getId();

        System.out.println(msid);

        if (msid.endsWith("ByPage")) {
//var ph = (ParameterHandler)
            mh.getValue("delegate.parameterHandler");
//var param = (Map<String, Object>) ph.getParameterObject();
            String sql =  mh.getValue("delegate.boundSql.sql").toString().trim() + String.format(" limit %d,%d", currpage * pagesize - pagesize, pagesize);
            mh.setValue("delegate.boundSql.sql", sql);
        }
        return invocation.proceed();
    }

    public Object plugin(Object target) {
//System.out.println("拦截器：plugin(Object target)");
//固定的写法，第二个参数表示要代理的对象 this
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties p) {
//System.out.println("拦截器：setProperties(Properties p)");
        this.pagesize = Integer.parseInt(p.getOrDefault("pagesize",
                15).toString());
        this.currpage = Integer.parseInt(p.getOrDefault("currpage",
                1).toString());
//System.out.println(this.pagesize);
    }
}
```

![image-20230420181346149](https://gitee.com/webrx/myatis2023/raw/master/assets/image-20230420181346149.png)

![image-20230420181320348](https://gitee.com/webrx/myatis2023/raw/master/assets/image-20230420181320348.png)

案例

```
@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
@Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class ExecutorEncryptInterceptor implements Interceptor {

	Properties properties = null;
	
	/**
     * 拦截方法逻辑
     * 这里主要是通过反射去获取要执行的SQL相关信息，然后进行操作
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
 
		Object target = invocation.getTarget(); //被代理对象
        Method method = invocation.getMethod(); //代理方法
        Object[] args = invocation.getArgs(); //方法参数
		
		MappedStatement mappedStatement = (MappedStatement) args[0];
        Object parameterObject = args[1];
		
        // do something ...方法拦截前执行代码块
		
        Object result = invocation.proceed();
		
        // do something ...方法拦截后执行代码块
		
        return result;
 
    }
 
    /**
     * 生成MyBatis拦截器代理对象
     */
    @Override
    public Object plugin(Object target) {
        if(target instanceof Executor){
            // 调用插件
            return Plugin.wrap(target, this);
        }
        return target;
    }
 
    /**
     * 设置插件属性（直接通过Spring的方式获取属性，所以这个方法一般也用不到）
     * 项目启动的时候数据就会被加载
     */
    @Override
    public void setProperties(Properties properties) {
        // 赋值成员变量，在其他方法使用
        this.properties = properties;
    }
 
   /* ... */
   
}
```

#### 5.3.2 StatementHandler.class

```
/*
 * Copyright (c) 2006, 2023, webrx.cn All rights reserved.
 *
 */
package cn.webrx.interceptor;

import cn.webrx.entity.Book;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.util.Arrays;

/**
 * <p></p>
 * <p>Powered by webrx On 2023-04-20 17:56:39</p>
 *
 * @author webrx [webrx@126.com]
 * @version 1.0
 * @since 17
 */
@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})
})
public class MyPager implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        System.out.println(Arrays.toString(args));

        Object target = invocation.getTarget();

        MetaObject metaObject = SystemMetaObject.forObject(target);

        MappedStatement ms = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        String msid = ms.getId();
        System.out.println(msid);
        System.out.println(ms.getSqlCommandType());


        //metaObject.getValue("delegate.boundSql.sql") 获取sql
        System.out.println(metaObject.getValue("delegate.boundSql.sql"));

        //设置参数
        ParameterHandler parameterHandler = (ParameterHandler)metaObject.getValue("delegate.parameterHandler");
        Object param = parameterHandler.getParameterObject();
        Book book = (Book)param;
        System.out.println(book);
        book.setPrice(100);
        System.out.println(book);


        //设置sql语句
        //metaObject.setValue("delegate.boundSql.sql","insert absdfasdf....");


        Object obj = invocation.proceed();
        return obj;
    }
}
```

#### 5.3.3 开发分页插件

> 第一步 ：编写插件

```
/*
 * Copyright (c) 2006, 2023, webrx.cn All rights reserved.
 *
 */
package cn.webrx.interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * <p></p>
 * <p>Powered by webrx On 2023-04-20 17:56:39</p>
 *
 * @author webrx [webrx@126.com]
 * @version 1.0
 * @since 17
 */
@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})
})
public class MyPager implements Interceptor {


    public static void startPage(int c, int p) {
        currpage = c;
        pagesize = p;
    }

    public static void startPage(int c) {
        currpage = c;
    }

    public static int currpage = 1;
    public static int pagesize = 10;
    public static int recordcount = 0;
    public static int pagecount = 1;

    public static String pageInfo() {
        return String.format("[第 %d 页/共 %d 页，每页 %d 条/共 %d 条]", currpage, pagecount, pagesize, recordcount);
    }


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object target = invocation.getTarget();
        MetaObject metaObject = SystemMetaObject.forObject(target);
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        if (mappedStatement.getSqlCommandType() == SqlCommandType.SELECT && mappedStatement.getId().endsWith("ByPage")) {

            String sql = metaObject.getValue("delegate.boundSql.sql").toString();
            //System.out.println(sql.trim());


            String sql1 = "select count(*) " + sql.substring(sql.indexOf("from"));
            Connection connection = (Connection) invocation.getArgs()[0];

            try {
                PreparedStatement pst = connection.prepareStatement(sql1);
                ResultSet rs = pst.executeQuery();
                rs.next();
                recordcount = rs.getInt(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            pagecount = recordcount % pagesize == 0 ? recordcount / pagesize : recordcount / pagesize + 1;


            String sql2 = sql.trim().concat(String.format(" limit %d,%d", currpage * pagesize - pagesize, pagesize));
            metaObject.setValue("delegate.boundSql.sql", sql2);

            //metaObject.getValue("delegate.boundSql.sql") 获取sql
            //System.out.println(metaObject.getValue("delegate.boundSql.sql"));

            //设置参数
            //ParameterHandler parameterHandler = (ParameterHandler)metaObject.getValue("delegate.parameterHandler");
            //Object param = parameterHandler.getParameterObject();
            //Book book = (Book)param;
            //System.out.println(book);
            //book.setPrice(100);
            //System.out.println(book);

            //设置sql语句
            //metaObject.setValue("delegate.boundSql.sql","insert absdfasdf....");


        }


        Object obj = invocation.proceed();
        return obj;
    }
}
```

> 第二步 ：注册插件

```
MyPager mp = new MyPager();
Properties prop = new Properties();
prop.setProperty("currpage", "1");
prop.setProperty("pagesize", "3");
mp.setProperties(prop);

//sf.setPlugins(new ExamplePlugin(), mp, new PageInterceptor());
sf.setPlugins(mp);
```

> 第三步 ：使用分页插件直接查询分页处理

```
//MyPager.startPage(1,5);
MyPager.startPage(4);
bm.myByPage();
System.out.println(MyPager.pageInfo());
```

#### 5.3.4 开发雪花算法插件

现在的服务基本是分布式、微服务形式的，而且大数据量也导致分库分表的产生，对于水平分表就需要保证表中 id 的全局唯一性。

对于 MySQL 而言，一个表中的主键 id 一般使用自增的方式，但是如果进行水平分表之后，多个表中会生成重复的 id 值。那么如何保证水平分表后的多张表中的 id 是全局唯一性的呢？

如果还是借助数据库主键自增的形式，那么可以让不同表初始化一个不同的初始值，然后按指定的步长进行自增。例如有3张拆分表，初始主键值为1，2，3，自增步长为3。

当然也有人使用 UUID 来作为主键，但是 UUID 生成的是一个无序的字符串，对于 MySQL 推荐使用增长的数值类型值作为主键来说不适合。

也可以使用 Redis 的自增原子性来生成唯一 id，但是这种方式业内比较少用。 当然还有其他解决方案，不同互联网公司也有自己内部的实现方案。雪花算法是其中一个用于解决分布式 id 的高效方案，也是许多互联网公司在推荐使用的。

##### SnowFlake 雪花算法

SnowFlake 中文意思为雪花，故称为雪花算法。最早是 Twitter 公司在其内部用于分布式环境下生成唯一 ID。在2014年开源 scala 语言版本。

![image-20230421135625012](https://gitee.com/webrx/myatis2023/raw/master/assets/image-20230421135625012.png)

```
雪花算法的原理就是生成一个的 64 位比特位的 long 类型的唯一 id。

1 最高 1 位固定值 0，因为生成的 id 是正整数，如果是 1 就是负数了。
2 接下来 41 位存储毫秒级时间戳，2^41/(1000*60*60*24*365)=69，大概可以使用 69 年。
3 再接下 10 位存储机器码，包括 5 位 datacenterId 和 5 位 workerId。最多可以部署 2^10=1024 台机器。
3 最后 12 位存储序列号。同一毫秒时间戳时，通过这个递增的序列号来区分。即对于同一台机器而言，同一毫秒时间戳下，可以生成 2^12=4096 个不重复 id。
可以将雪花算法作为一个单独的服务进行部署，然后需要全局唯一 id 的系统，请求雪花算法服务获取 id 即可。

对于每一个雪花算法服务，需要先指定 10 位的机器码，这个根据自身业务进行设定即可。例如机房号+机器号，机器号+服务号，或者是其他可区别标识的 10 位比特位的整数值都行。

java.lang.Long 8字节  mysql bigint 8字节
```

##### 算法优缺点

雪花算法有以下几个优点：

高并发分布式环境下生成不重复 id，每秒可生成百万个不重复 id。基于时间戳，以及同一时间戳下序列号自增，基本保证 id 有序递增。不依赖第三方库或者中间件。算法简单，在内存中进行，效率高。

雪花算法有如下缺点：

依赖服务器时间，服务器时钟回拨时可能会生成重复 id。算法中可通过记录最后一个生成 id 时的时间戳来解决，每次生成 id 之前比较当前服务器时钟是否被回拨，避免生成重复 id。

##### 注意事项

其实雪花算法每一部分占用的比特位数量并不是固定死的。例如你的业务可能达不到 69 年之久，那么可用减少时间戳占用的位数，雪花算法服务需要部署的节点超过1024 台，那么可将减少的位数补充给机器码用。

注意，雪花算法中 41 位比特位不是直接用来存储当前服务器毫秒时间戳的，而是需要当前服务器时间戳减去某一个初始时间戳值，一般可以使用服务上线时间作为初始时间戳值。

对于机器码，可根据自身情况做调整，例如机房号，服务器号，业务号，机器 IP 等都是可使用的。对于部署的不同雪花算法服务中，最后计算出来的机器码能区分开来即可。

##### 雪花算法

> 第一步：雪花算法代码组件

```
/*
 * Copyright (c) 2006, 2023, webrx.cn All rights reserved.
 *
 */
package cn.webrx.utils;

import org.springframework.stereotype.Component;

/**
 * <p></p>
 * <p>Powered by webrx On 2023-04-21 12:49:49</p>
 *
 * @author webrx [webrx@126.com]
 * @version 1.0
 * @since 17
 */
@Component
public class SnowFlakeUtils {
    /*
        起始时间时间戳：这个时间为第一次运行时的时间，这里设置为2021/11/23/19/17
        可以在未来的69年内稳定运行
     */
    private final static long START_STMP = 1637666189914L;


    private final static long SEQUENCE_BIT = 12;//序列号占用12bit
    private final static long MACHINE_BIT = 5;//机器号占用5bit
    private final static long MACHINE_HOUSE_BIT = 5;//机房号占用5bit
    /*
        -1的源码   10000001
        -1的反码   11111110
        -1的补码   11111111
        -1左移12位= 1111 1111 0000 0000 0000
        -1       = 1111 1111 1111 1111 1111
        异或运算  = 0000 0000 1111 1111 1111=4095
        因此MAX_SEQUENCE的值为4095
     */
    private final static long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);
    //同理 MAX_MACHINE为31
    private final static long MAX_MACHINE = -1L ^ (-1L << MACHINE_BIT);
    //同理 MAX_MACHINE_HOUSE值为31
    private final static long MAX_MACHINE_HOUSE = -1L ^ (-1L << MACHINE_HOUSE_BIT);
    //机器ID
    private long machineID;
    //机房ID
    private long machineHouseID;
    private long lastTime = 0;//上一次生成ID的时间戳
    private long sequence = 0;//序列号，默认为0

    public SnowFlakeUtils() {
        this.machineID = 0;
        this.machineHouseID = 0;
    }

    public SnowFlakeUtils(long machineID, long machineHouseID) {
        this.machineID = machineID;
        this.machineHouseID = machineHouseID;
    }

    public long getMachineID() {
        return machineID;
    }

    public void setMachineID(long machineID) {
        this.machineID = machineID;
    }

    public long getMachineHouseID() {
        return machineHouseID;
    }

    public void setMachineHouseID(long machineHouseID) {
        this.machineHouseID = machineHouseID;
    }


    /***
     *产生下一个ID
     * 用long型来表示我们生成的64位ID，
     * @return
     */

    public synchronized long nextId() {
        if (machineHouseID > MAX_MACHINE_HOUSE || machineID > MAX_MACHINE) {
            throw new RuntimeException("机房ID或机器ID超出最大值");
        }
        //获取当前时间戳
        long currentTime = System.currentTimeMillis();
        //如果当前时间小于上一次生成ID的时间，抛出异常
        if (currentTime < lastTime) {
            throw new RuntimeException("当前时间为异常值，请勿回拨时间！");
        }
        //如果当前时间等于上一次生成ID时间，说明是在同一毫秒中生成，那么序列号加一
        else if (currentTime == lastTime) {
            /*
                MAX_SEQUENCE: 0000 1111 1111 1111
                            &
                        4096: 0001 0000 0000 0000
                           = 0
                 当sequence小于4095时， (sequence+1)&MAX_SEQUENCE=sequence+1
                 当sequence等于4095时，(sequence+1)&MAX_SEQUENCE=0
             */
            sequence = (sequence + 1) & MAX_SEQUENCE;
            if (sequence == 0L) {
                //获取下一个毫秒值
                currentTime = getNextMill();
            }

        } else {
            //毫秒值不同，sequence初始为0
            sequence = 0L;
        }
        //更新最近一次生成时间的毫秒值
        lastTime = currentTime;
        return (currentTime - START_STMP) << 22//左移22位 空出机房ID5位+机器ID5位+序列号12位
                | machineID << 12//左移12位 空出序列号12位
                | machineHouseID << 17//左移17位 空出机器ID5位+序列号12位
                | sequence;//序列号部分
    }

    /**
     * 获取下一个毫秒值
     *
     * @return
     */
    private long getNextMill() {
        long mill = System.currentTimeMillis();
        //如果当前时间等于上一次的时间则一直自旋
        while (mill == lastTime) {
            mill = System.currentTimeMillis();
        }
        return mill;
    }

    /**
     * Main方法测试
     *
     * @param args
     */
    public static void main(String[] args) {
        //初始化一个雪花算法工具类，设置机房ID和机器ID都为0
        SnowFlakeUtils snowFlakeUtils = new SnowFlakeUtils(0, 0);
        for (int i = 0; i < 100; i++) {
            //生成100个ID
            System.out.println(snowFlakeUtils.nextId());
        }
    }
}
```

> 第二步：

```
/*
 * Copyright (c) 2006, 2023, webrx.cn All rights reserved.
 *
 */
package cn.webrx.interceptor;

import cn.webrx.utils.SnowFlakeUtils;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * <p></p>
 * <p>Powered by webrx On 2023-04-20 17:56:39</p>
 *
 * @author webrx [webrx@126.com]
 * @version 1.0
 * @since 17
 */

@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})
})
public class KeyGen implements Interceptor {

    SnowFlakeUtils su;

    public void setSu(SnowFlakeUtils su){
        this.su=su;
    }


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object target = invocation.getTarget();
        MetaObject metaObject = SystemMetaObject.forObject(target);
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        if (mappedStatement.getSqlCommandType() == SqlCommandType.INSERT) {

            ParameterHandler parameterHandler = (ParameterHandler)metaObject.getValue("delegate.parameterHandler");
            Object param = parameterHandler.getParameterObject();
            System.out.println(param);
            //System.out.println(param.getClass().getDeclaredFields().length);

            //bigint long  long id; @AutoID
            try{
                if(param.getClass().getDeclaredField("id").isAnnotationPresent(AutoID.class)){
                    //String sql = metaObject.getValue("delegate.boundSql.sql").toString();
                    //String sql1 = sql.replace("null",String.valueOf(su.nextId()));
                    //metaObject.setValue("delegate.boundSql.sql", sql1);

                    Class<?> c = param.getClass();
                    Method method = c.getMethod("setId",Long.class);
                    method.invoke(param,su.nextId());

                    System.out.println(param);

                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        Object obj = invocation.proceed();
        return obj;
    }
}
```

> 第三步：

```
/*
 * Copyright (c) 2006, 2023, webrx.cn All rights reserved.
 *
 */
package cn.webrx.config;

import cn.webrx.interceptor.DemoInterceptor;
import cn.webrx.interceptor.ExamplePlugin;
import cn.webrx.interceptor.KeyGen;
import cn.webrx.interceptor.MyPager;
import cn.webrx.utils.SnowFlakeUtils;
import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Properties;

/**
 * <p></p>
 * <p>Powered by webrx On 2023-04-19 14:19:11</p>
 *
 * @author webrx [webrx@126.com]
 * @version 1.0
 * @since 17
 */
@Configuration
@MapperScan({"cn.webrx.mapper"})
@ComponentScan("cn.webrx")
public class AppConfig {
    private String url = "jdbc:mysql:/db";
    private String username = "root";
    private String password = "root";

    @Bean
    public LocalDate now() {
        return LocalDate.now();
    }

    @Bean(name = "ds", initMethod = "init", destroyMethod = "close")
    public DruidDataSource druidDataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }

    @Bean("sf")
    public SqlSessionFactoryBean sqlSessionFactoryBean(DruidDataSource ds,MyPager mp,KeyGen kg) throws IOException {
        SqlSessionFactoryBean sf = new SqlSessionFactoryBean();
        sf.setDataSource(ds);

        //设置别名 cn.webrx.entity.Book 别名就 book cn.webrx.vo.BookVo 别名就是 bookVo bookvo
        sf.setTypeAliasesPackage("cn.webrx.entity,cn.webrx.vo");

        //注册PageHelper插件


        //sf.setPlugins(new ExamplePlugin(), mp, new PageInterceptor());
        sf.setPlugins(kg);

        sf.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*Mapper*.xml"));
        return sf;
    }

    @Bean
    public SqlSession sqlSession(SqlSessionFactoryBean sf) throws Exception {
        return sf.getObject().openSession();
    }

    @Bean
    public MyPager myPager(SnowFlakeUtils su){
        MyPager mp = new MyPager();
        mp.setSu(su);
        Properties prop = new Properties();
        prop.setProperty("currpage", "1");
        prop.setProperty("pagesize", "3");
        mp.setProperties(prop);
        return mp;
    }
    @Bean
    public KeyGen keyGen(SnowFlakeUtils su){
        KeyGen kg = new KeyGen();
        kg.setSu(su);
        return kg;
    }
}
```

> 第四步：表设计及模型类注解

```
/*
 * Copyright (c) 2006, 2023, webrx.cn All rights reserved.
 *
 */
package cn.webrx.entity;

import cn.webrx.interceptor.AutoID;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * <p></p>
 * <p>Powered by webrx On 2023-04-19 14:54:17</p>
 *
 * @author webrx [webrx@126.com]
 * @version 1.0
 * @since 17
 */
@Data
public class Book {
    @AutoID
    private Long id;
    private String name;
    private double price;
    private String author;
    private LocalDate pdate;
}


//插件使用中的注解类 @AutoId
package cn.webrx.interceptor;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p></p>
 * <p>Powered by webrx On 2023-04-21 14:34:37</p>
 *
 * @author webrx [webrx@126.com]
 * @version 1.0
 * @since 17
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoID {
}
```

![image-20230421152237187](https://gitee.com/webrx/myatis2023/raw/master/assets/image-20230421152237187.png)

> 第五步：mapper

```
int add(Book book);
<insert id="add" parameterType="book" useGeneratedKeys="true" keyColumn="id" keyProperty="id">
    insert into t_book
    values (#{id}, #{name}, #{price}, #{author}, #{pdate})
</insert>
```

> 第六步：测试

```
@Test
void m14() {
    Book b = new Book();
    b.setId(234234L);
    b.setName("《myatis ORM》");
    b.setPrice(55D);
    b.setAuthor("李四");
    b.setPdate(LocalDate.of(2023, 5, 15));
    bm.add(b);
}
```

![image-20230421152857424](https://gitee.com/webrx/myatis2023/raw/master/assets/image-20230421152857424.png)

## 第六章 mybatis 通用Mapper工具

![image-20230421162643882](https://gitee.com/webrx/myatis2023/raw/master/assets/image-20230421162643882.png)

mybatis.io

> 第一步 ：添加依赖组件

```
<!-- tk.mybatis/mapper -->
<dependency>
    <groupId>tk.mybatis</groupId>
    <artifactId>mapper</artifactId>
    <version>4.2.2</version>
</dependency>
```

> 第二步：spring 项目

```
@Bean
public MapperScannerConfigurer mapperScannerConfigurer() {
    MapperScannerConfigurer ms = new MapperScannerConfigurer();
    ms.setBasePackage("cn.webrx.mapper");
    return ms;
}
```

> 第三步：应用

建立表

```
CREATE TABLE `country` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `countryname` varchar(255) DEFAULT NULL COMMENT '名称',
  `countrycode` varchar(255) DEFAULT NULL COMMENT '代码',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=10011 DEFAULT CHARSET=utf8 COMMENT='国家信息';
```

建立实体 注解表名 列名 忽略对象和表不匹配的属性

```
/*
 * Copyright (c) 2006, 2023, webrx.cn All rights reserved.
 *
 */
package cn.webrx.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * <p></p>
 * <p>Powered by webrx On 2023-04-21 16:34:08</p>
 *
 * @author webrx [webrx@126.com]
 * @version 1.0
 * @since 17
 */
@Data //@Table(name = "country")
public class Country {
    @Id //@Column(name = "c_id")
    private Integer id;
    private String countryname;
    private String countrycode;

    @Transient
    private String info;
}
```

建立Mapper接口

```
@Repository
public interface CountryMapper extends Mapper<Country> {
}
```

> 第四步：测试程序

```
@Test
void m15(){
    Country c = new Country();
    //c.setId(20);
    //c.setCountryname("中国");
    //c.setCountrycode("86");
    //cm.save(c);
    //cm.insert(c);
    //cm.insertSelective(c);

    List<Country> cs = cm.selectAll();
    System.out.println(cs);

    Country c2 = cm.selectByPrimaryKey(20);
    c2.setCountrycode("99");

    cm.save(c2);
    System.out.println(c2);

    cm.deleteByPrimaryKey(20);

    Map<String,Object> map = new HashMap<>();
    map.put("id",20);
    map.put("countryname","中国");

    Example ex = new Example(Country.class);
    ex.setCountProperty("中国");
    ex.setTableName("tt");
    ex.selectProperties("id","countrycode");
    ex.or().andEqualTo("id",20);
    System.out.println(cm.selectByExample(ex));
    //System.out.println(cm.selectByExample(null));
}
```

![image-20230421171347888](https://gitee.com/webrx/myatis2023/raw/master/assets/image-20230421171347888.png)

## 第七章 mybatis 动态SQL语句

> 别名设置使用，#{} 和 ${} 区别

### 7.1 ResultMap

解决表的查询字段名和对象属性名不匹配问题。

```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="cn.webrx.mapper.AdminMapper">

    <resultMap id="am" type="cn.webrx.entity.Admin">
        <id column="tid" property="id" javaType="int"/>
        <result column="tname" property="name" javaType="string"/>
        <result column="tpass" property="password" javaType="string"/>
    </resultMap>

    <select id="queryAll" resultMap="am">
<!--         select tid as id,tname as name,tpass password from t_admin -->
         select * from t_admin
    </select>
</mapper>
```

### 7.2 动态SQL语句

#### 7.2.1 if

```
public List<Book> selectAll();
//public List<Book> selectAll(int id);
public List<Book> selectAll(Map<String, Object> map);
<select id="selectAll">
    select * from t_book
    <if test="id!=null">
        where id = #{id}
    </if>
    <if test="name!=null">
        <if test="name.indexOf('%')!=-1 or name.indexOf('_')!=-1">
            where name like #{name}
        </if>

        <if test="name.indexOf('%')==-1 and name.indexOf('_')==-1">
            where name = #{name}
        </if>
    </if>
</select>
```

测试

```
@Test
void m17(){
     Map<String,Object> map = new HashMap<>();
        //map.put("id",90);
        //List<Book> list = bm.selectAll(map);
        //System.out.println(list.size());
        //System.out.println(list.get(0));

        map.put("name","%ja_a%");
        //List<Book> list = bm.selectAll();
        //List<Book> list = bm.selectAll(null);
        List<Book> list = bm.selectAll(map);
}
```

## 第八章 mybatis 高级关系查询

## 第九章 mybatis 缓存

## 第十章 mybatis 逆向工程

## 附录1 maven 打不到xml文件

打到项目的pom.xml文件，添加如下资源使用，如果没有配置，resources目录下会自动编译发布。

```
<build>
<resources>
    <resource>
        <directory>src/main/resources</directory>
        <includes>
            <include>**/*</include>
        </includes>
    </resource>
    <resource>
        <directory>src/main/java</directory>
        <includes>
            <include>**/*.xml</include>
            <include>**/*.html</include>
            <include>**/*.properties</include>
        </includes>
    </resource>
</resources>
</build>    
```

## 附录2 mybatis 配置文件模板参考

```
src/main/resources/db.properties
db.driver=com.mysql.cj.jdbc.Driver
db.url=jdbc:mysql:/db
db.username=root
db.password=root
src/main/resources/mybatis-config.xlm
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <properties resource="db.properties"/>

    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="${db.driver}"/>
                <property name="url" value="${db.url}"/>
                <property name="username" value="${db.username}"/>
                <property name="password" value="${db.password}"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <!--<mapper resource="cn/webrx/mapper/DbMapper.xml"/>-->

        <!-- mybatis 核心配置文件，会自动加载mapper下的所有接口及和接口同名的xml配置 -->
        <package name="cn.webrx.mapper"/>

        <!--<mapper class="cn.webrx.mapper.DbMapper"/>-->
        <!--<mapper resource="cn/webrx/mapper/DbMapper.xml"/>-->
    </mappers>
</configuration>
src/main/java/cn/webrx/mapper/DbMapper.xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="cn.webrx.mapper.DbMapper">
</mapper>
```

## 附录3 log4j2配置文件

### 3.1 maven pom

```
<!-- org.apache.logging.log4j/log4j-core -->
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.20.0</version>
</dependency>

<!-- org.springframework.boot/spring-boot-starter-log4j2 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-log4j2</artifactId>
    <version>3.0.5</version>
</dependency>

<!-- org.springframework.boot/spring-boot-starter-log4j2 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-log4j2</artifactId>
    <version>2.7.10</version>
</dependency>
```

### 3.2 log4j2.xml

```
src/main/resources/log4j2.xml配置文件位置
<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="WARN">
    <Appenders>
        <Console name="LogToConsole" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
        </Console>
        <File name="LogToFile" fileName="log/test.log">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
        </File>
    </Appenders>
    <Loggers>
        <Logger name="orgb" level="error">
            <AppenderRef ref="LogToConsole"/>
        </Logger>
        <Logger name="orga" level="debug" additivity="false">
            <AppenderRef ref="LogToConsole"/>
            <AppenderRef ref="LogToFile"/>
        </Logger>

        <Logger name="cn.webrx.mapper" level="debug">
            <AppenderRef ref="LogToConsole"/>
            <AppenderRef ref="LogToFile"/>
        </Logger>

        <Logger name="org.webrx.Demo" level="debug">
            <AppenderRef ref="LogToConsole"/>
            <AppenderRef ref="LogToFile"/>
        </Logger>

        <Root level="error">
            <AppenderRef ref="LogToConsole"/>
        </Root>
    </Loggers>
</Configuration>
```

参考二，`默认情况下Logger继承root，所有不要再写<appender-ref ref="Console"/> 不然打印两份debug日志 信息`

```
<?xml version="1.0" encoding="UTF-8"?>
<configuration status="OFF">
    <appenders>
        <Console name="Console" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
        </Console>
    </appenders>
    <loggers>
        <Logger name="cn" level="debug">
            <!-- 默认情况下Logger继承root，所有不要再写<appender-ref ref="Console"/> 不然打印两份debug日志 -->
            <!--<appender-ref ref="Console"/>-->
        </Logger>
        <root level="error">
            <appender-ref ref="Console"/>
        </root>
    </loggers>
</configuration>
```

## 附录4 spring 配置类参考

### 4.1 常用依赖

```
<!-- org.mybatis/mybatis -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.13</version>
</dependency>

<!-- mybatis-spring -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis-spring</artifactId>
    <version>3.0.1</version>
</dependency>

<!-- com.alibaba/druid -->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid</artifactId>
    <version>1.2.17</version>
</dependency>

<!-- org.apache.logging.log4j/log4j-core -->
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.20.0</version>
</dependency>

<!-- org.springframework/spring-context -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>6.0.8</version>
</dependency>

<!--org.springframework/spring-jdbc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>6.0.8</version>
</dependency>
<!-- org.springframework/spring-test -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-test</artifactId>
    <version>6.0.8</version>
</dependency>

<!-- org.springframework/spring-context -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>5.3.27</version>
</dependency>

<!-- com.zaxxer/HikariCP -->
<dependency>
    <groupId>com.zaxxer</groupId>
    <artifactId>HikariCP</artifactId>
    <version>5.0.1</version>
</dependency>

<!-- mysql-connector-java -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
</dependency>

<!-- org.junit.jupiter/junit-jupiter-api -->
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.9.2</version>
    <scope>test</scope>
</dependency>

<!-- org.projectlombok/lombok -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.26</version>
    <scope>provided</scope>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-log4j2</artifactId>
    <version>2.7.10</version>
</dependency>
<!-- spring-boot-starter-log4j2 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-log4j2</artifactId>
    <version>3.0.5</version>
</dependency>
```

### 4.2 AppConfig.java

```
beans.xml` `applicationContext.xml` `spring.xml
/*
 * Copyright (c) 2006, 2023, webrx.cn All rights reserved.
 *
 */
package cn.webrx.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

/**
 * <p>Powered by webrx On 2023-04-19 21:48:53
 *
 * @author webrx [webrx@126.com]
 * @version 1.0
 * @since 17
 */

@Configuration
@PropertySource("classpath:db.properties")
@ComponentScan("cn.webrx.mapper")
@MapperScan("cn.webrx.mapper")
public class AppConfig {
    @Value("${db.driver}")
    private String driver;
    @Value("${db.url}")
    private String url;
    @Value("${db.username:root}")
    private String username;
    @Value("${db.password:root}")
    private String password;

    @Bean(name = "ds",initMethod = "init",destroyMethod = "close")
    public DruidDataSource druidDataSource(){
        var ds = new DruidDataSource();
        ds.setUrl(url);
        ds.setDriverClassName(driver);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DruidDataSource ds) throws IOException {
        var sf = new SqlSessionFactoryBean();
        sf.setDataSource(ds);
        sf.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*Mapper*.xml"));
        return sf;
    }

}
```

### 4.3 logj2.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<configuration status="OFF">
    <appenders>
        <Console name="Console" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
        </Console>
    </appenders>
    <loggers>
        <Logger name="cn" level="debug">
            <!-- 默认情况下Logger继承root，所有不要再写<appender-ref ref="Console"/> 不然打印两份debug日志 -->
            <!--<appender-ref ref="Console"/>-->
        </Logger>
        <root level="error">
            <appender-ref ref="Console"/>
        </root>
    </loggers>
</configuration>
```

### 4.4 spring jupiter junit5

```
/*
 * Copyright (c) 2006, 2023, webrx.cn All rights reserved.
 *
 */
package cn.webrx;

import cn.webrx.config.AppConfig;
import cn.webrx.mapper.DbMapper;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Arrays;

/**
 * <p>Powered by webrx On 2023-04-19 21:59:37
 *
 * @author webrx [webrx@126.com]
 * @version 1.0
 * @since 17
 */
@SpringJUnitConfig(AppConfig.class)
@Log4j2
public class MyDemo {
    @Autowired
    ApplicationContext ctx;

    @Autowired
    DbMapper dm;

    @Test
    public void m(){
        System.out.println(dm.dbs());
        //log.log(Level.ERROR,"hello log error");
        //System.out.println(Arrays.toString(ctx.getBeanDefinitionNames()));
    }
}
```

### 4.5 db.properties

```
src/main/resources/db.properties
db.driver=com.mysql.cj.jdbc.Driver
db.url=jdbc:mysql:/dbsm
db.username=root
db.password=
```

### 4.6 maven无法加载资源

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>cn.webrx</groupId>
    <artifactId>myatis2023</artifactId>
    <version>1.0</version>
    <packaging>pom</packaging>
    <modules>
        <module>ch01-hello</module>
        <module>ch02-demo</module>
        <module>ch03</module>
        <module>ch04-log</module>
        <module>ch05</module>
        <module>ch06-springdemo</module>
        <module>ch07-springbootdemo</module>
        <module>ch08-crud</module>
    </modules>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <java.version>17</java.version>
    </properties>

    <dependencies>
        <!-- org.projectlombok/lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.24</version>
            <scope>provided</scope>
        </dependency>

        <!-- org.mybatis/mybatis -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.13</version>
        </dependency>


        <!-- mysql-connector-java -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.32</version>
        </dependency>

    </dependencies>

    <build>
        <finalName>${project.artifactId}</finalName>
        <testSourceDirectory>src/test/java</testSourceDirectory>
        <sourceDirectory>src/main/java</sourceDirectory>
        <!-- 处理无法加载资源配置文件 -->
        <resources>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.xml</include>
                </includes>
            </resource>

            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.xml</include>
                    <include>**/*.yml</include>
                    <include>**/*.properties</include>
                    <include>**/*.html</include>
                </includes>
            </resource>
        </resources>
    </build>
</project>
```





