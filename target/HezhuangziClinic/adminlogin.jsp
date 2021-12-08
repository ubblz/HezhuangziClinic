<%--
  Created by IntelliJ IDEA.
  User: hhrx
  Date: 2021/12/8
  Time: 下午7:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>管理人员登录</title>
</head>
<body>
<div style="width:500px;margin:200px auto;text-align: center;">
    <form action="adminlogin" method="post">
        工号：<input type="text" name="clinicid"><br>
        密码:<input type="password" name="pwd"><br>
        选择管理类型:
        <select name="admintype" >
            <option value="sysadmin">系统管理</option>
            <option value="secadmin">科室管理</option>
            <option value="druadmin">药房管理</option>
            <option value="cliadmin">诊所管理</option>
        </select><br>
        <input type="submit" value="登录">
    </form>
    <p>${msg}</p>
</div>

</body>
</html>
