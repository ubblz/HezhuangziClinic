<%--
  Created by IntelliJ IDEA.
  User: hhrx
  Date: 2021/12/14
  Time: 下午6:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>患者注册</title>
    <title>注册 - 何庄子诊所</title>
    <link rel="icon" type="image/png" href="https://pic.imgdb.cn/item/61b497192ab3f51d910ba7e0.png"/>

    <!-- Bootstrap 的 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">

</head>
<body>
<div>
    <div class="container">
        <div class="row">
            <div class="col mt-2">
                <a class="text-decoration-none text-dark" href="">
                    <h2 class="card-title">
                        <img src="https://pic.imgdb.cn/item/61b497192ab3f51d910ba7e0.png"
                             style="width: 60px; height: 60px;">
                        <b class="card-title" style="color: rgb(45, 133, 168);">何庄子诊所</b>
                        <span class="card-title">欢迎注册</span>
                    </h2>
                </a>
            </div>
        </div>
    </div>
</div>

<div class="container border rounded shadow">
    <div class="row mt-3">
        <label class="col text-center text-black-50">没有账号？创建您的账户。</label>
    </div>
    <div class="row mt-2">
        <div class="col-4"></div>
        <form class="col-4" action="register" method="post" >
            <div class="reg-box">
                <div class="row">
                    <div class="col mb-3">
                        <i class="bi bi-phone"></i>
                        <label for="">手机号</label>
                        <input type="text" class="form-control phone" id="tel" maxlength="11" name="phone"
                               placeholder="请输入手机号" onBlut="textBlur(this)" onFocus="textFocus(this)" required>
                        <span class="text-black-50 error error1"></span>
                    </div>
                </div>
                <div class="row">
                    <div class="col mb-3">
                        <i class="bi bi-lock"></i>
                        <label for="">密码</label>
                        <input type="password" class="form-control password" id="password" name="pwd"
                               placeholder="请输入密码" maxlength="18" onblur="textBlur(this)" onfocus="textFocus(this)"
                               required>
                        <span class="text-black-50 error error3"></span>
                    </div>
                </div>
                <div class="row">
                    <div class="col mb-3">
                        <i class="bi bi-lock"></i>
                        <label>确认密码</label>
                        <input type="password" class="form-control email" id="" placeholder="请再次输入密码"
                               onblur="textBlur(this)" onfocus="textFocus(this)" required>
                        <span class="text-black-50 error error3"></span>
                    </div>
                </div>
            </div>
            <div class="text-center mt-3 mb-3">
                <button class="btn btn-primary shadow col" type="submit">注册</button>
            </div>

        </form>
    </div>
    <div class="row text-center">
        <div class="col">
            <h4>${msg}</h4>
        </div>
    </div>
    <div class=" text-center mt-3 mb-3">
        <a href="patientlogin.jsp" class="card-link text-black-50">返回</a>
    </div>
</div>

<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script src="assets/js/login_register.js"></script>

</body>
</html>
