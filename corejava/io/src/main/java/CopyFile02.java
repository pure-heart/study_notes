import java.io.*;

/**使用BufferedReader和BufferedWriter完成文件复制
 * @Auther:JHLY
 * @Date:2019/10/10
 * @Description:PACKAGE_NAME
 * @Version:1.0
 */
public class CopyFile02 {
    public static void main(String[] args) throws IOException {
        //创建输入流对象
        BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\FileTest\\copyfrom02.txt"));//文件不存在会抛出java.io.FileNotFoundException
        //创建输出流对象
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\FileTest\\copyto02.txt"));
        //文本文件复制
        char [] chs=new char[1024];
        int len=0;
        while((len=bufferedReader.read(chs))!=-1) {
            bufferedWriter.write(chs,0,len);
        }
        // 释放资源
        bufferedReader.close();
        bufferedWriter.close();

    }
}
