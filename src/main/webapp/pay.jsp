<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hhrx
  Date: 2021/12/13
  Time: 下午4:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>缴费平台</title>
    <link rel="stylesheet" href="css/pay.css">
    <link rel="icon" type="image/png" href="https://pic.imgdb.cn/item/61b497192ab3f51d910ba7e0.png" />
<%--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">--%>
<%--    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>--%>
<%--    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>--%>
</head>
<body>
<div class="main">

    <div class="header">
        <img src="https://pic.imgdb.cn/item/61b497192ab3f51d910ba7e0.png"
             style="width: 60px; height: 60px;">

        <h1>何庄子诊所</h1>
    </div>
    <h1 class="title">自助缴费系统</h1>
    <form  id="pay-form" action="PayServlet" method="get">
        <div><span class="remainder">请输入挂号单号：</span><input type="text" id="register-num" name="registerid">
            <button type="submit">确定</button>
        </div>
    </form>
    <hr>
    <div class="display">
        <c:if test="${flag == 1}">
            <c:choose>
                <%--    <jsp:useBean id="regi" scope="request" type="com.hezhuangzi.entity.PatientRegister"/>--%>
                <c:when test="${!empty regi}">
                    <%--        <jsp:useBean id="pres" scope="request" type="com.hezhuangzi.entity.PatientPrescription"/>--%>
                    <div class="info">
                        <h3><span>挂号单号：</span>${regi.regi_id}</h3>
                        <h3><span>患者：</span>${regi.pati_name}</h3>
                        <h3><span>医生：</span>${regi.clin_name}</h3>
                    </div>
                    <c:choose>
                        <c:when test="${!empty pres}">
                            <div class="pres-main">
                                <h3 class="pres-info"><span>处方单: </span> <span class="pres-id">${pres.pres_id}</span>&nbsp;&nbsp;&nbsp;&nbsp;  <span>缴费明细：</span></h3>
                                    <%--            <jsp:useBean id="order" scope="request" type="com.hezhuangzi.entity.OrderDrug"/>--%>
                                <c:choose>
                                    <c:when test="${!empty order}">
                                        <table class="pay-table">
                                            <tr >
                                                <th>药品编号</th>
                                                <th>药品名称</th>
                                                <th>单价</th>
                                                <th>数量</th>
                                            </tr>
                                            <c:forEach items="${order}" var="drug">
                                                <tr>
                                                    <td>${drug.drug_id}</td>
                                                    <td>${drug.drug_name}</td>
                                                    <td>${drug.drug_price}</td>
                                                    <td>${drug.order_num}</td>
                                                </tr>
                                            </c:forEach>
                                        </table>
                                        <p class="price">总价格：<span>${priceSum}</span></p>
                                        <div class="confirm-paybtn">
                                            <button type="button" onclick="patientPay(${pres.pres_id})">支付</button>
                                            <a href="pay.jsp"><button >取消</button></a>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <h3>无药品清单,无需支付费用</h3>
                                    </c:otherwise>
                                </c:choose>

                            </div>
                        </c:when>
                        <c:otherwise>
                            <h3>此单号无支付信息！</h3>
                        </c:otherwise>
                    </c:choose>
                </c:when>
                <c:otherwise>
                    <h3>无此单号</h3>
                </c:otherwise>
            </c:choose>
        </c:if>
    </div>
</div>

<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script>
    function patientPay(presId) {
        var c = confirm("确认支付？");
        if (c) {
            $.ajax({
                url: "ConfirmPayServlet",
                type: "POST",
                data: {"presid": presId},
                dataType: "JSON",
                success: function (res) {
                    if (res.result === 1) {
                        $(".confirm-paybtn").empty();
                        $(".confirm-paybtn").append("<p class='pay-success'>支付成功</p>")
                        alert("支付成功！");
                    } else if (res.result === 2) {
                        alert("支付失败！");
                    } else {
                        alert("支付出错！");
                    }
                },
                error: function () {
                    alert("支付出错！");
                }
            })
        }
    }
</script>


</body>
</html>
