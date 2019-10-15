package netAdress;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 *  * 实现TCP 客户端，连接到服务器
 *  * 和服务器实现数据交换
 *  * 实现TCP客户端程序的类 java.net.Soket
 *  * 构造方法
 *  *    Socket(String host,int port) 传递服务器IP和端口号
 *  *    注意：构造方法只要运行，就会和服务器进行连接，连接失败，抛出异常
 *
 *  *    OutputStream   getOutputStream() 返回套接字的输出流
 *  *    作用：将数据输出，输出到服务器
 *  *    InputStream   getInputStream() 返回套接字的输入流
 *  *    作用：从服务器端读取数据
 *
 *  *    客户端服务器数据交换，必须使用套接字对象Socket中的获取的IO流，自己new流，不行
 *
 *  * 1，创建客户端Socket对象,（指定要连接的服务器地址与端口号）
 *  * 2,获取服务器端的反馈回来的信息
 *  * 3,关闭流资源
 * @Auther:JHLY
 * @Date:2019/10/15
 * @Description:netAdress
 * @Version:1.0
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        //1，创建客户端Socket对象,（指定要连接的服务器地址与端口号）
        Socket s = new Socket("192.168.1.17", 8888);
        //2,获取服务器端的反馈回来的信息
        InputStream in = s.getInputStream();
        //获取获取流中的数据
        byte[] buffer = new byte[1024];
        //把流中的数据存储到数组中，并记录读取字节的个数
        int length = in.read(buffer);
        //显示数据
        System.out.println( new String(buffer, 0 , length) );
        //3,关闭流资源
        in.close();
        s.close();
    }
}
