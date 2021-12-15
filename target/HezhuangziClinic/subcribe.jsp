<%@ page import="static sun.misc.MessageUtils.out" %>
<%@ page import="com.hezhuangzi.entity.PatientInfo" %>
<%@ page import="com.hezhuangzi.services.patient.PatientService" %>
<%@ page import="org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>预约挂号</title>
    <link rel="stylesheet" href="css/subscribe.css">
    <link rel="icon" type="image/png" href="https://pic.imgdb.cn/item/61b497192ab3f51d910ba7e0.png" />
    <!-- Bootstrap 的 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="assets/css/bold.css">

</head>
<body>
<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<c:if test="${!empty noInfo}">
    <script>
        alert("请先完善个人信息再进行预约！");
        window.location.replace("patientinfo");
    </script>
</c:if>
<%--<div class="continer">--%>
<%--    <div class="header-out">--%>
<%--        <div class="header w">--%>
<%--            <h1>预约系统</h1>--%>
<%--            <div>--%>
<%--                xxx,欢迎使用！--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <div class="nav ">--%>
<%--        <div class="nav-list w">--%>
<%--            <a href="patientinfo">个人信息</a>--%>
<%--            <a href="" style="color: #2B81D5; font-weight: bold;">预约挂号</a>--%>
<%--            <a href="progress">进度查询</a>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <%@ include file="patientheader.jsp"%>--%>

<div class="container vw-100" style="max-width: 100%; ">
    <div class="row">
        <div class="col text-center">
            <h2>
                <img src="https://pic.imgdb.cn/item/61b497192ab3f51d910ba7e0.png"
                     style="width: 60px; height: 60px;">
                <b class="card-title" style="color: rgb(45, 133, 168);">何庄子诊所</b>
            </h2>
        </div>
        <div class="col text-right">
            <h2>
                <span>欢迎</span>
                <span>患者</span>
                <label>${sessionScope.patientInfo.pati_name}</label>
            </h2>
        </div>
        <div class="col text-left">
            <h2>
                <a href="LogoutServlet?type=patientInfo">
                    <i class="bi bi-box-arrow-right">
                    </i></a>
            </h2>
        </div>
    </div>
</div>
<div class="container bg-primary rounded-lg mb-4">
    <div class="row text-center">
        <div class="col mt-2">
            <h3><a href="patientinfo" class="text-decoration-none text-light">个人信息</a></h3>
        </div>
        <div class="col m-2">
            <h3><a href="" class="text-decoration-none bolder text-light">预约挂号</a></h3>

        </div>
        <div class="col m-2">
            <h3><a href="progress" class="text-decoration-none text-light">进度查询</a></h3>

        </div>
    </div>
</div>


<!-- 预约挂号 -->
<div class="modal-body">
    <div class="container">
        <%--            <c:choose>--%>
        <%--                <c:when test="${noSubcribe}">--%>
        <form class="row" id="form-doctor" onsubmit="return false">
            <div class="col text-right mt-2">
                <h4 class="h4">时间</h4>
            </div>
            <div class="col mt-1">
                <input name="date" max="${max}" min="${min}" class="form-control" type="date">
            </div>
            <div class="col text-right mt-2">
                <h4 class="h4">科室</h4>
            </div>
            <div class="col mt-1">
                <select name="sector" class="custom-select" id="">
                    <option value="neike">内科</option>
                    <option value="waike">外科</option>
                    <option value="erke">儿科</option>
                    <option value="pifuke">皮肤科</option>
                    <option value="wuguanke">五官科</option>
                </select>
            </div>
            <div class="col text-right mt-2">
                <h4 class="h4">时间段</h4>
            </div>
            <div class="col">
                <select name="time" class="custom-select mt-1">
                    <option value="am">上午</option>
                    <option value="pm">下午</option>
                </select>
            </div>
            <div class="col mt-1">
                <button onclick="selectDoctor()" type="button" class="btn btn-info">
                    <i class="bi bi-search"></i>
                </button>
            </div>
        </form>

        <%--                </c:when>--%>
        <%--                <c:otherwise>--%>
        <%--                    <h2>暂无预约信息</h2>--%>
        <%--                </c:otherwise>--%>
        <%--            </c:choose>--%>
    </div>
</div>

<table id="subcribe-list" class="container table text-center border border-dark rounded shadow">
<%--    <thead class="thead-light">--%>
<%--    <tr>--%>
<%--        <th>姓名</th>--%>
<%--        <th>科室</th>--%>
<%--        <th>性别</th>--%>
<%--        <th>年龄</th>--%>
<%--        <th>挂号数</th>--%>
<%--        <th>预约</th>--%>
<%--    </tr>--%>
<%--&lt;%&ndash;    </thead>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <tbody>&ndash;%&gt;--%>
<%--    <tr>--%>
<%--        <td><label class="mt-2">3123</label></td>--%>
<%--        <td><label class="mt-2">内科</label></td>--%>
<%--        <td><label class="mt-2">男</label></td>--%>
<%--        <td><label class="mt-2">35</label></td>--%>
<%--        <td><label class="mt-2">23</label></td>--%>
<%--        <td><button type="button" class="btn btn-success">预约</button></td>--%>
<%--    </tr>--%>
<%--    </tbody>--%>
</table>

