import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * @Auther:JHLY
 * @Date:2019/10/5
 * @Description:PACKAGE_NAME
 * @Version:1.0
 */
public class JLocalDate {
    public static void main(String[] args) {
        //使用静态工厂方法实例化LocalDate对象
        LocalDate newYearEve = LocalDate.of(1999,12,31);
        int year = newYearEve.getYear();
        int month = newYearEve.getMonthValue();
        int day =newYearEve.getDayOfMonth();
        System.out.println(newYearEve);
        System.out.println("year:"+year+",month:"+month+",day:"+day);

        LocalDate aThousandDaysLater = newYearEve.plusDays(1000);
        year = aThousandDaysLater.getYear();
        month = aThousandDaysLater.getMonthValue();
        day = aThousandDaysLater.getDayOfMonth();
        System.out.println(aThousandDaysLater);
        System.out.println("year:"+year+",month:"+month+",day:"+day);

        new JLocalDate().getCalendar();

    }

    /**
     * 显示当前月的日历
     */
    public void getCalendar(){
        //构造一个日历对象，并用当前时间进行初始化
        LocalDate date = LocalDate.now();
        //获取当前月和日
        int month =date.getMonthValue();
        int today =date.getDayOfMonth();
        //将date设置为这个月的第一天，并得到这一天为星期几
        date = date.minusDays(today-1);
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue();
        //打印表头和第一行空白
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1;i < value; i++){
            System.out.print("    ");
        }
        //打印主体 遍历date中一个月的每一天，如果是星期一就换行
        while (date.getMonthValue() == month){
            System.out.printf("%3d",date.getDayOfMonth());
            if (date.getDayOfMonth() == today){
                System.out.print("*");
            }else {
                System.out.print(" ");
            }
            date =date.plusDays(1);
            if (date.getDayOfWeek().getValue() ==1){
                System.out.println();
            }
        }
        if (date.getDayOfWeek().getValue() !=1){
            System.out.println();
        }
    }
}
