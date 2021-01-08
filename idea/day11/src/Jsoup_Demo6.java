import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class Jsoup_Demo6 {

    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        //获取student.xml的path
        String url= Jsoup_Demo6.class.getClassLoader().getResource("student.xml").getPath();
        //获取Document对象
        Document document = Jsoup.parse(new File(url), "utf-8");
        //3.根据document创建JXDocument对象
        JXDocument jxDocument=new JXDocument(document);
        //结合XPath语法查询
        //查询所有的student的标签
        List<JXNode> jxNodes = jxDocument.selN("//student");
        for (JXNode jxNode:jxNodes){
            System.out.println(jxNode);
        }
        System.out.println("----------------------------------------");
        //查询所有的student标签下的name标签
        List<JXNode> jxNodes1 = jxDocument.selN("//student/name");
        for (JXNode jxNode:jxNodes1){
            System.out.println(jxNode);
        }
        System.out.println("----------------------------------------");

        //查询所有的student标签下带有id属性的name标签
        List<JXNode> jxNodes2 = jxDocument.selN("//student/name[@id]");
        for (JXNode jx:jxNodes2){
            System.out.println(jx);
        }
        //查询所有的student标签下带有id属性的name标签，并且id属性值为2
        List<JXNode> jxNodes3 = jxDocument.selN("//student/name[@id='2']");
        System.out.println(jxNodes3);


    }
}
