import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Auther:JHLY
 * @Date:2019/10/10
 * @Description:PACKAGE_NAME
 * @Version:1.0
 */
public class CopyFile03 {
    public static void main(String[] args) throws IOException {
                 FileInputStream fileInputStream=new FileInputStream("D:\\FileTest\\copyfrom03.txt");
                 FileOutputStream fileOutputStream=new FileOutputStream("D:\\FileTest\\copyto04.txt");
                 int len=0;
                 byte[] buff=new byte[1024];
                 while((len=fileInputStream.read(buff))!=-1) {
                         fileOutputStream.write(buff, 0, len);
                     }
                 fileInputStream.close();
                 fileOutputStream.close();
             }
}
