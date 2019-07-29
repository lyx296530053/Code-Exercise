package cn.lyx.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@WebServlet("/test2")
public class Test2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String realPath = this.getServletContext().getRealPath("/111.jpg");
        String mimeType = this.getServletContext().getMimeType("/111.jpg");
        FileInputStream stream=new FileInputStream(realPath);
        FileChannel streamChannel = stream.getChannel();
        ByteBuffer buffer=ByteBuffer.allocate(2048);
        ServletOutputStream outputStream = response.getOutputStream();
        response.setHeader("content-type",mimeType);
        response.setHeader("content-disposition","attachment;filename=111.jpg");
        while (true){
            int read = streamChannel.read(buffer);
            if(read==-1){
                break;
            }
            int limit = buffer.limit();
            byte[] arr=new byte[2048];
            for (int i = 0; i < limit; i++) {
               arr[i]= buffer.get(i);
            }
            outputStream.write(arr);
            buffer.clear();
        }
    }
}
