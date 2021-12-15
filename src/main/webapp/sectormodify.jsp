<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hhrx
  Date: 2021/12/9
  Time: 下午4:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>科室管理</title>
    <link rel="icon" type="image/png" href="https://pic.imgdb.cn/item/61b497192ab3f51d910ba7e0.png" />
    <!-- Bootstrap 的 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="assets/css/bold.css">

</head>
<body>

<div class="container" style="max-width: 100%; ">
    <div class="row">
        <div class="col-6 text-center">
            <h2>
                <img src="https://pic.imgdb.cn/item/61b497192ab3f51d910ba7e0.png" style="width: 60px; height: 60px;">
                <b class="card-title" style="color: rgb(45, 133, 168);">何庄子诊所</b>
                <span>科室管理员</span>
            </h2>
        </div>
        <div class="col text-right">
            <h2>
                <span>欢迎</span>
                <span>管理员</span>
                <label>${sessionScope.admin.clin_name}</label>
            </h2>
        </div>
        <div class="col text-left">
            <h2>
                <a href="LogoutServlet?type=admin">
                    <i class="bi bi-box-arrow-right">
                    </i></a>
            </h2>
        </div>
    </div>
</div>


<div class="">
    <div class="row">
        <div class="col-2 text-center border border-left-0">
            <div class="mt-4">
                <a href="sectoradmin" class="text-decoration-none ">安排就诊</a>
            </div>
            <div class="w-100"></div>
            <div class="mt-4">
                <a href="sectormodify" class="text-decoration-none bolder">修改就诊</a>
            </div>

        </div>
        <div class="col border border-left-0">
            <table class="table text-center">
                <thead class="thead-light">
                <tr>
                    <th scope="col">序号</th>
                    <th scope="col">工号</th>
                    <th scope="col">姓名</th>
                    <th scope="col">性别</th>
                    <th scope="col">年龄</th>
                    <th scope="col">出生日期</th>
                    <th scope="col">手机号</th>
                    <th scope="col">科室</th>
                    <th scope="col">挂号数</th>
                    <th scope="col">日期</th>
                    <th scope="col">时间</th>
                    <th scope="col">#</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${arrangeDoctorList}" var="item">
                    <%--          <tr id="tr${item.arra_id}">--%>
                    <%--            <td>${item.arra_id}</td>--%>
                    <%--            <td>${item.clin_id}</td>--%>
                    <%--            <td>${item.clin_name}</td>--%>
                    <%--            <td>${item.clin_gen}</td>--%>
                    <%--            <td>${item.clin_age}</td>--%>
                    <%--            <td>${item.clin_birth}</td>--%>
                    <%--            <td>${item.clin_phone}</td>--%>
                    <%--            <td>${item.clin_post}</td>--%>
                    <%--            <td>${item.arra_subnum}</td>--%>
                    <%--            <td>${item.arra_subdate}</td>--%>
                    <%--            <td>${item.arra_ampm}</td>--%>
                    <%--            <td><a href="#" onclick="cancelArrange(${item.arra_id})">取消</a></td>--%>
                    <%--          </tr>--%>
                    <tr id="tr${item.arra_id}">
                        <td><label class="mt-2">${item.arra_id}</label></td>
                        <td><label class="mt-2">${item.clin_id}</label></td>
                        <td><label class="mt-2">${item.clin_name}</label></td>
                        <td><label class="mt-2">${item.clin_gen}</label></td>
                        <td><label class="mt-2">${item.clin_age}</label></td>
                        <td><label class="mt-2">${item.clin_birth}</label></td>
                        <td><label class="mt-2">${item.clin_phone}</label></td>
                        <td><label class="mt-2">${item.clin_post}</label></td>
                        <td><label class="mt-2">${item.arra_subnum}</label></td>
                        <td><label class="mt-2">${item.arra_subdate}</label></td>
                        <td><label class="mt-2">${item.arra_ampm}</label></td>
                        <td>
                            <button type="button" onclick="cancelArrange(${item.arra_id})" class="btn btn-info">取消
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="w-100"></div>
        <div class="col-2 ">
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous">
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous">
</script>


