<%--
  Created by IntelliJ IDEA.
  User: hhrx
  Date: 2021/12/14
  Time: 下午5:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="header-out">
    <div class="header w">
        <h1>预约系统</h1>
        <div>
            患者 ${sessionScope.patientInfo.pati_name},欢迎使用！<a href="LogoutServlet?type=patientInfo">退出系统</a>
        </div>
    </div>
</div>
