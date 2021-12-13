<%--
  Created by IntelliJ IDEA.
  User: hhrx
  Date: 2021/12/11
  Time: 下午2:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>医生登录</title>
</head>
<body>
<div style="width:500px;margin:200px auto;text-align: center;">
<h1>医生人员登录</h1>
<form action="doctorlogin" method="post">
    工号：<input type="text" name="clinicid"><br>
    密码:<input type="password" name="pwd"><br>
    选择导诊:
    <select name="dcotortype" >
        <option value="erke">儿科</option>
        <option value="neike">内科</option>
        <option value="waike">外科</option>
        <option value="pifuke">皮肤科</option>
        <option value="wuguanke">五官科</option>
    </select><br>
    <input type="submit" value="登录">
</form>
<p>${msg}</p>
</div>
</body>
</html>
