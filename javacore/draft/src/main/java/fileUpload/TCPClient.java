package fileUpload;

import java.io.*;
import java.net.Socket;

/**文件上传 客户端
 实现步骤：
 1.Socket套接字连接服务器
 2.通过Socket获取字节输出流，写图片
 3.使用自己的流对象，读取图片数据源 FileInputStream
 4.读取图片，使用字节输出流，将图片写到服务器
 5.通过Socket套接字获取字节输入流读取服务器发回来的上传成功
 6.关闭资源
 *
 * public void shutdownOutput()  禁用此Socket的输出流,间接的相当于告知了服务器数据写入完毕
 * @Auther:JHLY
 * @Date:2019/10/15
 * @Description:fileUpload
 * @Version:1.0
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        //2,创建客户端Socket，连接服务器
        Socket socket = new Socket("192.168.1.17", 8888);
        //3,获取Socket流中的输出流，功能：用来把数据写到服务器
        OutputStream out = socket.getOutputStream();
        //4,创建字节输入流，功能：用来读取数据源(图片)的字节
        BufferedInputStream fileIn = new BufferedInputStream(new FileInputStream("C:\\Users\\Jhly\\OneDrive\\图片\\本机照片\\20171002_100915849_iOS.jpg"));
        //5,把图片数据写到Socket的输出流中(把数据传给服务器)
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = fileIn.read(buffer)) != -1){
            //把数据写到Socket的输出流中
            out.write(buffer, 0, len);
        }
        //6,客户端发送数据完毕，结束Socket输出流的写入操作，告知服务器端
        socket.shutdownOutput();

        //-----------------反馈信息---------------------
        //12,获取Socket的输入流  作用： 读反馈信息
        InputStream in = socket.getInputStream();
        //13,读反馈信息
        byte[] info = new byte[1024];
        //把反馈信息存储到info数组中，并记录字节个数
        int length = in.read(info);
        //显示反馈结果
        System.out.println( new String(info, 0, length) );

        //关闭流
        in.close();
        fileIn.close();
        out.close();
        socket.close();
    }
}
