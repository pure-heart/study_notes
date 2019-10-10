import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**使用FileReader和FileWriter类完成文本文件复制
 * @Auther:JHLY
 * @Date:2019/10/10
 * @Description:PACKAGE_NAME
 * @Version:1.0
 */
public class CopyFile01 {
    public static void main(String[] args) throws IOException {
        //创建输入流对象
        FileReader fileReader = new FileReader("D:\\FileTest\\copyfrom01.txt");//文件不存在会抛出java.io.FileNotFoundException
        //创建输出流对象
        /** 创建输出流做的工作：
         1、调用系统资源创建了一个文件
         2、创建输出流对象
         3、把输出流对象指向文件
         */
        FileWriter fileWriter = new FileWriter("D:\\FileTest\\copyto01.txt");

        //文本文件复制，一次读一个字符
        method1(fileReader,fileWriter);
        //文本文件复制，一次读一个字符数组
        method2(fileReader,fileWriter);

        fileReader.close();
        fileWriter.close();
    }

    public static void method1(FileReader fr, FileWriter fw) throws IOException {
        int ch;
        while ((ch = fr.read()) != -1){ //读数据
            fw.write(ch); //写数据
        }
        fw.flush();
    }

    public static void method2(FileReader fr, FileWriter fw) throws IOException {
        char chs[]=new char[1024];
        int len=0;
        while((len=fr.read(chs))!=-1) {//读数据
            fw.write(chs,0,len);//写数据
        }
        fw.flush();
    }
}
