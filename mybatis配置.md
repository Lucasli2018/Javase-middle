#### pom.xml

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.lucas.javase.mybatis</groupId>
  <artifactId>demo</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <packaging>jar</packaging>

  <name>demo</name>
  <url>http://maven.apache.org</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <java.version>1.8</java.version>
    <maven.compile.source>1.8</maven.compile.source>
    <maven.compile.target>1.8</maven.compile.target>
  </properties>

  <dependencies>
    <dependency>
      <groupId>commons-logging</groupId>
      <artifactId>commons-logging</artifactId>
      <version>1.2</version>
    </dependency>
    
    <!-- mybatis依赖 -->
	<dependency>
		<groupId>org.mybatis</groupId>
		<artifactId>mybatis</artifactId>
		<version>3.4.6</version>
	</dependency>
	<!-- mysql依赖 -->
	<dependency>
		<groupId>mysql</groupId>
		<artifactId>mysql-connector-java</artifactId>
		<version>5.1.35</version>
	</dependency>
    
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
      <scope>test</scope>
    </dependency>
    
    <!--日志  -->
  	<dependency>
      <groupId>org.apache.logging.log4j</groupId>
      <artifactId>log4j-jcl</artifactId>
      <version>2.8.2</version>
      <scope>runtime</scope>
    </dependency>
    <dependency>
      <groupId>org.apache.logging.log4j</groupId>
      <artifactId>log4j-core</artifactId>
      <version>2.8.2</version>
      <scope>runtime</scope>
    </dependency>
    
  </dependencies>
</project>

```

#### log4j2.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!--  -->
<configuration>
	<loggers>
		<root level="info">
			<appenderRef ref="stdout"></appenderRef>
		</root>
	</loggers>
	<appenders>
		<console name="stdout">
			<patternLayout pattern="%d %p [%t]-->: %m%n"></patternLayout>
		</console>
	</appenders>
</configuration>
```

#### db.properties

```properties
db.driver=com.mysql.jdbc.Driver
db.url=jdbc:mysql://localhost:3306/ssm?characterEncoding=utf-8
db.username=root
db.password=root
```

#### SqlMapConfig.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
	<!-- 读取properties 配置文件 -->
	<properties resource="properties/db.properties"></properties>

	<!-- 配置数据源 -->
	<environments default="development">
		<environment id="development">
			<!-- 事务管理：采用的是JDBC的事务管理 -->
			<transactionManager type="JDBC" />
			<!-- 配置数据源连接池： POOLED使用的是Mybatis自己的连接池 -->
			<dataSource type="POOLED">
				<property name="driver" value="${db.driver}" />
				<property name="url" value="${db.url}" />
				<property name="username" value="${db.username}" />
				<property name="password" value="${db.password}" />
			</dataSource>
		</environment>
	</environments>

	<!-- 读取mapper映射文件 -->
	<mappers>
		<mapper resource="introduction/UserMapper.xml" />
	</mappers>
</configuration>
```

#### UserMapper.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- namespace：作用是为了分类管理映射文件中的MappedStatement对象 -->
<mapper namespace="test">
	<!-- select\insert\update\delete标签，最终会封装到MappedStatement对象中 -->
	<!-- id：指定MappedStatement对象的唯一标识 -->
	<!-- 对象参数绑定：使用的是OGNL -->
	<!-- parameterType:指定输入参数映射的java类型 -->
	<!-- resultType:指定结果集映射的java类型 -->
	<select id="findUserById" parameterType="int" resultType="com.lucas.javase.mybatis.introduction.po.User" >
		SELECT * FROM user WHERE id = #{id}
	</select>
	
	<select id="findUserListByName" parameterType="string" resultType="com.lucas.javase.mybatis.introduction.po.User">
		SELECT * FROM user WHERE username LIKE '%${value}%'
	</select>
	<insert id="insertUser" parameterType="com.lucas.javase.mybatis.introduction.po.User" useGeneratedKeys="true">
		INSERT INTO user (username,sex,birthday,address) VALUES (#{username},#{sex},#{birthday},#{address})
	</insert>
	
</mapper>
```

