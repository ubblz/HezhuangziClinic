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
    <title>导诊人员登录</title>
</head>
<body>
<div style="width:500px;margin:200px auto;text-align: center;">
    <h1>导诊人员登陆</h1>
    <form action="guidancelogin" method="post">
        工号：<input type="text" name="clinicid"><br>
        密码:<input type="password" name="pwd"><br>
        选择导诊:
        <select name="guidancetype" >
            <option value="erkeguidan">儿科导诊</option>
            <option value="neikeguidan">内科导诊</option>
            <option value="waikeguidan">外科导诊</option>
            <option value="pifukeguidan">皮肤科导诊</option>
            <option value="wuguankeguidan">五官科导诊</option>
        </select><br>
        <input type="submit" value="登录">
    </form>
    <p>${msg}</p>
</div>

</body>
</html>
