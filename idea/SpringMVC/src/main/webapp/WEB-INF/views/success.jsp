<%@ page contentType="text/html;charset=GBK" language="java" isErrorPage="true"  %>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
����<br>
yes<br>
ModelAndView<br>
Time:${requestScope.time}<br>

MapAndModel<br>
names��${requestScope.names}<br>

SessionTest<br>
requestUser��${requestScope.user}<br>
SessionUser:${sessionScope.user}<br>

requestname��${requestScope.name}<br>
Sessionname:${sessionScope.name}<br>

@ModelAttribute<br>
User user��${requestScope.user}<br>
abc user:${requestScope.abc}<br>

<%--viewTest<br>--%>
<%--<fmt:message key="i18n.username"></fmt:message><br>--%>
<%--<fmt:message key="i18n.password"></fmt:message><br>--%>
</body>
</html>