<script src="assets/modules/jquery/dist/jquery.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous">
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous">
</script>

<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>



<%--    <div class="nav ">--%>
<%--        <div class="nav-list w">--%>
<%--            <a href="patientinfo">个人信息</a>--%>
<%--            <a href="subcribe" style="color: #2B81D5; font-weight: bold;">预约挂号</a>--%>
<%--            <a href="progress">进度查询</a>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    &lt;%&ndash; 预约面板 &ndash;%&gt;--%>
<%--    <div class="main w">--%>
<%--        <div class="continer">--%>
<%--            <c:choose>--%>
<%--                <c:when test="${noSubcribe}">--%>
<%--                    <form id="form-doctor" action="#" method="post" onsubmit="return false">--%>
<%--                        <input type="date" name="date" id="" max="${max}" min="${min}" }>--%>
<%--                        <select name="sector">--%>
<%--                            <option value="neike">内科</option>--%>
<%--                            <option value="waike">外科</option>--%>
<%--                            <option value="erke">儿科</option>--%>
<%--                            <option value="pifuke">皮肤科</option>--%>
<%--                            <option value="wuguanke">五官科</option>--%>
<%--                        </select>--%>
<%--                        <select name="time">--%>
<%--                            <option value="am">上午</option>--%>
<%--                            <option value="pm">下午</option>--%>
<%--                        </select>--%>
<%--                        <input type="button" value="查询" onclick="selectDoctor()">--%>
<%--                    </form>--%>
<%--                    <div id="doctor-list"></div>--%>
<%--                    &lt;%&ndash;            <button type="button" onclick="subcribe()">预约</button>&ndash;%&gt;--%>
<%--                </c:when>--%>
<%--                <c:otherwise>--%>
<%--                    <h2>暂无预约信息</h2>--%>
<%--                </c:otherwise>--%>
<%--            </c:choose>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<script>
    // var arrangeId = "";

    function selectDoctor() {
        $.ajax({
            url: "querysubcribedoctor",
            type: "POST",
            dateType: "JSON",
            data: $('#form-doctor').serialize(),
            success: function (result) {
                $("#subcribe-list").empty();
                alert("查询成功！");
                $("#subcribe-list").append("<tr> <th>姓名</th> <th>科室</th> <th>性别</th> <th>年龄</th> <th>挂号数</th> <th>预约</th> </tr>")
                for (var index in result) {
                    let other = result[index];
                    console.log("查询数据："+other);
                    $("#subcribe-list").append('' +
                        '<tr>' +
                        '<td><label class="mt-2">' + other.clin_name + '</label></td> ' +
                        '<td><label class="mt-2">' + other.clin_post + '</label></td>' +
                        '<td><label class="mt-2"> ' + other.clin_gen + '</label></td>' +
                        '<td><label class="mt-2">' + other.clin_age + '</label></td> ' +
                        '<td><label id= "subnum' + other.arra_id + '" class="mt-2">' + other.arra_id + '</label></td> ' +
                        '<td><button  onclick="subcribe(' + other.arra_id + ',' + other.arra_subnum + ')" type="button" class="btn btn-success">预约</button></td> ' +
                        '</tr>');

                    // $("#doctor-list").append("" +
                    //     "<div class='doctor' onclick=''>" +
                    //     "<img src='img/pic.png' width='100' height='100' alt=''>" +
                    //     "<p>姓名：<span>" + other.clin_name + "</span></p>" +
                    //     "<p>科室：<span>" + other.clin_post + "</span></p>" +
                    //     "<p>性别：<span>" + other.clin_gen + "</span></p>" +
                    //     "<p>年龄：<span>" + other.clin_age + "</span></p>" +
                    //     "<p>挂号数：<span id= 'subnum" + other.arra_id + "'" + ">" + other.arra_subnum + "</span></p>" +
                    //     "<button type='button' onclick='subcribe(" + other.arra_id + "," + other.arra_subnum + ")'>预约</button>" +
                    //     "</div>");
                }
            },
            error: function (error) {
                alert("error");
            }
        });
    }

    function subcribe(arrangeId, num) {

        $.ajax({
            url: "subcribedoctor",
            type: "POST",
            data: {"arrangeId": arrangeId,},
            dataType: "JSON",
            success: function (res) {
                var result = res.result;
                if (result === 0) {
                    alert("预约出现错误，请重试！");
                } else if (result === 1) {
                    alert("预约成功！");
                    var devnum = num - 1;
                    document.getElementById("subnum" + arrangeId).innerHTML = devnum;
                } else if (result === 2) {
                    alert("已有预约，不能再预约了");
                } else if (result === 3) {
                    alert("已有爽约，等待下周再预约！");
                }
            },
            error: function (err) {
                alert("出现错误！");
            }
        });
    }

</script>
</body>
</html>