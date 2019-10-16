/**
 * @Auther:JHLY
 * @Date:2019/10/6
 * @Description:PACKAGE_NAME
 * @Version:1.0
 */
public class JtoString {
    @Override
    public String toString() {
        return "重写";
    }

    public static void main(String[] args) {
        System.out.println(new JtoString().toString());
    }
}
