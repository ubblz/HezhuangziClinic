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
    <title>系统管理</title>
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



<div class="row  border">
    <div class="col-2 text-center border border-left-0">
        <div class="mt-4">
            <a href="systemadmin" class="text-decoration-none">人员名单</a>
        </div>
        <div class="w-100"></div>
        <div class="mt-4 bg-primary rounded-lg">
            <a href="getsector" class="text-decoration-none bolder text-white">科室名单</a>
        </div>
        <div class="mt-4">
            <a href="getdrug" class="text-decoration-none ">药品名单</a>
        </div>

    </div>
    <div class="col border border-left-0 border-top-0">
        <div class="mt-2">
            <form id="excelform" enctype="multipart/form-data" class="mt-2">
               导入科室文件： <input type="file" name="excelfile" id="file_per">
                <button class="btn btn-success" type="button" onclick="uploadFile()" >导入</button>
            </form>
        </div>
        <c:choose>
            <c:when test="${!empty clinicSector}">
                <div class=" shadow mt-5">
                    <table class="table text-center text-light">
                        <thead class="thead-light">
                        <tr>
                            <th scope="col">类型</th>
                            <th scope="col">科室</th>
                            <th scope="col">选择</th>
                        </tr>
                        </thead>
                        <tbody class="text-dark mt-5">
                        <c:forEach items="${clinicSector}" var="item">
                            <tr  id="clintype${item.sect_type}">
                                <td><label for="" class="mt-2">${item.sect_type}</label></td>
                                <td><label for="" class="mt-2">${item.sect_sector}</label>
                                </td>
                                <td><button onclick="deleteWorker('${item.sect_type}')" type="button" class="btn btn-danger">删除</button>
                                </td>
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
<%--    选择科室文件：<input type="file" name="excelfile"><br>--%>
<%--    <input onclick="uploadFile()" type="button" value="导入">--%>
<%--</form>--%>
<%--&lt;%&ndash;<form action="getexcelfile" id="excelform" method="post" enctype="multipart/form-data">&ndash;%&gt;--%>
<%--&lt;%&ndash;    选择文件：<input type="file" name="excelfile"><br>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <input type="submit" value="导入">&ndash;%&gt;--%>
<%--&lt;%&ndash;</form>&ndash;%&gt;--%>

<%--<c:choose>--%>
<%--    <c:when test="${!empty clinicSector}">--%>
<%--        <div id="datacontent">--%>
<%--            <table id="datatable">--%>
<%--                <tr>--%>
<%--                    <th>类型</th>--%>
<%--                    <th>科室</th>--%>
<%--                    <th>选择</th>--%>
<%--                </tr>--%>
<%--                <c:forEach items="${clinicSector}" var="item">--%>
<%--                    <tr id="clintype${item.sect_type}">--%>
<%--                        <td>${item.sect_type}</td>--%>
<%--                        <td>${item.sect_sector}</td>--%>
<%--                        <td><button onclick="deleteWorker('${item.sect_type}')">删除</button></td>--%>
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

    function deleteWorker(clinType){
        var con = confirm("确认删除?");
        if(con){
            $.ajax({
                url:"SystemDeleteSectorServlet",
                type:"POST",
                data:{"clintype":clinType},
                dataType: "JSON",
                success:function(res){
                    if (res.result === 1) {
                        alert("删除成功！");
                        $("#clintype"+clinType).remove();
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
                type: "POST",
                url: "GetSectorExcelServlet",
                data: new FormData($('#excelform')[0]),
                cache: false,
                processData: false,
                contentType: false,
                dataType: "JSON",
                success: function (res) {
                    if (res.result === 1) {
                        //displayData(res.data);
                        alert("导入成功！");
                        window.location.replace("getsector");
                    }
                    if (res.result === 2) {
                        alert(res.count+"条数据，导入失败！");
                        window.location.replace("getsector");
                    }
                },
                error:function(){
                    alert("导入出错！");
                }
            });
        }
    }
</script>
</body>
</html>