<%--<h1>欢迎 科室管理员 登录</h1>--%>

<%--<a href="sectoradmin">安排就诊</a>--%>
<%--<a href="sectormodify">修改就诊</a>--%>
<%--<h2>已安排的医生名单</h2>--%>
<%--&lt;%&ndash;<h3>搜索</h3>&ndash;%&gt;--%>
<%--&lt;%&ndash;日期：<input type="date" name="date" > 姓名：<input type="text" name="cname">&ndash;%&gt;--%>
<%--&lt;%&ndash;时间：<select name="time">&ndash;%&gt;--%>
<%--&lt;%&ndash;  <option value="am">上午</option>&ndash;%&gt;--%>
<%--&lt;%&ndash;  <option value="pm">下午</option>&ndash;%&gt;--%>
<%--&lt;%&ndash;</select>&ndash;%&gt;--%>
<%--&lt;%&ndash;<input type="button" name="search" value="搜索">&ndash;%&gt;--%>
<%--&lt;%&ndash;<h3>医生名单</h3>&ndash;%&gt;--%>
<%--<table>--%>
<%--  &lt;%&ndash;--%>
<%--  <td>${item.arrangeId}</td>--%>
<%--      <td>${item.clinicId}</td>--%>
<%--      <td>${item.cname}</td>--%>
<%--      <td>${item.gen}</td>--%>
<%--      <td>${item.age}</td>--%>
<%--      <td>${item.birth}</td>--%>
<%--      <td>${item.phone}</td>--%>
<%--      <td>${item.subnum}</td>--%>
<%--      <td>${item.subdate}</td>--%>
<%--      <td>${item.ampm}</td>--%>
<%--      <td>取消</td>--%>
<%--  &ndash;%&gt;--%>
<%--  <tr>--%>
<%--    <th>序号</th>--%>
<%--    <th>工号</th>--%>
<%--    <th>姓名</th>--%>
<%--    <th>性别</th>--%>
<%--    <th>年龄</th>--%>
<%--    <th>出生日期</th>--%>
<%--    <th>手机号</th>--%>
<%--    <th>科室</th>--%>
<%--    <th>挂号数</th>--%>
<%--    <th>日期</th>--%>
<%--    <th>时间</th>--%>
<%--    <th>取消</th>--%>
<%--  </tr>--%>

<%--  <c:forEach items="${arrangeDoctorList}" var="item">--%>
<%--    &lt;%&ndash;--%>
<%--    private Integer arrangeId;--%>
<%--    private String clinicId;--%>
<%--    private Integer subnum;--%>
<%--    private String ampm;--%>
<%--    private Date subdate;--%>
<%--    private String cname;--%>
<%--    private Integer age;--%>
<%--    private Date birth;--%>
<%--    private String phone;--%>
<%--    private String gen;--%>
<%--    &ndash;%&gt;--%>
<%--    <tr id="tr${item.arra_id}">--%>
<%--      <td>${item.arra_id}</td>--%>
<%--      <td>${item.clin_id}</td>--%>
<%--      <td>${item.clin_name}</td>--%>
<%--      <td>${item.clin_gen}</td>--%>
<%--      <td>${item.clin_age}</td>--%>
<%--      <td>${item.clin_birth}</td>--%>
<%--      <td>${item.clin_phone}</td>--%>
<%--      <td>${item.clin_post}</td>--%>
<%--      <td>${item.arra_subnum}</td>--%>
<%--      <td>${item.arra_subdate}</td>--%>
<%--      <td>${item.arra_ampm}</td>--%>
<%--      <td><a href="#" onclick="cancelArrange(${item.arra_id})">取消</a></td>--%>
<%--    </tr>--%>
<%--  </c:forEach>--%>
<%--</table>--%>


<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script>
    function cancelArrange(arrangeId) {
        $.ajax({
            url: "cancelarrange",
            type: "GET",
            data: {arrangeId: arrangeId},
            dataType: "TEXT",
            success: function (res) {
                if (res.trim() === "success") {
                    alert("取消成功！");
                    $("#tr" + arrangeId).remove();
                }
            },
            error: function () {

            }
        })
    }
</script>
</body>
</html>
