package netAdress;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * * 实现TCP 服务器程序
 * * 表示服务器程序的类 java.net.ServerSocket
 * * 构造方法：
 * *     ServerSocket(int port)传递端口号
 * *     很重要的事情：必须要获得客户端的套接字对象Socket
 * *     Socket accept()
 * *
 * * 1,创建服务器ServerSocket对象（指定服务器端口号）
 * * 2，开启服务器了，等待客户端的连接，当客户端连接后，可以获取到连接服务器的客户端Socket对象
 * * 3,给客户端反馈信息
 * * 4,关闭流资源
 *
 * @Auther:JHLY
 * @Date:2019/10/15
 * @Description:netAdress
 * @Version:1.0
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //1,创建服务器ServerSocket对象（指定服务器端口号）
        ServerSocket ss = new ServerSocket(8888);
        //2，开启服务器了，等待客户端的连接，当客户端连接后，可以获取到连接服务器的客户端Socket对象
        Socket s = ss.accept();
        //3,给客户端反馈信息
        /*
         * a,获取客户端的输出流
         * b,在服务端端，通过客户端的输出流写数据给客户端
         */
        //a,获取客户端的输出流
        OutputStream out = s.getOutputStream();
        //b,在服务端端，通过客户端的输出流写数据给客户端
        out.write("你已经连接上了服务器".getBytes());
        //4,关闭流资源
        out.close();
        s.close();
        //ss.close();  服务器流 通常都是不关闭的
    }
}
