package cn.idcast.web.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

//敏感词汇过滤器
@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {
    private List<String> list=new ArrayList();//敏感文字集合

    public void init(FilterConfig config) throws ServletException {
    //1.加载文件
       try {
           ServletContext servletContext = config.getServletContext();
           String realPath = servletContext.getRealPath("/WEB-INF/classes/SensitiveWords.txt");
           BufferedReader  br=new BufferedReader(new FileReader(realPath));

//           BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("SensitiveWords.txt"),"UTF-8"));

           String line=null;

           while((line = br.readLine())!=null){
                  list.add(line);
           }
       }catch (Exception e){
           e.printStackTrace();
       }
        System.out.println(list);
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1.创建代理对象，增强getParameter
        HttpServletRequest request= (HttpServletRequest) req;

         ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
               //增强getParameter的
                if(method.getName().equals("getParameter")){
                    //增强返回值，过滤
                    //获取返回值
                    String s = (String) method.invoke(req, args);
                    if(s!=null){
                        for(String str : list){
                                   if(s.equals(str)){
                                       s=s.replaceAll(str,"**");
                                   }
                        }

                    }
                    return s;
                }else{
                    return method.invoke(req,args);
                }

            }
        });
        chain.doFilter(proxy_req, resp);
    }

    public void destroy() {

    }


}
