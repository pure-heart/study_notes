package netAdress;

import java.net.InetAddress;

/**
 * @Auther:JHLY
 * @Date:2019/10/15
 * @Description:netAdress
 * @Version:1.0
 */
public class Example01 {
    public static void main(String[] args) throws Exception {
        InetAddress local = InetAddress.getLocalHost();
        InetAddress remote = InetAddress.getByName("www.oracle.cn");
        System.out.println("本机的主机名："+local);
        System.out.println("本机的IP地址：" + local.getHostAddress());
        System.out.println("oracle的IP地址：" + remote.getHostAddress());
        System.out.println("oracle的主机名为：" + remote.getHostName());
    }

}
