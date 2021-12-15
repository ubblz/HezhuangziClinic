<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hhrx
  Date: 2021/12/8
  Time: 下午10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>后台管理员 - 何庄子诊所</title>

    <link rel="icon" type="image/png" href="https://pic.imgdb.cn/item/61b497192ab3f51d910ba7e0.png">

    <!-- Bootstrap 的 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="assets/css/bold.css">
</head>
<body>

<div style="max-height: 10%;">
    <div class="row">
        <div class="col">
            <h2 class="card-title">
                <img src="https://pic.imgdb.cn/item/61b497192ab3f51d910ba7e0.png"
                     style="width: 60px; height: 60px;">
                <b class="card-title" style="color: rgb(45, 133, 168);">何庄子诊所</b>
                <span class="card-title">后台管理</span>
            </h2>
        </div>
        <div class="col text-center mt-3">
            <h2>
                <a href="LogoutServlet?type=admin" class="text-dark text-decoration-none">
                    <i class="bi bi-box-arrow-right">
                        退出
                    </i>
                </a>
            </h2>
        </div>
    </div>
</div>

<div class="row border">
    <div class="col-2 text-center border border-left-0">
        <div class="mt-4 bg-primary rounded-lg">
            <a href="systemadmin" class="text-decoration-none text-white bolder">人员名单</a>
        </div>
        <div class="w-100"></div>
        <div class="mt-4">
            <a href="getsector" class="text-decoration-none ">科室名单</a>
        </div>
        <div class="mt-4">
            <a href="getdrug" class="text-decoration-none ">药品名单</a>
        </div>

    </div>
    <div  class="col border border-left-0 border-top-0">
        <div class="mt-2">
            <form id="excelform" enctype="multipart/form-data" class="mt-2">
                导入职工文件：<input type="file" name="excelfile" id="file_per">
                <button class="btn btn-success" type="button" onclick="uploadFile()" >导入</button>
            </form>
        </div>
        <c:choose>
            <c:when test="${!empty clinicWorker}">
                <div class=" shadow mt-5">
                    <table class="table text-center text-dark">
                        <thead class="thead-light">
                        <tr>
                            <th scope="col">工号</th>
                            <th scope="col">姓名</th>
                            <th scope="col">性别</th>
                            <th scope="col">出生日期</th>
                            <th scope="col">年龄</th>
                            <th scope="col">职称</th>
                            <th scope="col">手机号</th>
                            <th scope="col">图片</th>
                            <th scope="col">类型</th>
                            <th scope="col">密码</th>
                            <th scope="col">选择</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${clinicWorker}" var="item">
                            <tr id="clinid${item.clin_id}">
                                <td><label for="" class="mt-2">${item.clin_id}</label></td>
                                <td><label for="" class="mt-2">${item.clin_name}</label></td>
                                <td><label for="" class="mt-2">${item.clin_gen}</label></td>
                                <td><label for="" class="mt-2">${item.clin_birth}</label></td>
                                <td><label for="" class="mt-2">${item.clin_age}</label></td>
                                <td><label for="" class="mt-2">${item.clin_post}</label></td>
                                <td><label for="" class="mt-2">${item.clin_pic}</label></td>
                                <td><label for="" class="mt-2">${item.clin_phone}</label></td>
                                <td><label for="" class="mt-2">${item.clin_type}</label></td>
                                <td><label for="" class="mt-2">${item.clin_pwd}</label></td>
                                <td><button onclick="deleteWorker('${item.clin_id}')" type="button" class="btn btn-danger">删除</button></td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </div>
            </c:when>
            <c:otherwise>
                <h2>暂无数据</h2>
            </c:otherwise>
        </c:choose>



    </div>
</div>


<!-- jQuery and JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous">
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous">
</script>



















<%--<h1>欢迎 系统管理员 登录</h1>--%>

<%--<a href="systemadmin">导入职工信息</a>--%>
<%--<a href="getsector">导入科室信息</a>--%>
<%--<a href="getdrug">导入药品信息</a>--%>

