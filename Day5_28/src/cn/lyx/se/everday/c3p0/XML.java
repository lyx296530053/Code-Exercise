package cn.lyx.se.everday.c3p0;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class XML {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        String path = ClassLoader.getSystemResource("student.xml").getPath();
        Document jsoup=Jsoup.parse(new File(path),"utf-8");
//        Elements name = jsoup.getElementsByTag("name");
//        for (Element element : name) {
//            System.out.println( element.html());
//        }
//        Element heima_0001 = jsoup.getElementById("itcast");
//        System.out.println(heima_0001.html());
//        Elements id = jsoup.getElementsByAttribute("number");
//        for (Element element : id) {
//            System.out.println(element.html());
//        }
//        Elements elementsByAttributeValue = jsoup.getElementsByAttributeValue("number", "heima_0001");
//        System.out.println(elementsByAttributeValue.html());
//        System.out.println(elementsByAttributeValue.attr("number"));
//        JXDocument jxDocument=new JXDocument(jsoup);
//        List<JXNode> jxNodes = jxDocument.selN("//student");
//        for (JXNode jxNode : jxNodes) {
//            System.out.println(jxNode);
//        }
//        List<JXNode> jxNodes1 = jxDocument.selN("//student/name");
//        for (JXNode jxNode : jxNodes) {
//            System.out.println(jxNode);
//        }
//        List<JXNode> jxNodes2 = jxDocument.selN("//student/name[@id]");
//        for (JXNode jxNode : jxNodes) {
//            System.out.println(jxNode);
//        }
//        List<JXNode> jxNodes3 = jxDocument.selN("//student/name[@id='666']");
//        for (JXNode jxNode : jxNodes) {
//            System.out.println(jxNode);
//        }
        Elements select = jsoup.select("name[id=\"itcast\"]");
        Elements select1 = select.select("id=\"itcast\"");
//        Elements name = jsoup.select("name[id=\"itcast\"]");
        System.out.println(select1);

    }
}
