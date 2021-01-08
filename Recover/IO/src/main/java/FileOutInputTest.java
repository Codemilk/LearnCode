import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 测试FileOutputStream 和 FileInputStream
 *
 * 结论：
 *   1.对于文本文件（.txt、.java、.c、.c++.......），使用字符流处理流
 *   2.对于非文本文件（.jpg、.mp3、.avi、.ppt......），使用字节流处理流
 *
 * @author lenovo
 */
public class FileOutInputTest {
    /**通过文件字流对文本文件操作*/
    @Test
    public void testFileInputTest(){
        File file = new File("src/main/resources/hello.txt");


        FileInputStream fileInputStream=null;
        try {
            //建立流
            fileInputStream = new FileInputStream(file);

            byte[] bytes = new byte[5];
            //读取数据
            //记录每次读取的字节的个数
            int len;
            while ((len=fileInputStream.read(bytes))!=-1){

                /**从0索引开始解码，len表示长度,用作字节数组解码,这里复习一下，在英文里面英文字母对应的Ascall码对应的值字节可以存下，所以可以说一个
                 * 字节就是一个英文字母，但是中文就不可以，因为不同的编码形式，中文所占的字节数不一样，在utf-8中,中文站三个字节
                 * */
                String s = new String(bytes, 0, len);
                
                System.out.print(s);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**通过文件字流对非文本文件操作*/
    @Test
    public void testFileInputTest1(){

        File test = new File("src/main/resources/test.png");
        File over = new File("src/main/resources/over.png");

        FileInputStream fileInputStream=null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream= new FileInputStream(test);
            fileOutputStream=new FileOutputStream(over);

            byte[] b = new byte[1024];
            int len;
            while((len=fileInputStream.read(b))!=-1){

                fileOutputStream.write(b,0,len);

            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
