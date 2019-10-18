package fileUpload;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP上传服务器
1.    ServerSocket套接字对象，监听端口8888
2.    方法accept（）获取客户端的连接对象
3.    客户端连接对象获取字节输入流，读取客户端发送图片
4.    创建File对象，绑定上传文件夹
判断文件夹存在，不存在，再创建文件夹
5.    创建字节输出流，数据目的File对象所在文件夹
6.    字节读取图片，字节流将图片写入到目的文件夹中
7.    将上传成功返回客户端
8.    关闭资源
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //1,创建服务器，等待客户端连接
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket clientSocket = serverSocket.accept();
        //显示哪个客户端Socket连接上了服务器
        InetAddress ipObject = clientSocket.getInetAddress();//得到IP地址对象
        String ip = ipObject.getHostAddress(); //得到IP地址字符串
        System.out.println("小样，抓到你了，连接我！！" + "IP:" + ip);

        //7,获取Socket的输入流
        InputStream in = clientSocket.getInputStream();
        //8,创建目的地的字节输出流
        BufferedOutputStream fileOut = new BufferedOutputStream(new FileOutputStream("D:\\test.jpg"));
        //9,把Socket输入流中的数据，写入目的地的字节输出流中
        byte[] buffer = new byte[1024];
        int len = -1;
        while((len = in.read(buffer)) != -1){
            //写入目的地的字节输出流中
            fileOut.write(buffer, 0, len);
        }

        //-----------------反馈信息---------------------
        //10,获取Socket的输出流, 作用：写反馈信息给客户端
        OutputStream out = clientSocket.getOutputStream();
        //11,写反馈信息给客户端
        out.write("图片上传成功".getBytes());

        out.close();
        fileOut.close();
        in.close();
        clientSocket.close();
        //serverSocket.close();
    }
}
