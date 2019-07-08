package cn.lyx.response;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/test3")
public class Test3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 100;
        int hight = 50;
        BufferedImage bufferedImage = new BufferedImage(width, hight, BufferedImage.TYPE_INT_RGB);
        ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int width = 100;
        int hight = 50;
        BufferedImage bufferedImage = new BufferedImage(width, hight, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(Color.PINK);
        graphics.fillRect(0, 0, width, hight);
        graphics.setColor(Color.BLUE);
        graphics.drawRect(0, 0, width - 1, hight - 1);
        graphics.setColor(Color.RED);
        String str = "QAZWSXEDCRFVTGBYHNUJMIKLOPqazwsxedcrfvtgbyhnujmiklop1234567890";
        Random random = new Random();
        for (int i = 1; i <= 4; i++) {
            int a = random.nextInt(str.length());
            char c = str.charAt(a);
            graphics.drawString(c + "", width / 5 * i, 25);
        }
        graphics.setColor(Color.GREEN);
        for (int i = 1; i <= 7; i++) {
            int q = random.nextInt(width);
            int i1 = random.nextInt(hight);
            int i2 = random.nextInt(width);
            int i3 = random.nextInt(hight);
            graphics.drawLine(q, i1, i2, i3);
        }
        ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
    }
}
