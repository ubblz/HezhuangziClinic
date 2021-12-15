<%--
  Created by IntelliJ IDEA.
  User: hhrx
  Date: 2021/12/13
  Time: 下午9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>输液室管理</title>
    <!-- Bootstrap 的 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="icon" type="image/png" href="https://pic.imgdb.cn/item/61b497192ab3f51d910ba7e0.png" />
</head>
<body>
<div class="container" style="max-width: 100%; ">
    <div class="row">
        <div class="col-6 text-center">
            <h2>
                <img src="https://pic.imgdb.cn/item/61b497192ab3f51d910ba7e0.png"
                     style="width: 60px; height: 60px;">
                <b class="card-title" style="color: rgb(45, 133, 168);">何庄子诊所</b>
                治疗医师
            </h2>
        </div>
        <div class="col text-right">
            <h2>
                <span>欢迎</span>
                <span>医生</span>
                <label>${sessionScope.infusiondoctor.clin_name}</label>
            </h2>
        </div>
        <div class="col text-left">
            <h2>
                <a href="LogoutServlet?type=infusiondoctor">
                    <i class="bi bi-box-arrow-right"></i>
                </a>
            </h2>
        </div>
    </div>
</div>


<div class="container mt-4">
    <div class="row ">
        <h4>已缴费患者名单</h4>
    </div>

    <c:choose>
        <c:when test="${!empty drugsOfPres}">
            <c:forEach items="${drugsOfPres}" var="dop">

                <div class="border mt-3">
                    <div class="table-responsive">
                        <table class="table text-center">
                            <tr class="thead-light">
                                <th>挂号单号</th>
                                <th>处方单号</th>
                                <th>患者</th>
                                <th>年龄</th>
                                <th>身份证号</th>
                                <th>手机号</th>
                                <th>科室</th>
                                <th>医生姓名</th>
                                <th>就诊时间</th>
                            </tr>
                            <tr>
                                <td>${dop.patientPrescription.regi_id}</td>
                                <td>${dop.patientPrescription.pres_id}</td>
                                <td>${dop.patientPrescription.pati_name}</td>
                                <td>${dop.patientPrescription.pati_age}</td>
                                <td>${dop.patientPrescription.pati_icard}</td>
                                <td>${dop.patientPrescription.pati_phone}</td>
                                <td>${dop.patientPrescription.clin_post}</td>
                                <td>${dop.patientPrescription.clin_name}</td>
                                <td>${dop.patientPrescription.arra_subdate}</td>
                            </tr>
                        </table>
                    </div>

                    <div class="container mt-4">
                        <c:choose>
                            <c:when test="${!empty dop.orderDrugList}">
                                <div class="row ml-2">
                                    <h4>治疗清单：</h4>
                                </div>
                                <div class="table-responsive">
                                    <table class="table text-center">
                                        <tr class="thead-light">
                                            <th>药品编号</th>
                                            <th>药品名称</th>
                                            <th>药品数量</th>
                                        </tr>
                                        <c:forEach items="${dop.orderDrugList}" var="drug">
                                            <tr>
                                                <td>${drug.drug_id}</td>
                                                <td>${drug.drug_name}</td>
                                                <td>${drug.order_num}</td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                            </c:when>
                            <c:otherwise>
                                无药品
                            </c:otherwise>
                        </c:choose>
                    </div>

                    <div class="container mt-3 mb-3 ">
                        <div class="row indrug${dop.patientPrescription.regi_id}">
                            <div class="col"></div>
                            <input class="form-control col-4 mr-4" type="text" name="" id="registerid"
                                   placeholder="输入挂号单号" required>
                            <button type="button" class="btn btn-success col-1 mr-4 ml-4"
                                    onclick="confirmDrug('${dop.patientPrescription.regi_id}')">
                                确定
                            </button>
                        </div>
                        <div class="row mt-2 success${dop.patientPrescription.regi_id}"  style="display: none;" >
                            <div class="col text-center text-success">
                                <b>
                                    <h3>成功</h3>
                                </b>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <h2>暂无患者缴费</h2>
        </c:otherwise>
    </c:choose>
</div>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous">
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous">
</script>


<%--<h1>输液室管理</h1>--%>
<%--<h2>已缴费患者名单</h2>--%>
<%--<c:choose>--%>
<%--    <c:when test="${!empty drugsOfPres}">--%>
<%--        <c:forEach items="${drugsOfPres}" var="dop">--%>
<%--            <div>--%>
<%--                <p>--%>
<%--                    <span>挂号单号：${dop.patientPrescription.regi_id}</span>--%>
<%--                    <span>处方单号：${dop.patientPrescription.pres_id}</span>--%>
<%--                    <span>患者：${dop.patientPrescription.pati_name}</span>--%>
<%--                </p>--%>
<%--                <div>--%>
<%--                    <c:choose>--%>
<%--                        <c:when test="${!empty dop.orderDrugList}">--%>
<%--                            <h2>输液和注射药品清单：</h2>--%>
<%--                            <table>--%>
<%--                                <tr>--%>
<%--                                    <th>药品编号</th>--%>
<%--                                    <th>药品名称</th>--%>
<%--                                    <th>药品数量</th>--%>
<%--                                </tr>--%>
<%--                                <c:forEach items="${dop.orderDrugList}" var="drug">--%>
<%--                                    <tr>--%>
<%--                                        <td>${drug.drug_id}</td>--%>
<%--                                        <td>${drug.drug_name}</td>--%>
<%--                                        <td>${drug.drug_num}</td>--%>
<%--                                    </tr>--%>
<%--                                </c:forEach>--%>
<%--                            </table>--%>
<%--                            <div class="indrug${dop.patientPrescription.regi_id}">输入挂号单号：<input type="text" id="registerid">--%>
<%--                                <button type="button" onclick="confirmDrug('${dop.patientPrescription.regi_id}')">确定--%>
<%--                                </button>--%>
<%--                            </div>--%>
<%--                        </c:when>--%>
<%--                        <c:otherwise>--%>
<%--                            无药品--%>
<%--                        </c:otherwise>--%>
<%--                    </c:choose>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </c:forEach>--%>
<%--    </c:when>--%>
<%--    <c:otherwise>--%>
<%--        <h2>暂无患者缴费</h2>--%>
<%--    </c:otherwise>--%>
<%--</c:choose>--%>
<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    function confirmDrug(registerId) {
        var con = confirm("确认安排病床？");
        if(con){
            var inputRegisterId = $("#registerid").val();
            if (inputRegisterId !== "" &&inputRegisterId !== undefined) {
                $.ajax({
                    url: "ConfirmDrugServlet",
                    type: "POST",
                    dataType: "JSON",
                    data: {"registerid": registerId, "inregisterid": inputRegisterId},
                    success: function (res) {
                        if (res.result === 1) {
                            // alert("成功！");
                            $(".indrug" + registerId).remove();
                            $(".success" + registerId).show();
                        } else {
                            alert("失败！");
                        }
                    },
                    error: function () {
                        alert("出错！");
                    }
                });
            }
        }else{
            alert("请输入挂号单！");
        }
    }
</script>
</body>
</html>
