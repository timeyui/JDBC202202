<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>c.jsp</h1>
<%
    Object name = request.getAttribute("name");
    out.println(name);

%>
</body>
</html>
