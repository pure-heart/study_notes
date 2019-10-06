/**
 * @Auther:JHLY
 * @Date:2019/10/6
 * @Description:PACKAGE_NAME
 * @Version:1.0
 */
public class JhashCode {

    public static void main(String[] args) {
        String s = "OK";
        StringBuilder stringBuilder = new StringBuilder(s);
        System.out.println(s.hashCode()+" "+stringBuilder.hashCode());
        String t = "OK";
        StringBuilder stringBuilder1= new StringBuilder(t);
        System.out.println(t.hashCode()+" "+stringBuilder1.hashCode());
    }
}
