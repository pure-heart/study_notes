/**
 * @Auther:JHLY
 * @Date:2019/10/7
 * @Description:PACKAGE_NAME
 * @Version:1.0
 */
public class StringEqualTest {
    /**
     * 1. String对象的intern方法会得到字符串对象在常量池中对应的版本的引用（如果常量池中有一个字符串与String对象的equals结果是true），
     * 如果常量池中没有对应的字符串，则该字符串将被添加到常量池中，然后返回常量池中字符串的引用；
     * 2. 字符串的+操作其本质是创建了StringBuilder对象进行append操作，然后将拼接后的StringBuilder对象用toString方法处理成String对象，
     * 这一点可以用javap -c StringEqualTest.class命令获得class文件对应的JVM字节码指令就可以看出来。
     * @param args
     */
    public static void main(String[] args) {
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2); //false
        System.out.println(s1 == s5); //true
        System.out.println(s1 == s6); //false
        System.out.println(s1 == s6.intern()); //true
        System.out.println(s2 == s2.intern()); //false

        System.out.println("===============================================================================");

        String good = new StringBuilder("go").append("od").toString();
        String java = new StringBuilder("ja").append("va").toString();

        System.out.println(good.intern() == good);
        System.out.println(java.intern() == java);

    }
}
