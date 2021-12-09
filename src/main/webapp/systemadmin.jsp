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
</head>
<body>
    <h1>欢迎 系统管理员 登录</h1>
    <form id="excelform" enctype="multipart/form-data">
        选择文件：<input type="file" name="excelfile"><br>
        <input onclick="uploadFile()" type="button" value="导入">
    </form>

    <div id="datacontent">
        <table id="datatable">
            <tr><th>工号</th><th>姓名</th><th>性别</th><th>出生日期</th><th>年龄</th><th>职称</th><th>手机号</th><th>图片</th><th>类型</th><th>密码</th></tr>
        </table>
    </div>

    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
        var saveData;
        function uploadFile(){
            $.ajax({
                type: 'POST',
                url: "getexcelfile",
                data: new FormData($('#excelform')[0]),
                cache: false,
                processData: false,
                contentType: false,
                dataType:"JSON",
                success: function (res) {
                    if(res.msg === "success"){
                        displayData(res.data);
                    }
                    if(res.msg === "error"){
                        alert("导入失败！");
                    }
                }
            });
        }

        function displayData(data){
            for (let i = 0; i < data.length; i++) {
                $("#datatable").append("<tr>" +
                    "<td>"+data[i].clinicId +"</td>" +
                    "<td>"+data[i].cname +"</td>" +
                    "<td>"+data[i].gen +"</td>" +
                    "<td>"+data[i].birth +"</td>" +
                    "<td>"+data[i].age+"</td>" +
                    "<td>"+data[i].post +"</td>" +
                    "<td>"+data[i].phone +"</td>" +
                    "<td>"+data[i].pic +"</td>" +
                    "<td>"+data[i].typ +"</td>" +
                    "<td>"+data[i].pwd +"</td>" +
                    "</tr>")
            }
            saveData = data;
        }


    </script>
</body>
</html>
