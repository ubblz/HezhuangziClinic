<%@ page isELIgnored="false" %>
<jsp:useBean id="user" scope="request" type="com.hezhuangzi.entity.PatientInfo"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>个人信息</title>
    <link rel="stylesheet" href="css/subscribe.css">
</head>
<body>
<div class="continer">
    <div class="header-out">
        <div class="header w">
            <h1>预约系统</h1>
            <div>
                xxx,欢迎使用！
            </div>
        </div>
    </div>
    <div class="nav ">
        <div class="nav-list w">
            <a href="" style="color: #2B81D5; font-weight: bold;">个人信息</a>
            <a href="subcribe">预约挂号</a>
            <a href="progress">进度查询</a>
        </div>
    </div>

    <div class="main w">
        <div class="left-info ">
            <%--            <p>${empty user}</p>--%>
            <p>编号:<span>${user.patientId}</span> </p>
            <p>姓名:<span id="uname">${user.name}</span>  </p>
            <p>性别:<span id="ugen"> ${user.gen}</span> </p>
            <p>年龄:<span id="uage">${user.age}</span>  </p>
            <p>身份证:<span id="uicard">${user.icard}</span>  </p>
            <p>手机号码:<span id="uphone"> ${user.phone}</span> </p>
            <p>邮箱:<span id="uemail"> ${user.email}</span> </p>
        </div>
        <div class="right-modify">
            <form id="form-info" action="##" method="post" onsubmit="return false">
                <p id="modify-name">姓名：</p>
                <input type="text" name="modifyname">
                <p id="modify-gen">性别：</p>
                <input type="text" name="modifygen">
                <p id="modify-age">年龄：</p>
                <input type="text" name="modifyage">
                <p id="modify-icard">身份证：</p>
                <input type="text" name="modifyicard">
                <p id="modify-email">邮箱：</p>
                <input type="email" name="modifyemail"><br>
                <input type="button" value="修改" onclick="subModify()">
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    var displayData = function(){
        $.ajax({
            url: "getinfo",
            type: "POST",
            dataType:"JSON",
            success: function(res,status,xhr) {
                console.log(res.name);
                document.getElementById('uname').innerHTML = res.name;
                document.getElementById('ugen').innerHTML = res.gen;
                document.getElementById('uage').innerHTML = res.age;
                document.getElementById('uicard').innerHTML = res.icard;
                document.getElementById('uemail').innerHTML = res.email;
            },
            error: function(err) {
                alert("error");
            }
        });
    };

    function subModify(){
        $.ajax({
            url: "modifypatientinfo",
            type: "POST",
            dataType:"JSON",
            data:$('#form-info').serialize(),
            success: function(res,status,xhr) {
                alert(res.status);
                displayData()
            },
            error: function(err) {
                alert("error");
            }
        });
    }
</script>
</body>
</html>