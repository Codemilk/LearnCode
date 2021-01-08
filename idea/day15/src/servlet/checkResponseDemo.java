package servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkResponseDemo")
public class checkResponseDemo extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     int width=100;
     int height=50;
        response.setHeader("Content-Type", "utf-8");
     //1.创建一对象，在内存中图片(验证码图片对象)
        BufferedImage image=new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
     //2.美化图片
     //2.1填充背景色
     Graphics graphics = image.getGraphics();
     graphics.setColor(Color.pink);
     graphics.fillRect(0, 0, width, height);
     //2.2画边框
     graphics.setColor(Color.blue);
     graphics.drawRect(0, 0, width-1, height-1);
     //2.3写验证码
        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwsyz0123456789";
        //生成随机交表
        Random ran=new Random();
         for (int n=1;n<=4;n++) {

            int i = ran.nextInt(str.length());
            char c = str.charAt(i);
            graphics.drawString(c+"", width/50*i, height/2);
            i=0;

        }
      //2.4画干扰线
        for (int i=0;i<10;i++) {
            int x=ran.nextInt(width);
            int y=ran.nextInt(height);

            int x1=ran.nextInt(height);
            int y1=ran.nextInt(height);
            graphics.setColor(Color.green);
            graphics.drawLine(x, y, x1,y1 );
        }

        //3.将图片输出到页面展示
     ImageIO.write(image, "jpg", response.getOutputStream());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
