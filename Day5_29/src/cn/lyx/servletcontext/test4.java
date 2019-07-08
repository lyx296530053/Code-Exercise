package cn.lyx.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@WebServlet("/contexttest4")
public class test4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename = req.getParameter("filename");
        ServletContext context = this.getServletContext();
        String realPath = context.getRealPath("/img/" + filename);
        String mimeType = context.getMimeType(filename);
        String header = req.getHeader("user-agent");
        String fileName = DownLoadUtils.getFileName(header, filename);
        resp.setHeader("Content-Type", mimeType);
        resp.setHeader("content-disposition", "attachment;filename=" + filename);
        FileChannel channel = new FileInputStream(realPath).getChannel();
        ServletOutputStream outputStream = resp.getOutputStream();
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        while (true) {
            int read = channel.read(byteBuffer);
            if (read == -1) {
                break;
            }
            byteBuffer.flip();
            byte[] arr = new byte[byteBuffer.limit()];
            for (int i = 0; i < byteBuffer.limit(); i++) {
                arr[i] = byteBuffer.get(i);
            }
            outputStream.write(arr);
            byteBuffer.clear();
        }
    }
}
