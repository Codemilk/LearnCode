<%@ page contentType="text/html;charset=GBK" language="java" isErrorPage="true"  %>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
¹þ¹þ<br>
yes<br>
ModelAndView<br>
Time:${requestScope.time}<br>

MapAndModel<br>
names£º${requestScope.names}<br>

SessionTest<br>
requestUser£º${requestScope.user}<br>
SessionUser:${sessionScope.user}<br>

requestname£º${requestScope.name}<br>
Sessionname:${sessionScope.name}<br>

@ModelAttribute<br>
User user£º${requestScope.user}<br>
abc user:${requestScope.abc}<br>

<%--viewTest<br>--%>
<%--<fmt:message key="i18n.username"></fmt:message><br>--%>
<%--<fmt:message key="i18n.password"></fmt:message><br>--%>
</body>
</html>
