import com.jhly.springDemo.model.AopDemo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @Auther:JHLY
 * @Date:2019/9/28
 * @Description:PACKAGE_NAME
 * @Version:1.0
 */
@ComponentScan
public class TestSpring {
    @Test
    public void test01() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));
        AopDemo aopDemo = applicationContext.getBean("aopDemo", AopDemo.class);
        aopDemo.demo1();
    }
}
