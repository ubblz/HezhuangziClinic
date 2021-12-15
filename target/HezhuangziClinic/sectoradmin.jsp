<%--
  Created by IntelliJ IDEA.
  User: hhrx
  Date: 2021/12/9
  Time: 下午4:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
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

<div>
    <div class="container" style="max-width: 100%; ">
        <div class="row">
            <div class="col-6 text-center">
                <h2>
                    <img src="https://pic.imgdb.cn/item/61b497192ab3f51d910ba7e0.png"
                         style="width: 60px; height: 60px;">
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
        <div class="row  border">
            <div class="col-2 text-center border border-left-0">
                <div class="mt-4">
                    <a href="sectoradmin" class="text-decoration-none bolder">安排就诊</a>
                </div>
                <div class="w-100"></div>
                <div class="mt-4">
                    <a href="sectormodify" class="text-decoration-none ">修改就诊</a>
                </div>

            </div>
            <div class="col border border-left-0 border-top-0">
                <div>
                    <div class="container text-center list-group-item">
                        <form id="querydoctor-form" action="">
                            <div class="row">
                                <div class="col mt-1">
                                    <span>日期</span>
                                </div>
                                <div class="col-3">
                                    <input id="date" type="date" name="date" max="${endDate}" min="${startData}">
                                </div>
                                <div class="col mt-1">
                                    <span>科室</span>
                                </div>
                                <div class="col">
                                    <select class="custom-select" name="sector" id="sector">
<%--                                        <option selected>选择</option>--%>
                                        <option value="neike">内科</option>
                                        <option value="waike">外科</option>
                                        <option value="erke">儿科</option>
                                        <option value="wuguanke">五官科</option>
                                        <option value="pifuke">皮肤科</option>
                                    </select>
                                </div>
                                <div class="col mt-1">
                                    <span>时间</span>
                                </div>
                                <div class="col">
                                    <select class="custom-select" id="time" name="time">
<%--                                        <option selected>选择</option>--%>
                                        <option value="am">上午</option>
                                        <option value="pm">下午</option>
                                    </select>
                                </div>
                                <div class="col">
                                    <button type="button" onclick="queryDoctor()" class="btn btn-success">查询</button>
                                </div>
                            </div>

                        </form>
                    </div>
                </div>

                <div>
                    <table id="arrange-table" class="table text-center">
                        <thead class="thead-light arra-thead">
                        <tr>
                            <th scope="col">医生工号</th>
                            <th scope="col">医生姓名</th>
                            <th scope="col">设置挂号数</th>
                            <th scope="col">#</th>
                        </tr>
                        </thead>
                        <tbody class="arra-tbody">
                        <%--                        <tr>--%>
                        <%--                            <td>--%>
                        <%--                                <label class="mt-2">xx</label>--%>
                        <%--                            </td>--%>
                        <%--                            <td>--%>
                        <%--                                <label class="mt-2">xx</label>--%>
                        <%--                            </td>--%>
                        <%--                            <td>--%>
                        <%--                                <label class="mt-2">xx</label>--%>
                        <%--                            </td>--%>
                        <%--                            <td>--%>
                        <%--                                <form action="" method="get">--%>
                        <%--                                    <button type="submit" class="btn btn-info col-3">选择</button>--%>
                        <%--                                </form>--%>

                        <%--                            </td>--%>
                        <%--                        </tr>--%>
                        </tbody>
                    </table>
                </div>


            </div>
            <div class="w-100"></div>
            <div class="col-2">
            </div>
        </div>
    </div>


    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous">
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous">
    </script>


    <%--    <h1>欢迎 科室管理员 登录</h1>--%>

    <%--    <a href="sectoradmin">安排就诊</a>--%>
    <%--    <a href="sectormodify">修改就诊</a>--%>

    <%--    <form id="querydoctor-form">--%>
    <%--        日期：<input id="date" type="date" name="date" max="${endDate}" min="${startData}">--%>
    <%--        科室：<select id="sector" name="sector">--%>
    <%--        <option value="neike">内科</option>--%>
    <%--        <option value="waike">外科</option>--%>
    <%--        <option value="erke">儿科</option>--%>
    <%--        <option value="wuguanke">五官科</option>--%>
    <%--        <option value="pifuke">皮肤科</option>--%>
    <%--    </select>--%>
    <%--        时间：<select id="time" name="time">--%>
    <%--        <option value="am">上午</option>--%>
    <%--        <option value="pm">下午</option>--%>
    <%--    </select>--%>
    <%--        <input onclick="queryDoctor()" type="button" value="查询">--%>
    <%--    </form>--%>

    <%--    <div class="main">--%>
    <%--        <table id="arrange-table" border="1px">--%>

    <%--        </table>--%>
    <%--    </div>--%>

    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
        var saveData;

        function queryDoctor() {
            $.ajax({
                url: "arrangequery",
                type: "POST",
                data: $("#querydoctor-form").serialize(),
                dataType: "JSON",
                success: function (res) {
                    if (res.msg === "success") {
                        alert("查询成功！");
                        displayDoctor(res.data);
                    }
                },
                error: function () {

                }
            });
        }

        function displayDoctor(data) {
            saveData = data;
            $(".arra-tbody").empty();
            // $(".arra-tbody").append('<tr> <th scope="col">医生工号</th> <th scope="col">医生姓名</th> <th scope="col">设置挂号数</th> <th scope="col">#</th> </tr>');
            for (let i = 0; i < data.length; i++) {
                $(".arra-tbody").append('<tr id="tr' + i + '"> ' +
                    '<td><label class="mt-2">' + data[i].clin_id + '</label></td> ' +
                    '<td> <label class="mt-2">' + data[i].clin_name + '</label> </td> ' +
                    '<td> <label class="mt-2"><input id="' + 'subnum' + i + '" name="subnum" value="20" type="number"></label> </td> ' +
                    '<td><button type="button" onclick="arrangeDoctor(' + i + ')" class="btn btn-info col-4">选择</button></td>' +
                    ' </tr>');
            }
        }

        // }
        //
        // function displayDoctor(data) {
        //     saveData = data;
        //     $("#arrange-table").empty();
        //     $("#arrange-table").append("<tr> <th>医生工号</th> <th>医生姓名</th> <th>设置挂号数</th> <th>安排</th> </tr>");
        //     for (let i = 0; i < data.length; i++) {
        //         $("#arrange-table").append("<tr id='tr" + i + "'> " +
        //             "<td>" + data[i].clin_id + "</td> " +
        //             "<td>" + data[i].clin_name + "</td> " +
        //             "<td><input id='" + "subnum" + i + "' name='subnum' value='20' type='number''></td>" +
        //             "<td><a href='#' onclick='arrangeDoctor(" + i + ")'>选择</a></td>" +
        //             "</tr>");
        //     }
        // }

        function arrangeDoctor(index) {
            // console.log($("#subnum"+index).val());
            // console.log($("#date").val());
            // console.log($("#time").val());
            // console.log($("#sector").val());

            var clinicId = saveData[index].clin_id;
            var subnum = $("#subnum" + index).val();
            var ampm = $("#time").val();
            var subdate = $("#date").val();
            //删除
            $.ajax({
                url: "choosearrangedoctor",
                type: "POST",
                data: {clinicId: clinicId, subnum: subnum, ampm: ampm, date: subdate},
                dataType: "TEXT",
                success: function (res) {
                    console.log(res);
                    if (res.trim() === "success") {
                        alert("已安排！");
                        $("#tr" + index).remove();
                    }
                },
                error: function () {

                }
            });
        }

    </script>
</body>
</html>
