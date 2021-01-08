import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.select.Selector;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.IOException;


public class Jsoup_Demo5 {

    public static void main(String[] args) throws IOException {

       String url= Jsoup_Demo5.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(url), "utf-8");
        //标签选择器
//        Elements elements = document.select("name");
//        System.out.println(elements);
//        查询id值为1的元素
//        Elements elements1 = document.select("#1");
//        System.out.println(elements1);
          Elements heima_0001 = document.select("student[number='heima_0001']>age");
          System.out.println(heima_0001);

//        Elements elements = heima_0001.select("age");
//        System.out.println(elements);
    }
}
