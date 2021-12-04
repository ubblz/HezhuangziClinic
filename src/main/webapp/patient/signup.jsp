<%--
  Created by IntelliJ IDEA.
  User: hhrx
  Date: 2021/12/4
  Time: 下午1:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>用户注册</title>
</head>
<body>
    <form method="post" action="../SignUp">
        手机号：<input type="text" name="phone"/><br>
        密码：<input type="text" name="pwd"/><br>
        确认密码：<input type="text" name="rpwd"/><br>
        <button type="submit">注册</button>
    </form>
</body>
</html>
