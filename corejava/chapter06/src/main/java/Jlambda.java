import javax.swing.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/**
 * @Auther:JHLY
 * @Date:2019/10/7
 * @Description:PACKAGE_NAME
 * @Version:1.0
 */
public class Jlambda {
    public static void main(String[] args) {
       Comparator<String> comparator = (String first, String second)
                ->{
            if (first.length()<second.length()) return -1;
            else if (first.length()>second.length()) return 1;
            else return 0;
        };
       String[] planets = new String[]{"Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune"};
       System.out.println(Arrays.toString(planets));
       System.out.println("Sorted in dictionary order :");
       Arrays.sort(planets);
       System.out.println(Arrays.toString(planets));
       System.out.println("Sorted by length :");
       Arrays.sort(planets,(first,second)->first.length()-second.length());
       System.out.println(Arrays.toString(planets));

        Timer timer =new Timer(1000, event ->
                System.out.println("The time is "+new Date()));
        timer.start();

        JOptionPane.showConfirmDialog(null,"Quit program?");
        System.exit(0);
    }
}
