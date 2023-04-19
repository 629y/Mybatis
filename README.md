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

```java
src/main/java/cn/webrx/mapper/DbMapper.java 接口
package cn.webrx.mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;
public interface DbMapper {
    @Select("show databases")
    public List<String> dbs();
    public List<String> tbs(String db);
}
src/main/java/cn/webrx/mapper/DbMapper.xml 映射接口
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="cn.webrx.mapper.DbMapper">
    <select id="tbs" resultType="string">
        show tables from ${db}
    </select>

    <!--<select id="dbs" resultType="string">show databases</select>-->
</mapper>
```

> 第三步：编写主测试程序 cn.webrx.Demo

```java
/*
 * Copyright (c) 2006, 2023, webrx.cn All rights reserved.
 *
 */
package cn.webrx;
import cn.webrx.mapper.DbMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
/**
 * <p></p>
 * <p>Powered by webrx On 2023-04-18 12:07:48</p>
 *
 * @author webrx [webrx@126.com]
 * @version 1.0
 * @since 17
 */
public class Demo {
    public static void main(String[] args) {
        //建立数据源
        PooledDataSource ds = new PooledDataSource("com.mysql.cj.jdbc.Driver","jdbc:mysql:/db","root","root");
        //建立事务管理对象
        TransactionFactory tx = new JdbcTransactionFactory();
        //建立环境
        Environment env = new Environment("dev",tx,ds);
        //建立cfg
        Configuration cfg = new Configuration(env);
        cfg.addMappers("cn.webrx.mapper");
        //cfg.addMapper(DbMapper.class);
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(cfg);
        SqlSession ss = sf.openSession();
        DbMapper dm = ss.getMapper(DbMapper.class);
        System.out.println(dm.dbs());
        System.out.println(dm.tbs("db"));
    }
}
```

![image-20230418134731353](https://gitee.com/webrx/myatis2023/raw/master/assets/image-20230418134731353.png)

### 3.4 整合日志框架显示SQL语句

###  spring demo整合

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

#### 4.1.1 insert

```
@Insert
@Insert("insert into t_book(name,price,author) value(#{name},#{price},#{author})")
@Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
public int insert(Map<String,Object> map);

@Insert("insert into t_book(name,price,author) value(#{name},#{price},#{author})")
public int save(@Param("name") String name,@Param("price") double price,@Param("author") String author);
<!-- 此处代码在XxxMapper.xml文件，使用<insert>标签，实现插入 -->
<insert id="add" parameterType="book" useGeneratedKeys="true" keyColumn="id" keyProperty="id">
        insert into t_book values(null,#{name},#{price},#{author},#{pdate})
    </insert>
```

#### 4.1.2 delete

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

## 附录 maven 打不到xml文件

打到项目的pom.xml文件，添加如下资源使用，如果没有配置，resources目录下会自动编译发布。

 ```xml
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





































