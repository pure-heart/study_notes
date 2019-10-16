# Jhly #
Jhly的个人学习记录

<hr>

#### mybatis内容回顾 ####

1.<a>配置mybatis.xml全局配置文件</a>

2.<a>配置mapper.xml</a>

3.<a>XXXMapper接口绑定</a>

4.<a>动态SQL</a>

5.<a>多表联合查询</a>

6.<a>注解</a>

7.<a>mybatis运行原理</a>

<hr>



#### spring内容回顾 ####

1.配置applicationContext.xml配置文件

2.ioc

3.创建bean的三种方式

4.属性注入

5.bean范围

6.DI

7.AOP的实现方式

8.通知

9.通过注解实现AOP

10.声明式事务

11.spring加载配置文件

12.常用注解

<hr>



#### springmvc内容回顾 ####

1.基本配置

2.参数接收

3.跳转方式和自定义视图解析器

4.@ResponseBody

5.传值方式

6.自定义拦截器和拦截器栈

7.springmvc运行原里

<hr>

#### spring-springmvc-mybatis整合 ####



1.maven依赖

```
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.jhly.ssm</groupId>
    <artifactId>spring-springmvc-mybatis</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>war</packaging>
    <properties>
        <spring.version>5.1.9.RELEASE</spring.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.11</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.10</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.9.9</version>
        </dependency>
        <dependency>
            <groupId>aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.5.4</version>
        </dependency>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>4.0.1</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.17</version>
        </dependency>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.2</version>
        </dependency>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>2.0.2</version>
        </dependency>
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>
    </dependencies>

</project>

```

2.web.xml

```
<!DOCTYPE web-app PUBLIC
 "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
 "http://java.sun.com/dtd/web-app_2_3.dtd" >

<web-app>
  <!-- 上下文参数 -->
  <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:applicationContext.xml</param-value>
  </context-param>
  <!-- 监听器 -->
  <listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>
  <!-- springmvc前端控制器 -->
  <servlet>
    <servlet-name>dispatcherServlet</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <init-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>classpath:springmvc.xml</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>dispatcherServlet</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>
  <!-- 字符编码过滤器 -->
  <filter>
    <filter-name>characterEncodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
      <param-name>encoding</param-name>
      <param-value>utf-8</param-value>
    </init-param>
  </filter>
  <filter-mapping>
    <filter-name>characterEncodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>
</web-app>

```

3.applicationContext.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd
http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd"
       default-autowire="byName">
    <!-- 扫描组件，扫描注解 -->
    <context:component-scan base-package="com.jhly.ssm.service.impl"></context:component-scan>
    <!-- 加载属性文件 -->
    <context:property-placeholder location="classpath:db.properties"></context:property-placeholder>
    <!-- 数据源 -->
    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="${jdbc.driver}"></property>
        <property name="url" value="${jdbc.url}"></property>
        <property name="username" value="${jdbc.username}"></property>
        <property name="password" value="${jdbc.password}"></property>
    </bean>
    <!-- 创建sessionFactory -->
    <bean id="sessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource"></property>
    </bean>
    <!-- 扫描器 -->
    <bean id="mapperScannerConfigurer" class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="sqlSessionFactoryBeanName" value="sessionFactory"></property>
        <property name="basePackage" value="com.jhly.ssm.mapper"></property>
    </bean>
    <!-- 事务管理器 -->
    <bean id="txManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"></property>
    </bean>
    <!-- 声明式事务 -->
    <tx:advice id="transactionInterceptor" transaction-manager="txManager">
        <tx:attributes>
            <tx:method name="ins*"/>
            <tx:method name="del*"/>
            <tx:method name="upd*"/>
            <tx:method name="*" read-only="true"></tx:method>
        </tx:attributes>
    </tx:advice>
    <!-- 配置AOP -->
    <aop:config>
        <aop:pointcut id="tx" expression="execution(* com.jhly.ssm.service.impl.*.*(..))"/>
        <aop:advisor advice-ref="transactionInterceptor" pointcut-ref="tx"></aop:advisor>
    </aop:config>
</beans>
```

4.数据源属性文件

```
jdbc.driver = com.mysql.cj.jdbc.Driver
jdbc.url = jdbc:mysql://localhost:3306/bilibili?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
jdbc.username = jhly
jdbc.password = 123456
```

5.log4j日志

```
#========================== 自定义输出格式说明================================
#%p 输出优先级，即DEBUG，INFO，WARN，ERROR，FATAL
#%r 输出自应用启动到输出该log信息耗费的毫秒数
#%c 输出所属的类目，通常就是所在类的全名
#%t 输出产生该日志事件的线程名
#%n 输出一个回车换行符，Windows平台为“/r/n”，Unix平台为“/n”
#%d 输出日志时间点的日期或时间，默认格式为ISO8601，也可以在其后指定格式，比如：%d{yyy MMM dd HH:mm:ss,SSS}，输出类似：2002年10月18日 22：10：28，921
#%l 输出日志事件的发生位置，包括类目名、发生的线程，以及在代码中的行数。举例：Testlo4.main(TestLog4.java:10)
#==========================================================================
#
#========================== 输出方式说明================================
#Log4j提供的appender有以下几种:
#org.apache.log4j.ConsoleAppender(控制台),
#org.apache.log4j.FileAppender(文件),
#org.apache.log4j.DailyRollingFileAppender(每天产生一个日志文件),
#org.apache.log4j.RollingFileAppender(文件大小到达指定尺寸的时候产生一个新的文件),
#org.apache.log4j.WriterAppender(将日志信息以流格式发送到任意指定的地方)
#==========================================================================
log4j.rootLogger = debug,stdout

log4j.appender.stdout = org.apache.log4j.ConsoleAppender
log4j.appender.stdout.Target = System.out
log4j.appender.stdout.layout = org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern = [%-5p] %d{yyyy-MM-dd HH:mm:ss} method:%m%n

#log4j.appender.D = org.apache.log4j.DailyRollingFileAppender
#log4j.appender.D.File = D://Documents//logs/log.log
#log4j.appender.D.Append = true
#log4j.appender.D.Threshold = DEBUG
#log4j.appender.D.layout = org.apache.log4j.PatternLayout
#log4j.appender.D.layout.ConversionPattern = %-d{yyyy-MM-dd HH:mm:ss}  [ %t:%r ] - [ %p ]  %m%n
#
#log4j.appender.E = org.apache.log4j.DailyRollingFileAppender
#log4j.appender.E.File =D://Documents//logs/error.log
#log4j.appender.E.Append = true
#log4j.appender.E.Threshold = ERROR
#log4j.appender.E.layout = org.apache.log4j.PatternLayout
#log4j.appender.E.layout.ConversionPattern = %-d{yyyy-MM-dd HH:mm:ss}  [ %t:%r ] - [ %p ]  %m%n
```

6.springmvc.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd">
    <!-- 扫描组件，扫描注解 -->
    <context:component-scan base-package="com.jhly.ssm.controller"></context:component-scan>
    <!-- 注解驱动 注册HandlerMapping和HandlerAdapter -->
    <mvc:annotation-driven></mvc:annotation-driven>
    <!-- 设置静态资源 -->
    <mvc:resources mapping="/js/" location="/js/**"></mvc:resources>
    <mvc:resources mapping="/css/" location="/css/**"></mvc:resources>
    <mvc:resources mapping="/images/" location="/images/**"></mvc:resources>
    <!-- 视图解析器 -->
    <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/"></property>
        <property name="suffix" value=".jsp"></property>
    </bean>
</beans>
```

