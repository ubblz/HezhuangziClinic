<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>用户登陆</title>
    <!-- General CSS Files -->
    <title>登录 - 何庄子诊所</title>
    <link rel="icon" type="image/png" href="https://pic.imgdb.cn/item/61b497192ab3f51d910ba7e0.png" />

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
                        <span class="card-title">欢迎登录</span>
                    </h2>
                </a>
            </div>
        </div>
    </div>
</div>

<div class="container" style="margin-top: 140px;">
    <div class="row mx-auto" style="height: 519px;">
        <div class="col"></div>
        <div class="col shadow border rounded-lg">
            <div class="card-img-overlay" style=" background-color: white;"></div>
            <div class="row mt-5">
                <label class="col text-center text-black-50">请输入您的手机号和密码</label>
            </div>
            <div class="row mt-3">
                <form class="col mt-3" method="post" action="patientlogin">
                    <div class="reg-box">
                        <div class="form-row">
                            <div class="col mb-3">
                                <i class="bi bi-phone"></i>
                                <label>手机号</label>
                                <input type="text" class="form-control account" maxlength="11" name="phone"
                                       placeholder="请输入手机号" onBlur="textBlur(this)" onFocus="textFocus(this)" required>
                                <span class="text-black-50 error error5"></span>

                            </div>
                        </div>
                        <div class="form-row mt-3">
                            <div class="col mb-3">
                                <i class="bi bi-lock"></i>
                                <label>密码</label>
                                <input type="password" class="form-control admin_pwd" name="pwd" placeholder="请输入密码"
                                       maxlength="18" onBlur="textBlur(this)" onFocus="textFocus(this)" required>
                                <span class="text-black-50 error error6"></span>
                            </div>
                        </div>
                    </div>
                    <div class="text-center mt-5">
                        <button class="btn btn-primary shadow  col" type="submit">登录</button>
                    </div>
                </form>
            </div>
            <div class=" col mt-5 text-center">
                <a href="register.jsp" class="card-link text-black-50">注册账户</a>
            </div>
        </div>
        <div class="col"></div>

    </div>

</div>
<!-- <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
    integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous">
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous">
</script> -->
<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script src="assets/js/login_register.js"></script>

</body>
</html>