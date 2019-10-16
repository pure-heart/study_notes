/**使用线程的内匿名内部类方式，可以方便的实现每个线程执行不同的线程任务操作。
 * @Auther:JHLY
 * @Date:2019/10/12
 * @Description:PACKAGE_NAME
 * @Version:1.0
 */
public class JThread3 {
    public static void main(String[] args) {
        /**方式1：创建线程对象时，直接重写Thread类中的run方法 */
        //lambda表达式形式
        new Thread(() -> {
            for (int x = 0; x < 40; x++) {
                System.out.println(Thread.currentThread().getName() + "...X...." + x);
            }
        },"线程一").start();

        new Thread("线程二") {
            public void run() {
                for (int x = 0; x < 40; x++) {
                    System.out.println(Thread.currentThread().getName() + "...X...." + x);
                }
            }
        }.start();

        /**方式2：使用匿名内部类的方式实现Runnable接口，重新Runnable接口中的run方法 */
        //lambda表达式形式
        Runnable runnable1 = () -> {
            for (int x = 0; x < 40; x++) {
                System.out.println(Thread.currentThread().getName() + "...Y...." + x);
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                for (int x = 0; x < 40; x++) {
                    System.out.println(Thread.currentThread().getName() + "...Y...." + x);
                }
            }
        };
        new Thread(runnable1).start();
        new Thread(runnable2,"").start();
    }
}
