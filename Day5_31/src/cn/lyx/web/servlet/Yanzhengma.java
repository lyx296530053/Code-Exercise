package cn.lyx.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/yanzheng")
public class Yanzhengma extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 100;
        int high = 50;
        BufferedImage bufferedImage = new BufferedImage(width, high, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, width, high);
        String str = "QAZWSXEDCRFVTGBYHNUJMIKLOPqazwsxedcrfvtgbyhnujmiklop1234567890";
        Random random = new Random();
        graphics.setColor(Color.RED);
StringBuilder sb=new StringBuilder();
        for (int i = 1; i < 5; i++) {
            int i1 = random.nextInt(str.length());
            char c = str.charAt(i1);
sb.append(c);
            graphics.drawString(c + "", width / 5 * i, 25);
        }
        graphics.setColor(Color.BLACK);
        for (int i = 0; i < 7; i++) {
            int i1 = random.nextInt(width);
            int i2 = random.nextInt(high);
            int i3 = random.nextInt(width);
            int i4 = random.nextInt(high);
            graphics.drawLine(i1,i2,i3,i4);
        }
        HttpSession session = request.getSession();
        session.setAttribute("yan",sb.toString());
        ImageIO.write(bufferedImage,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
