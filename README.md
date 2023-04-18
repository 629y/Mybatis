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

`src/main/java/cn/webrx/Demo.java`

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

```properties
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
        <!--<mapper resource="cn/webrx/mapper/DbMapper.xml"/>-->

        <!-- mybatis 核心配置文件，会自动加载mapper下的所有接口及和接口同名的xml配置 -->
        <package name="cn.webrx.mapper"/>

        <!--<mapper class="cn.webrx.mapper.DbMapper"/>-->
        <!--<mapper resource="cn/webrx/mapper/DbMapper.xml"/>-->
    </mappers>
</configuration>

```

> 第三步 编写接口DbMapper.java 及 DbMapper.xml

`src/main/java/cn/webrx/mapper/DbMapper.java`

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



`src/main/java/cn/webrx/mapper/DbMapper.xml`

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="cn.webrx.mapper.DbMapper">
    <select id="dbs">show databases</select>
</mapper>

```

> 第四步 编写程序进行测试 `src/main/java/cn/webrx/MyDemo.java`

```java
/*
 * Copyright (c) 2006, 2023, webrx.cn All rights reserved.
 *
 */
package cn.webrx;

import cn.webrx.mapper.DbMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * <p></p>
 * <p>Powered by webrx On 2023-04-18 11:44:14</p>
 *
 * @author webrx [webrx@126.com]
 * @version 1.0
 * @since 17
 */
public class MyDemo {
    public static void main(String[] args) {
        try(var is = Resources.getResourceAsStream("mybatis-config.xml")){
            var sf = new SqlSessionFactoryBuilder().build(is);
            var ss = sf.openSession();
            DbMapper db = ss.getMapper(DbMapper.class);000000
            System.out.println(db.version());

            System.out.println(db.dbs());

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

```

![image-20230418115841961](assets/image-20230418115841961.png)

###  3.3 编程方式

建立项目，不写配置文件mybatis-config.xml，直接编写使用mybatis，编写接口和接口的映射xml

> 第一步 ：建立项目，pom.xml内容如下

```
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

```
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





































