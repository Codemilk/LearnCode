import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public class Jsoup_Demo2 {

    public static void main(String[] args) throws IOException {

       String url= Jsoup_Demo2.class.getClassLoader().getResource("student.xml").getPath();
        URL url1=new URL("http://www.baidu.com");
        Document document = Jsoup.parse(url1, 10000);
        System.out.println(document);

    }
}
