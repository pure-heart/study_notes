import com.jhly.sm.controllor.UserControllor;
import com.jhly.sm.model.User;
import com.jhly.sm.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletRequest;
import java.util.List;

/**
 * @Auther:JHLY
 * @Date:2019/9/27
 * @Description:PACKAGE_NAME
 * @Version:1.0
 */
public class Test {
    @org.junit.Test
    public void test01() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String str:names
             ) {
            System.out.println(str);
        }
        UserService userService = applicationContext.getBean("userService", UserService.class);
        List<User> users = userService.show();
        System.out.println(users);
    }

    @org.junit.Test
    public void test02(){

    }
}
