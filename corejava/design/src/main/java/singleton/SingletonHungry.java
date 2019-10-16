package singleton;

/**单例模式饿汉式
 * @Auther:JHLY
 * @Date:2019/10/5
 * @Description:singleton
 * @Version:1.0
 */
public class SingletonHungry {
    //类加载时实例化
    private static SingletonHungry singleton = new SingletonHungry();
    //私有化构造函数无法自行实例化
    private SingletonHungry(){};
    public static SingletonHungry getInstance(){
        return singleton;
    }
}
