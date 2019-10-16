/**
 * @Auther:JHLY
 * @Date:2019/10/12
 * @Description:PACKAGE_NAME
 * @Version:1.0
 */
public class JThread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("我的线程2：正在执行！"+i);
        }
    }
}
