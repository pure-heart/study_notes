package singleton;

/**测试两种单例类
 * @Auther:JHLY
 * @Date:2019/10/5
 * @Description:singleton
 * @Version:1.0
 */
public class Test {
    public static void main(String[] args) {
        SingletonHungry singletonHungry1 = SingletonHungry.getInstance();
        SingletonHungry singletonHungry2 = SingletonHungry.getInstance();
        SingletonLazy singletonLazy1 =SingletonLazy.getInstance();
        SingletonLazy singletonLazy2 =SingletonLazy.getInstance();
        System.out.println("singletonHungry:");
        System.out.println(singletonHungry1==singletonHungry2);
        System.out.println("singletonLazy:");
        System.out.println(singletonLazy1==singletonLazy2);
    }
}
