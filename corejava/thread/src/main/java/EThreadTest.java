/**
 * @Auther:JHLY
 * @Date:2019/10/12
 * @Description:PACKAGE_NAME
 * @Version:1.0
 */
public class EThreadTest {
    public static void main(String[] args) {
        EThread eThread = new EThread();
        eThread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}
