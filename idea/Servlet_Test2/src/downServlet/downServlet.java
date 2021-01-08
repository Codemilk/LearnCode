package downServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

@WebServlet( "/downServlet")
public class downServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        String filename = request.getParameter("filename");
        //使用字符输入流加载进内存
        String realPath = servletContext.getRealPath("/img/"+filename);
        System.out.println(realPath);
       //字节流关联
        FileInputStream  fileInputStream=new FileInputStream(realPath);
        //设置response响应头
        //1.响应头类型
        String mimeType = servletContext.getMimeType(filename);//获取mime类型
        response.setHeader("content-type", mimeType);
        //解决中文文件名问题
        //1.获取user-agent
        String header = request.getHeader("user-agent");
        //2.使用工具类编码文件为即可
        String fileName = DownLoadUtils.getFileName(header, filename);
        //2.设置响应头
        response.setHeader("content-disposition", "attachment;filename="+fileName);

        //将输入流数据写道输出流中
        ServletOutputStream outputStream = response.getOutputStream();
        byte [] a=new byte[2048*4];
        int len=0;
        while ((len=fileInputStream.read(a))!=-1) {
            outputStream.write(a,0,len);
        }
        //       response.setHeader("content-disposition:","attachment filename=xxx");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.doPost(request, response);
    }
}
