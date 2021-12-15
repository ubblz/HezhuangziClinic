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

    <link rel="icon" type="image/png" href="https://pic.imgdb.cn/item/61b497192ab3f51d910ba7e0.png">

    <!-- Bootstrap 的 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col mt-3">
            <h2>
                <img src="https://pic.imgdb.cn/item/61b497192ab3f51d910ba7e0.png"
                     style="width: 60px; height: 60px;">
                <b class="card-title" style="color: rgb(45, 133, 168);">何庄子诊所</b>
                <span>医生登录</span>
            </h2>
        </div>
    </div>
</div>

<div class="media" style="height: 90%;">
    <div class="align-self-center mx-auto">
        <div class="container border border-primary rounded shadow" style="height: 30rem; width: 40rem;">
            <div class="row border shadow" style="background-color: rgb(38, 89, 185); height: 10%;">
            </div>

            <div class="row mt-3">
                <div class="col-3"></div>
                <form class="col-6" action="doctorlogin" method="post">
                    <div class="form-row mb-3 mt-5">
                        <div class="col">
                            <label>工号</label>
                            <input name="clinicid" type="text" class="form-control" id="" placeholder="请输入工号" required>
                        </div>
                    </div>
                    <div class="form-row mb-3">
                        <div class="col ">
                            <label>密码</label>
                            <input name="pwd" type="password" class="form-control" id="" placeholder="请输入密码" required>
                        </div>
                    </div>
                    <div class="form-row mb-3">
                        <div class="col">
                            <label>选择导诊类型</label>
                            <select class="custom-select" name="dcotortype" id="" required>
                                <option value="erke">儿科</option>
                                <option value="neike">内科</option>
                                <option value="waike">外科</option>
                                <option value="pifuke">皮肤科</option>
                                <option value="wuguanke">五官科</option>
                                <option value="drug">药房</option>
                                <option value="infusion">输液室</option>
                            </select>
                        </div>
                    </div>
                    <div class="text-center mt-3">
                        <button class="btn btn-primary shadow  col" type="submit" value="登录">登录</button>
                    </div>
                </form>
            </div>

            <div class="row col text-center">
                <h4>${msg}</h4>
            </div>
        </div>
    </div>
</div>

<!-- <div class="container">
<div class="row align-items-center justify-content-center " >
    fd
</div>

</div> -->

<!-- jQuery and JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous">
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous">
</script>



<%--<div style="width:500px;margin:200px auto;text-align: center;">--%>
<%--<h1>医生人员登录</h1>--%>




<%--<form action="doctorlogin" method="post">--%>
<%--    工号：<input type="text" name="clinicid"><br>--%>
<%--    密码:<input type="password" name="pwd"><br>--%>
<%--    选择导诊:--%>
<%--    <select name="dcotortype" >--%>
<%--        <option value="erke">儿科</option>--%>
<%--        <option value="neike">内科</option>--%>
<%--        <option value="waike">外科</option>--%>
<%--        <option value="pifuke">皮肤科</option>--%>
<%--        <option value="wuguanke">五官科</option>--%>
<%--        <option value="drug">药房</option>--%>
<%--        <option value="infusion">输液室</option>--%>
<%--    </select><br>--%>
<%--    <input type="submit" value="登录">--%>
<%--</form>--%>
<%--<p>${msg}</p>--%>
</div>
</body>
</html>
