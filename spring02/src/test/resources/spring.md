## Spring常用注解 ##
<hr>
#### 用于创建对象的注解 ####
等同于bean标签<br>
@Component @Service @Controller @Repository
<hr>
#### 用于注入对象的注解 ####
@Resource
 java中的注解 默认按byName注入 <br>
@AutoWired spring中的注解 默认按byType注入
<hr>
@Value 
@Pointcut 
@Aspect 
@Before 
@After 
@AfterReturning 
@AfterThrowing
@Around
