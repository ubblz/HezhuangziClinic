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
    <link rel="icon" type="image/png" href="https://pic.imgdb.cn/item/61b497192ab3f51d910ba7e0.png" />

    <!-- Bootstrap 的 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col text-center mt-3">
            <h2>
                <img src="https://pic.imgdb.cn/item/61b497192ab3f51d910ba7e0.png"
                     style="width: 60px; height: 60px;">
                <b class="card-title" style="color: rgb(106,179,213);">何庄子诊所</b>
            </h2>
        </div>
        <div class="col text-center mt-3">
            <h2>
                管理员人登录
            </h2>
        </div>
    </div>
</div>

<div class="container border border-primary rounded shadow" style="margin-top: 200px; height: 30rem; width: 40rem;">
    <div class="row border shadow" style="background-color: rgb(38, 180, 185); height: 10%;">
    </div>

    <div class="row mt-3">
        <div class="col-3"></div>
        <form class="col-6" action="adminlogin" method="post">
            <div class="form-row mb-3">
                <div class="col">
                    <label>工号</label>
                    <input type="text" class="form-control" id="" name="clinicid" placeholder="请输入工号" required>
                </div>
            </div>
            <div class="form-row mb-3">
                <div class="col ">
                    <label>密码</label>
                    <input type="password" class="form-control" id="" name="pwd" placeholder="请输入密码" required>
                </div>
            </div>

            <div class="form-row mb-3">
                <div class="col">
                    <label>选择管理类型</label>
                    <select class="custom-select" name="admintype" id="" required>
                        <option value="sysadmin">系统管理</option>
                        <option value="secadmin">科室管理</option>
                        <option value="druadmin">药房管理</option>
                        <option value="cliadmin">诊所管理</option>
                    </select>
                </div>
            </div>
            <div class="text-center mt-3">
                <button class="btn btn-primary shadow  col" type="submit">登录</button>
            </div>
        </form>
    </div>
    <div class="text-center mt-4">
        <p>${msg}</p>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous">
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous">
</script>





<%--<div style="width:500px;margin:200px auto;text-align: center;">--%>
<%--    <h1>管理人员登陆</h1>--%>
<%--    <form action="adminlogin" method="post">--%>
<%--        工号：<input type="text" name="clinicid"><br>--%>
<%--        密码:<input type="password" name="pwd"><br>--%>
<%--        选择管理类型:--%>
<%--        <select name="admintype" >--%>
<%--            <option value="sysadmin">系统管理</option>--%>
<%--            <option value="secadmin">科室管理</option>--%>
<%--            <option value="druadmin">药房管理</option>--%>
<%--            <option value="cliadmin">诊所管理</option>--%>
<%--        </select><br>--%>
<%--        <input type="submit" value="登录">--%>
<%--    </form>--%>
<%--    <p>${msg}</p>--%>
<%--</div>--%>

</body>
</html>
