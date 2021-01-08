import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.IOException;


public class Jsoup_Demo1 {

    public static void main(String[] args) throws IOException {
        //获取Document对象，根据xml文档获取
        //获取student.xml的path
       String url= Jsoup_Demo1.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(url), "UTF-8");
        //解析xml文档，加载文档进内存，获取dom树
        Elements name = document.getElementsByTag("name");
        System.out.println( name.get(0));;

    }
}
