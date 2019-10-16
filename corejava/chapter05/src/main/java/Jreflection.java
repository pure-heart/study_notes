import java.util.Random;

/**
 * @Auther:JHLY
 * @Date:2019/10/6
 * @Description:PACKAGE_NAME
 * @Version:1.0
 */
public class Jreflection {



    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Employee e =new Employee();
        Class cl1 = e.getClass();
        System.out.println(cl1.getName());

        String className = "java.util.Random";
        Object cl2 = Class.forName(className).newInstance();

        Class cl3 = Random.class;
    }
}
