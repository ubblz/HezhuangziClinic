<%@ page isELIgnored="false" %>
<%--<jsp:useBean id="user" scope="request" type="com.hezhuangzi.entity.PatientInfo"/>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>个人信息</title>
    <link rel="stylesheet" href="css/subscribe.css">

    <link rel="icon" type="image/png" href="https://pic.imgdb.cn/item/61b497192ab3f51d910ba7e0.png" />
    <!-- Bootstrap 的 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="assets/css/bold.css">
</head>
<body>
<div class="continer">

<%--    <%@ include file="patientheader.jsp" %>--%>

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
                        <i class="bi bi-box-arrow-right"></i>
                    </a>
                </h2>
            </div>
        </div>
    </div>

    <div class="container bg-primary rounded-lg mb-4">
        <div class="row text-center">
            <div class="col mt-2">
                <h3><a href="" class="text-decoration-none bolder text-light">个人信息</a></h3>
            </div>
            <div class="col m-2">
                <h3><a href="subcribe" class="text-decoration-none text-light">预约挂号</a></h3>

            </div>
            <div class="col m-2">
                <h3><a href="progress" class="text-decoration-none text-light">进度查询</a></h3>

            </div>
        </div>
    </div>

    <!-- 个人信息 -->
    <div class="row" style="height: 40rem;  margin-left: 5rem; margin-right: 5rem;">
        <div class="col rounded-lg shadow mr-5">
            <table style="width: 90%; height: 100%;">
                <tbody>
                <tr>
                    <td class="text-right">
                        <h3>编号：</h3>
                    </td>
                    <td class="text-left">
                        ${patientInfo.pati_id}
                    </td>
                </tr>
                <tr>
                    <td class="text-right">
                        <h3>姓名：</h3>
                    </td>
                    <td class="text-left" id="uname">
                        ${patientInfo.pati_name}
                    </td>
                </tr>
                <tr>
                    <td class="text-right">
                        <h3>性别：</h3>
                    </td>
                    <td class="text-left" id="ugen">
                        ${patientInfo.pati_gen}
                    </td>
                </tr>
                <tr>
                    <td class="text-right">
                        <h3>年龄：</h3>
                    </td>
                    <td class="text-left" id="uage">
                        ${patientInfo.pati_age}
                    </td>
                </tr>
                <tr>
                    <td class="text-right">
                        <h3>身份证：</h3>
                    </td>
                    <td class="text-left" id="uicard">
                        ${patientInfo.pati_icard}
                    </td>
                </tr>
                <tr>
                    <td class="text-right">
                        <h3>手机号码：</h3>
                    </td>
                    <td class="text-left" id="uphone">
                        ${patientInfo.pati_phone}
                    </td>
                </tr>
                <tr>
                    <td class="text-right">
                        <h3>邮箱：</h3>
                    </td>
                    <td class="text-left" id="uemail">
                        ${patientInfo.pati_email}
                    </td>
                </tr>
                </tbody>
            </table>
        </div>

        <form class="col rounded-lg shadow ml-5" id="form-info" action="##" method="post" onsubmit="return false">
            <div class="form-group row" style="margin-top: 1rem;">
                <label for="text" class="col-sm-2 col-form-label">姓名</label>
                <div class="col-sm-10">
                    <input class="w-100 form-control" type="text" name="modifyname" id="" required>
                </div>
            </div>
            <div class="form-group row">
                <label for="text" class="col-sm-2 col-form-label" id="modifygen">性别</label>
                <div class="col-sm-10">
                    <select class="custom-select" name="modifygen" id="" required>
                        <option selected></option>
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label for="text" class="col-sm-2 col-form-label" id="modify-age">年龄</label>
                <div class="col-sm-10">
                    <input class="w-100 form-control" type="number" name="modifyage" id="" min="1" required>
                </div>
            </div>
            <div class="form-group row">
                <label for="input" class="col-sm-2 col-form-label" id="modify-icard">身份证</label>
                <div class="col-sm-10">
                    <input class="w-100 form-control" type="text" name="modifyicard" id="" required>
                </div>
            </div>

            <div class="form-group row">
                <label for="inputPassword" class="col-sm-2 col-form-label" id="modify-email">邮箱</label>
                <div class="col-sm-10">
                    <input type="email" name="modifyemail" id="" class="form-control" required>
                </div>
            </div>
            <div class="row">
                <div class="col-5"></div>
                <button type="button" class="btn btn-primary col-2" onclick="subModify()">修改</button>
            </div>
        </form>
    </div>



    <script src="assets/modules/jquery/dist/jquery.min.js"></script>

    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous">
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous">
    </script>







<%--    &lt;%&ndash;  mine  &ndash;%&gt;--%>
<%--    <div class="nav ">--%>
<%--        <div class="nav-list w">--%>
<%--            <a href="patientinfo" style="color: #2B81D5; font-weight: bold;">个人信息</a>--%>
<%--            <a href="subcribe">预约挂号</a>--%>
<%--            <a href="progress">进度查询</a>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <div class="main w">--%>
<%--        <div class="left-info ">--%>
<%--            &lt;%&ndash;            <p>${empty user}</p>&ndash;%&gt;--%>
<%--            <p>编号:<span>${patientInfo.pati_id}</span></p>--%>
<%--            <p>姓名:<span id="uname">${patientInfo.pati_name}</span></p>--%>
<%--            <p>性别:<span id="ugen"> ${patientInfo.pati_gen}</span></p>--%>
<%--            <p>年龄:<span id="uage">${patientInfo.pati_age}</span></p>--%>
<%--            <p>身份证:<span id="uicard">${patientInfo.pati_icard}</span></p>--%>
<%--            <p>手机号码:<span id="uphone"> ${patientInfo.pati_phone}</span></p>--%>
<%--            <p>邮箱:<span id="uemail"> ${patientInfo.pati_email}</span></p>--%>
<%--        </div>--%>
<%--        <div class="right-modify">--%>
<%--            <form id="form-info" action="##" method="post" onsubmit="return false">--%>
<%--                <p id="modify-name">姓名：</p>--%>
<%--                <input type="text" name="modifyname">--%>
<%--                <p id="modify-gen">性别：</p>--%>
<%--                <input type="text" name="modifygen">--%>
<%--                <p id="modify-age">年龄：</p>--%>
<%--                <input type="text" name="modifyage">--%>
<%--                <p id="modify-icard">身份证：</p>--%>
<%--                <input type="text" name="modifyicard">--%>
<%--                <p id="modify-email">邮箱：</p>--%>
<%--                <input type="email" name="modifyemail"><br>--%>
<%--                <input type="button" value="修改" onclick="subModify()">--%>
<%--            </form>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    var displayData = function () {
        $.ajax({
            url: "getpatientinfo",
            type: "POST",
            dataType: "JSON",
            success: function (res) {
                console.log(res.name);
                document.getElementById('uname').innerHTML = res.name;
                document.getElementById('ugen').innerHTML = res.gen;
                document.getElementById('uage').innerHTML = res.age;
                document.getElementById('uicard').innerHTML = res.icard;
                document.getElementById('uemail').innerHTML = res.email;
            },
            error: function (err) {
                alert("error");
            }
        });
    };

    function subModify() {
        $.ajax({
            url: "modifypatientinfo",
            type: "POST",
            dataType: "JSON",
            data: $('#form-info').serialize(),
            success: function (res, status, xhr) {
                // alert(res.status);
                displayData()
            },
            error: function (err) {
                alert("error");
            }
        });
    }
</script>
</body>
</html>