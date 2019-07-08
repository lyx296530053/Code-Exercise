package cn.lyx.web.xml.Web;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class Test01 {
    public static void main(String[] args) throws IOException {
        String s = ClassLoader.getSystemResource("student.xml").getPath();
        Document parse = Jsoup.parse(new File(s),"utf-8");
        Elements name = parse.getElementsByTag("name");
        int size = name.size();
        System.out.println(size);

        Elements id = parse.getElementsByAttribute("id");
        Element itcast = parse.getElementById("itcast");
        Elements elementsByAttributeValue = parse.getElementsByAttributeValue("number", "abc");
        System.out.println(elementsByAttributeValue.html());
    }
}
