import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;


public class Jsoup_Demo3 {

    public static void main(String[] args) throws IOException {

       String url= Jsoup_Demo3.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(url), "utf-8");
//        Element elementById = document.getElementById("1");
//        System.out.println(elementById);
//        Elements elementsByTag = document.getElementsByTag("name");
//        System.out.println(elementsByTag);
//        Elements elementsByAttribute = document.getElementsByAttribute("number");
//        System.out.println(elementsByAttribute);
        Elements elementsByAttributeValue = document.getElementsByAttributeValue("number", "heima_0001");
        System.out.println(elementsByAttributeValue);
    }
}
