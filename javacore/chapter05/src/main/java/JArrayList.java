import java.util.ArrayList;

/**
 * @Auther:JHLY
 * @Date:2019/10/6
 * @Description:PACKAGE_NAME
 * @Version:1.0
 */
public class JArrayList {

    public static void main(String[] args) {
        //泛型数组列表
        ArrayList<Employee> staff = new ArrayList<>();

        staff.add(new Employee("Carl Cracker",75000,1987,12,15));
        staff.add(new Employee("Harry Hacker",50000,1989,10,1));
        staff.add(new Employee("Tony Tester",40000,1990,3,15));
        //分配数组列表
        staff.ensureCapacity(100);
        //数组元素数目
        staff.size();
        //调整存储区域大小为当前元素所需要的存储空间
        staff.trimToSize();
        //设值
        staff.set(0,new Employee("Carl Snow",75000,1987,12,15));
        //取值
        Employee e = staff.get(1);
        //数组元素拷贝到数组
        staff.toArray();
        //带索引添加
        staff.add(1,new Employee("Carl John",75000,1988,12,15));
        //删除
        staff.remove(2);
        for (Employee employee : staff) {
            System.out.println(e);
        }
    }
}
