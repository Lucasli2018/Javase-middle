### 插件

#### 打包依赖

maven-shade-plugin

在项目根目录使用命令行：mvn package

```xml
<!-- jar打包工具 -->
  <build>
  	<plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-shade-plugin</artifactId>
        <version>3.2.1</version>
        <executions>
          <execution>
            <phase>package</phase>
            <goals>
              <goal>shade</goal>
            </goals>
            <configuration>
              <transformers>
                <transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                  <mainClass>com.lucas.maven.helloMaven.App</mainClass>
                </transformer>
              </transformers>
            </configuration>
          </execution>
        </executions>
      </plugin>
    </plugins>
  </build>
```

#### 测试报告

cobertura-maven-plugin

在命令行：mvn cobertura:cobertura

```xml
<!-- test测试报告 -->
  <reporting>
    <plugins>
      <plugin>
        <groupId>org.codehaus.mojo</groupId>
        <artifactId>cobertura-maven-plugin</artifactId>
        <version>2.7</version>
      </plugin>
    </plugins>
  </reporting>
```



### 提取依赖

parent pom.xml

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.lucas.maven</groupId>
  <artifactId>parent</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <packaging>pom</packaging>

  <name>helloMaven</name>
  <url>http://maven.apache.org</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <java.version>1.8</java.version>
    <maven.compile.source>1.8</maven.compile.source>
    <maven.compile.target>1.8</maven.compile.target>
  </properties>

  <dependencies>
  	<!--日志  -->
  	<dependency>
      <groupId>commons-logging</groupId>
      <artifactId>commons-logging</artifactId>
      <version>1.2</version>
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
    
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
  
  <!-- jar打包工具 -->
  <build>
  	<plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-shade-plugin</artifactId>
        <version>3.2.1</version>
        <executions>
          <execution>
            <phase>package</phase>
            <goals>
              <goal>shade</goal>
            </goals>
            <configuration>
              <transformers>
                <transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                  <mainClass>com.lucas.maven.helloMaven.App</mainClass>
                </transformer>
              </transformers>
            </configuration>
          </execution>
        </executions>
      </plugin>
    </plugins>
  </build>
  
  <!-- test测试报告 -->
  <reporting>
    <plugins>
      <plugin>
        <groupId>org.codehaus.mojo</groupId>
        <artifactId>cobertura-maven-plugin</artifactId>
        <version>2.7</version>
      </plugin>
    </plugins>
  </reporting>
</project>

```

### 模块化

build pom.xml

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.lucas.maven</groupId>
  <artifactId>build</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <packaging>pom</packaging>
  <modules>
  	<module>../parent</module>
  	<module>../greeting</module>
  	<module>../helloMaven</module>
  </modules>

  <name>helloMaven</name>
  <url>http://maven.apache.org</url>

</project>

```

#### 子模块

greeting pom.xml

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
<parent>
	<groupId>com.lucas.maven</groupId>
	<artifactId>parent</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<relativePath>../parent/pom.xml</relativePath>
</parent>

  <artifactId>greeting</artifactId>
  <packaging>jar</packaging>

  <name>helloMaven</name>
  <url>http://maven.apache.org</url>
</project>

```

helloMaven pom.xml

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <parent>
  	<groupId>com.lucas.maven</groupId>
  	<artifactId>parent</artifactId>
  	<version>0.0.1-SNAPSHOT</version>
  	<relativePath>../parent/pom.xml</relativePath>
  </parent>

  <artifactId>helloMaven</artifactId>
  <packaging>jar</packaging>

  <name>helloMaven</name>
  <url>http://maven.apache.org</url>


  <dependencies>
  
  	<dependency>
      <groupId>com.lucas.maven</groupId>
      <artifactId>greeting</artifactId>
      <version>0.0.1-SNAPSHOT</version>
    </dependency>
  </dependencies>
</project>

```



### 日志

log4j2.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!--  -->
<configuration>
	<loggers>
		<root level="info">
			<appenderRef ref="stdout"></appenderRef>
			<appenderRef ref="all"></appenderRef>
		</root>
	</loggers>
	<appenders>
		<console name="stdout">
			<patternLayout pattern="%d %p [%t]: %m%n"></patternLayout>
		</console>
		<RollingFile name="all" fileName="log/all.log" filePattern="log/all.%i.log.gz">
			<patternlayout pattern="%d{yyyy-MM-dd HH:mm:ss} %p [%t]: %n%m%n "/>
			<Policies>
				
			</Policies>
		</RollingFile>
	</appenders>
</configuration>
```