<%--<form id="excelform" enctype="multipart/form-data">--%>
<%--    选择职工文件：<input type="file" name="excelfile"><br>--%>
<%--    <input onclick="uploadFile()" type="button" value="导入">--%>
<%--</form>--%>
<%--&lt;%&ndash;<form action="getexcelfile" id="excelform" method="post" enctype="multipart/form-data">&ndash;%&gt;--%>
<%--&lt;%&ndash;    选择文件：<input type="file" name="excelfile"><br>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <input type="submit" value="导入">&ndash;%&gt;--%>
<%--&lt;%&ndash;</form>&ndash;%&gt;--%>

<%--<c:choose>--%>
<%--    <c:when test="${!empty clinicWorker}">--%>
<%--        <div id="datacontent">--%>
<%--            <table id="datatable">--%>
<%--                <tr>--%>
<%--                    <th>工号</th>--%>
<%--                    <th>姓名</th>--%>
<%--                    <th>性别</th>--%>
<%--                    <th>出生日期</th>--%>
<%--                    <th>年龄</th>--%>
<%--                    <th>职称</th>--%>
<%--                    <th>手机号</th>--%>
<%--                    <th>图片</th>--%>
<%--                    <th>类型</th>--%>
<%--                    <th>密码</th>--%>
<%--                    <th>选择</th>--%>
<%--                </tr>--%>
<%--                <c:forEach items="${clinicWorker}" var="item">--%>
<%--                    <tr id="clinid${item.clin_id}">--%>
<%--                        <td>${item.clin_id}</td>--%>
<%--                        <td>${item.clin_name}</td>--%>
<%--                        <td>${item.clin_gen}</td>--%>
<%--                        <td>${item.clin_birth}</td>--%>
<%--                        <td>${item.clin_age}</td>--%>
<%--                        <td>${item.clin_post}</td>--%>
<%--                        <td>${item.clin_pic}</td>--%>
<%--                        <td>${item.clin_phone}</td>--%>
<%--                        <td>${item.clin_type}</td>--%>
<%--                        <td>${item.clin_pwd}</td>--%>
<%--                        <td><button onclick="deleteWorker('${item.clin_id}')">删除</button></td>--%>
<%--                    </tr>--%>
<%--                </c:forEach>--%>
<%--            </table>--%>
<%--        </div>--%>
<%--    </c:when>--%>
<%--    <c:otherwise>--%>
<%--        <h2>暂无数据</h2>--%>
<%--    </c:otherwise>--%>
<%--</c:choose>--%>


<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    var saveData;

    function deleteWorker(cliniId){
        var con = confirm("确认删除?");
        if(con){
            $.ajax({
                url:"SystemDeleteWorkerServlet",
                type:"POST",
                data:{"clinicid":cliniId},
                dataType: "JSON",
                success:function(res){
                    if (res.result === 1) {
                        alert("删除成功！");
                        $("#clinid"+cliniId).remove();
                    }else if(res.result === 2){
                        alert("删除失败！");
                    }else{
                        alert("删除出错！");
                    }
                },
                error:function(){
                    alert("删除出错！");
                }
            });
        }

    }

    function uploadFile() {
        var con = confirm("确定导入？");
        if(con){
            $.ajax({
                type: 'POST',
                url: "getexcelfile",
                data: new FormData($('#excelform')[0]),
                cache: false,
                processData: false,
                contentType: false,
                dataType: "JSON",
                success: function (res) {
                    if (res.result === 1) {
                        //displayData(res.data);
                        alert("导入成功！");
                        window.location.replace("systemadmin");
                    }
                    if (res.result === 2) {
                        alert(res.count+"条数据，导入失败！");
                        window.location.replace("systemadmin");
                    }
                },
                error:function(){
                    alert("导入出错！");
                }
            });
        }
    }

    // function displayData(data) {
    //     for (let i = 0; i < data.length; i++) {
    //         $("#datatable").append("<tr>" +
    //             "<td>" + data[i].clinicId + "</td>" +
    //             "<td>" + data[i].cname + "</td>" +
    //             "<td>" + data[i].gen + "</td>" +
    //             "<td>" + data[i].birth + "</td>" +
    //             "<td>" + data[i].age + "</td>" +
    //             "<td>" + data[i].post + "</td>" +
    //             "<td>" + data[i].phone + "</td>" +
    //             "<td>" + data[i].pic + "</td>" +
    //             "<td>" + data[i].typ + "</td>" +
    //             "<td>" + data[i].pwd + "</td>" +
    //             "</tr>")
    //     }
    //     saveData = data;
    // }
</script>
</body>
</html>
