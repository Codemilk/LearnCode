import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.IOException;


public class Jsoup_Demo4 {

    public static void main(String[] args) throws IOException {

       String url= Jsoup_Demo4.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(url), "utf-8");
//        Element elementById = document.getElementById("1");
//        System.out.println(elementById);
        Elements elementsByTag = document.getElementsByTag("student");
//        System.out.println(elementsByTag);
//        Elements elementsByAttribute = document.getElementsByAttribute("number");
//        System.out.println(elementsByAttribute);
//        Elements elementsByAttributeValue = document.getElementsByAttributeValue("number", "heima_0001");
//        System.out.println(elementsByAttributeValue);
        Elements elementsByTag1 = elementsByTag.get(0).getElementsByTag("name");
//        System.out.println(elementsByTag1.html());
//        System.out.println(elementsByTag1.text());
        System.out.println(elementsByTag.attr("number"));
    }
}
