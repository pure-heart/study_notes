package netAdress;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 发送端
 * 1,创建DatagramPacket对象，封装数据，接收的地址和端口
 * 2,创建DatagramSocket对象
 * 3,调用DatagramSocket中的send方法，发送数据包
 * 4，关闭资源DatagramSocket
 *
 * @Auther:JHLY
 * @Date:2019/10/15
 * @Description:netAdress
 * @Version:1.0
 */
public class UDPSend {
    public static void main(String[] args) throws IOException {
        //1,创建DatagramSocket对象
        DatagramSocket sendSocket = new DatagramSocket();
        //2，创建DatagramPacket对象，并封装数据
        //public DatagramPacket(byte[] buf, int length, InetAddress address,  int port)
        //构造数据报包，用来将长度为 length 的包发送到指定主机上的指定端口号。
        byte[] buffer = "hello,UDP".getBytes();
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("192.168.75.58"), 12306);
        //3，发送数据
        //public void send(DatagramPacket p) 从此套接字发送数据报包
        sendSocket.send(dp);
        //4，释放流资源
        sendSocket.close();
    }
}
