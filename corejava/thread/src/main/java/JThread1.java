/**
 * @Auther:JHLY
 * @Date:2019/10/11
 * @Description:PACKAGE_NAME
 * @Version:1.0
 */
public class JThread1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"正在执行！"+i);
        }
    }

}
