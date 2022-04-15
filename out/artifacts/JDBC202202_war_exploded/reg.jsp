<%--
  Created by IntelliJ IDEA.
  User: a2193
  Date: 2022/4/13
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script>
        function changeImage(img){
            img.src=img.src+"?"+new Date().getTime();
        }
    </script>
</head>
<body>
<form action="reg" method="get">
    姓名：<input type="text" name="username"><br>
    密码：<input type="password" name="pwd"><br>
    验证码：<input type="text" name="code">
    <img src="<%=request.getContextPath()%>/vc" alt="" onclick="changeImage(this)">
    <br>
    <input type="submit" value="注册"><br>
</form>
</body>
</html>
