package proxy;

import java.lang.reflect.Proxy;

/**相对于静态代理，动态代理大大减少了我们的开发任务，同时减少了对业务接口的依赖，降低了耦合度
 * JDK实现动态代理需要实现类通过接口定义业务方法，对于没有接口的类，如何实现动态代理呢，这就需要CGLib了
 * @Auther:JHLY
 * @Date:2019/10/7
 * @Description:proxy
 * @Version:1.0
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        BuyHouse buyHouse = new BuyHouseImpl();
        /**
         * Proxy.newProxyInstance()方法接受三个参数：
         *
         *     ClassLoader loader:指定当前目标对象使用的类加载器,获取加载器的方法是固定的
         *     Class<?>[] interfaces:指定目标对象实现的接口的类型,使用泛型方式确认类型
         *     InvocationHandler:指定动态处理器，执行目标对象的方法时,会触发事件处理器的方法
         */
        BuyHouse proxyInstance = (BuyHouse)Proxy.newProxyInstance(BuyHouse.class.getClassLoader(),
                new Class[]{BuyHouse.class}, new DynamicProxyHandler(buyHouse));
        proxyInstance.buyHouse();

        String s;
    }
}
