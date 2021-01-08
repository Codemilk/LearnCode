<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="Com.Beans.testBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>tst</title>
</head>
<body>



<%
//    从application域得到实例
//     application就是servletContext
    ApplicationContext ctx= WebApplicationContextUtils.getWebApplicationContext(application);

    testBean testbean = (testBean)ctx.getBean("testBean");

    testbean.test();
%>
</body>
</html>
