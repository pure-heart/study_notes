/**
 * @Auther:JHLY
 * @Date:2019/10/9
 * @Description:PACKAGE_NAME
 * @Version:1.0
 */
class Annoyance extends Exception {}
class Sneeze extends Annoyance {}
public class ExceptionTest {


    static class Human {

        public static void main(String[] args)
                throws Exception {
            try {
                try {
                    throw new Sneeze();
                }
                catch ( Annoyance a ) {
                    System.out.println("Caught Annoyance");
                    throw a;
                }
            }
            catch ( Sneeze s ) {
                System.out.println("Caught Sneeze");
                return ;
            }
            finally {
                System.out.println("Hello World!");
            }
        }
    }
}
