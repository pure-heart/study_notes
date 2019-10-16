/**
 * @Auther:JHLY
 * @Date:2019/10/12
 * @Description:PACKAGE_NAME
 * @Version:1.0
 */
public class EThread extends Thread{

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {

            System.out.println(getName()+"：正在执行！"+i);

        }
    }
}
