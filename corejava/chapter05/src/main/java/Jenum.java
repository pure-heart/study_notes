import java.util.Scanner;

import static java.text.DateFormat.MEDIUM;
import static javax.swing.text.html.HTML.Tag.SMALL;

/**
 * @Auther:JHLY
 * @Date:2019/10/6
 * @Description:PACKAGE_NAME
 * @Version:1.0
 */
public class Jenum {
    enum Size {

        SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

        private String abbreviation;

        private Size(String abbreviation){
            this.abbreviation = abbreviation;
        }
        public String getAbbreviation(){
            return abbreviation;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a size:");
        System.out.println(Size.values().toString());
        String input = in.next().toUpperCase();
        Size size =Enum.valueOf(Size.class,input);
        System.out.println("size="+size);
        System.out.println("abbreviation="+size.getAbbreviation());
        if (size == Size.EXTRA_LARGE)
            System.out.println("Good Job -- you paid attention to the _.");
    }
}
