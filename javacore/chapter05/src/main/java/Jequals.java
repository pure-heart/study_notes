import java.time.LocalDate;

/**首先equals方法必须满足自反性（x.equals(x)必须返回true）、对称性（x.equals(y)返回true时，y.equals(x)也必须返回true）、
 *                      传递性（x.equals(y)和y.equals(z)都返回true时，x.equals(z)也必须返回true）
 *                      和一致性（当x和y引用的对象信息没有被修改时，多次调用x.equals(y)应该得到同样的返回值），
 *                      而且对于任何非null值的引用x，x.equals(null)必须返回false。
 * 实现高质量的equals方法的诀窍包括：
 * 1. 使用==操作符检查"参数是否为这个对象的引用"；
 * 2. 使用instanceof操作符检查"参数是否为正确的类型"；
 * 3. 对于类中的关键属性，检查参数传入对象的属性是否与之相匹配；
 * 4. 编写完equals方法后，问自己它是否满足对称性、传递性、一致性；
 * 5. 重写equals时总是要重写hashCode；
 * 6. 不要将equals方法参数中的Object对象替换为其他的类型，在重写时不要忘掉@Override注解。
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
