<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    boolean flag=false;
    Cookie[] cookies = request.getCookies();
    if(cookies!=null&&cookies.length>0){
        for (Cookie c:cookies){
            String name = c.getName();
            if("lasttime".equals(name)){
                Date date=new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年mm月dd日 HH:mm:ss");                    //响应数据
                String format = simpleDateFormat.format(date);
                //因为在tomcat8后虽然已经支持中文，但是特殊字符还要编码
                   System.out.println("编码前"+format);
        //编码工具
        String encode = URLEncoder.encode(format, "utf-8");
        System.out.println("编码后"+encode);
        c.setValue(encode);
        System.out.println();
        c.setMaxAge(60*60*24*30);
        flag=true;
        String value=c.getValue();
        response.addCookie(c);
        //url解码
        value= URLDecoder.decode(value, "utf-8");
        out.write("欢迎回来"+value);
        break;
    }
    }

    }

    if (cookies==null||cookies.length==0||flag==false){
    Date date=new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年mm月dd日 HH：mm：ss");                    //响应数据
    String encode = URLEncoder.encode(simpleDateFormat.format(date), "utf-8");
    Cookie cookie = new Cookie("lasttime",encode);
    cookie.setMaxAge(60*60*24*30);
    String value= URLDecoder.decode(cookie.getValue(), "utf-8");
    response.addCookie(cookie);
    out.write("欢迎你首次访问"+value);
    }

%>
</body>
</html>
