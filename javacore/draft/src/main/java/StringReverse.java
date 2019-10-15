/**用递归实现字符串反转
 * @Auther:JHLY
 * @Date:2019/10/8
 * @Description:PACKAGE_NAME
 * @Version:1.0
 */
public class StringReverse {
    public static String reverse(String originStr) {
        if(originStr == null || originStr.length() <= 1)
            return originStr;
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println(reverse("string"));
    }
}
