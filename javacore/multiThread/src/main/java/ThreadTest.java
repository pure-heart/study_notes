/**
 * @Auther:JHLY
 * @Date:2019/10/12
 * @Description:PACKAGE_NAME
 * @Version:1.0
 */
public class ThreadTest {

        public static void main(String[] args) {
            JThread1 jThread1 = new JThread1();
            JThread2 jThread2 = new JThread2();
            Thread thread1 = new Thread(jThread1,"线程一");
            Thread thread2 = new Thread(jThread2);
            thread1.start();
            thread2.start();
            for (int i = 0; i < 10; i++) {
                System.out.println("main线程正在执行！" + i);
            }
        }
}
