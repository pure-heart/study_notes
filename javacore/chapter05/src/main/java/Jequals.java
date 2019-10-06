import java.time.LocalDate;

/**
 * @Auther:JHLY
 * @Date:2019/10/6
 * @Description:PACKAGE_NAME
 * @Version:1.0
 */
public class Jequals {

    private String name;
    private int salary;
    private LocalDate hireDay;

    public Jequals(String name,int salary,LocalDate hireDay){
        this.name = name;
        this.salary = salary;
        this.hireDay = hireDay;
    }

    public Jequals(){}

    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        Jequals other = (Jequals) otherObject;
        return name.equals(other.name) && salary == other.salary && hireDay.equals(other.hireDay);
    }

    public static void main(String[] args) {
       System.out.println(new Jequals("",14,LocalDate.now()).equals(new Jequals("",14,LocalDate.now())));
    }

}
