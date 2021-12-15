<%--
  Created by IntelliJ IDEA.
  User: hhrx
  Date: 2021/12/14
  Time: 下午8:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>何庄子诊所</title>
    <link rel="icon" type="image/png" href="https://pic.imgdb.cn/item/61b497192ab3f51d910ba7e0.png">

    <link rel="icon" type="image/png" href="https://pic.imgdb.cn/item/61b497192ab3f51d910ba7e0.png">

    <!-- Bootstrap 的 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
</head>
<body class="card-img-overlay" style="background: url(https://pic.imgdb.cn/item/61b59b682ab3f51d91772a95.png); ">
<div style="position: absolute;">
    <a href="guidancelogin.jsp" target="_blank"><button class="btn mb-3 shadow text-white">导诊入口</button></a>
    <br>
    <a href="adminlogin.jsp" target="_blank"><button class="btn shadow text-white">管理员入口</button></a>
    <br>
    <br>
    <a href="doctorlogin.jsp" target="_blank"><button class="btn shadow text-white">医生登录</button></a>
    <br>
    <br>
    <a href="erkedisplay.jsp" target="_blank"><button class="btn shadow text-white">儿科显示屏入口</button></a>
    <br>
    <br>
    <a href="waikedisplay.jsp" target="_blank"><button class="btn shadow text-white">外科显示屏入口</button></a>
    <br>
    <br>
    <a href="neikedisplay.jsp" target="_blank"><button class="btn shadow text-white">内科显示屏入口</button></a>
    <br>
    <br>
    <a href="pifukedisplay.jsp" target="_blank"><button class="btn shadow text-white">皮肤科显示屏入口</button></a>
    <br>
    <br>
    <a href="wuguankedisplay.jsp" target="_blank"><button class="btn shadow text-white">五官科显示屏入口</button></a>
</div>

<div class="mt-3" style=" position: absolute; top:0; right: 0; color:white; text-align: right;">
    <h5>诊所现阶段设有内科，外科，儿科，皮肤科和五官科</h5>
    <br>
    <h5>目前，诊所医生均有丰富的临床经验，来诊所放心！</h5>
    <br>
    <h5>诊所所处位置：xxx大道xxx号</h5>
</div>


<div class="text-center" style="position: relative;top: 200px;">
    <h1 style="color:white;">何庄子诊所</h1>
</div>

<div class="container mt-5" style="position: relative;top: 200px;">
    <div class="row">
        <div class="col text-center border shadow mr-5">
            <div class="card-body">
                <h5 class="card-title text-white">缴费</h5>
            </div>
            <img src="https://pic.imgdb.cn/item/61b497192ab3f51d910ba7da.png" class="" alt="缴费">
            <div class="card-body">
                <a href="pay.jsp" target="_blank" class="btn btn-primary stretched-link">点击进入</a>
            </div>
        </div>

        <div class="col text-center border shadow  ml-5">
            <div class="card-body">
                <h5 class="card-title text-white">患者就医</h5>
            </div>
            <img src="https://pic.imgdb.cn/item/61b497192ab3f51d910ba7fc.png" class="" alt="患者就医">
            <div class="card-body">
                <a href="patientlogin.jsp" target="_blank" class="btn btn-primary stretched-link">点击进入</a>
            </div>
        </div>
    </div>
</div>

<!-- jQuery and JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous">
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous">
</script>
</body>

</html>
