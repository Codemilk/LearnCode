import com.sun.org.apache.bcel.internal.classfile.Code;
import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 一、流的分类
 * 1.操作数据单位：字符，字节流
 * 2.数据流向：输入输出
 * 3.角色：节点，处理流
 * <p>
 * <p>
 * 二、体系结构
 * 四个抽象基类         节点流(直接对文件操作)         缓冲流（处理流）
 * InputStream        FileInputStream            BufferedInputStream
 * OutputStream       FileOutputStream           BufferedOutputStream
 * Reader             FileReader                 BufferedReader
 * Writer             FileWriter                 BufferedWriter
 *
 * @author lenovo
 */
public class FileReaderWriterTest {

    /**
     * 使用相对路径，但是起始点在当前方法也就是当前的模块，如果在main方法中，那么起点就是在项目根节点
     */
    @Test
    public void testFileReader() {
        //1.读入文件
        File file = new File("src/main/resources/hello.txt");

        FileReader fileReader = null;
        try {
            //2.提供具体的流
            fileReader = new FileReader(file);

            //3.数据的读入
            //返回的是字符的对应数字，通过read往下读，知道返回-1结束
            int data;

            while ((data = fileReader.read()) != -1) {

                System.out.println((char) data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {//4.流的关闭
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /**
     * 对read()操作升级:使用read的重载方法
     * */
    @Test
    public void testFileReader2(){

        File file = new File("src/main/resources/hello.txt");
        FileReader fr=null;
        try {

        fr = new FileReader(file);

        char [] array =new char[5];
        int e;

        //read(array)表示读入操作 传入参数为char型数组:返回每次读入数组中的个数,整个函数表示每次读入5个字符就进入一次循环，不足五个就有几个读几个
        while ((e=fr.read(array))!=-1){

            System.out.println("循环开始");
            //这里不可以是i<array.length，因为当最后一次遍历不足五个，就会使用上一个数组的是，说白了就是覆盖的一个过程，前几个你有值不去覆盖，后面你没法覆盖
            for (int i = 0; i <e;i++){
                System.out.println(array[i]);
            }
        }

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /**
     * 说明：
     *  1. 输出操作，对应的File可以不存在，若不存在，在输出的过程自己创建
     *              如果存在那么就是，文件的选择覆盖：创建流的是否在构造器参数为new FileWriter(file,false)和new FileWriter(file)表示覆盖
     *                                          创建流的是否在构造器参数为new FileWriter(file,true)表示接着文件追加
     * */
    @Test
    public void testFiLeWriter() throws IOException {
        //1.准备文件
        File file = new File("src/main/resources/hello1.txt");

        //2.准备流,提供FileWriter的对象，用于数据的写出，就是写入到这个文件
        FileWriter fileWriter = new FileWriter(file,true);

        //3.写出
        fileWriter.write("I have a dream！");
        fileWriter.write("Me too！");

        //4.流的关闭
        fileWriter.close();
    }

    /**
     * 通过 FileReader 和  FileWriter来进行文本复制,以后在程序中大部分在网络上运行,所以要自己处理,不能让程序直接停下来
     * */

    @Test
    public void testFiLeWriterAndFileReader() throws IOException {

        FileReader fileReader =null;
        FileWriter fileWriter =null;
        try {
            // 创建文件
            File CopyFile = new File("src/main/resources/CopyFile.txt");
            File PasteFile=new File("src/main/resources/PasteFile.txt");

           fileReader = new FileReader(CopyFile);
           fileWriter = new FileWriter(PasteFile,true);

            char[] array=new char[5];

            int i=0;

            while((i=fileReader.read(array))!=-1){

                fileWriter.append(String.valueOf(array));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            try {
                if (fileWriter != null) {

                fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fileReader != null) {

                fileReader.close();
                }
            }
        }

    }
}

