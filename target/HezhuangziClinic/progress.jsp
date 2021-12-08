<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<jsp:useBean id="patientProgress" scope="request" type="com.hezhuangzi.entity.SubCasehisPres"/>--%>

<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>进度查询</title>
    <link rel="stylesheet" href="css/subscribe.css">
    <link rel="stylesheet" href="css/progress.css">

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
            <a href="patientinfo" >个人信息</a>
            <a href="subcribe">预约挂号</a>
            <a href="" style="color: #2B81D5; font-weight: bold;">进度查询</a>
        </div>
    </div>

<%--    进度面板--%>
    <div class="main w">
        <c:choose>
            <c:when test="${!empty patientProgress}">
                    <div class="continer">
                        <h2>预约单号</h2>
                        <p>预约单号：${patientProgress.patientSubcribe.subcribeId}</p>
                        <p>预约创建时间：${patientProgress.patientSubcribe.createTime}</p>
                        <p>患者编号：${patientProgress.patientInfo.patientId}</p>
                        <p>患者姓名：${patientProgress.patientInfo.name}</p>
                        <p>患者年龄：${patientProgress.patientInfo.age}</p>
                        <p>患者性别：${patientProgress.patientInfo.gen}</p>
                        <p>医生姓名：${patientProgress.doctorInfo.cname}</p>
                        <p>科室：${patientProgress.doctorInfo.post}</p>
                        <p>日期：${patientProgress.patientSubcribe.subTime}</p>
                        <p>时间：${patientProgress.patientSubcribe.ampm}</p>
                    </div>
                <c:if test="${cancel}">
                    <a href="cancelsubcribe?cancel=${patientProgress.patientSubcribe.subcribeId}">取消预约</a>
                </c:if>

                <c:choose>
                    <c:when test="${!empty patientProgress.patientCaseHistory}">
                        <div class="continer">
                            <h2>病历单</h2>
                            <p>病历单号：${patientProgress.patientCaseHistory.csId}</p>
                            <p>病历创建时间：${patientProgress.patientCaseHistory.createTime}</p>
                            <p>患者姓名：${patientProgress.patientInfo.name}</p>
                            <p>医生姓名：${patientProgress.doctorInfo.cname}</p>
                            <p>时间：${patientProgress.patientCaseHistory.retime}</p>
                            <p>现病史：${patientProgress.patientCaseHistory.hpi}</p>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="continer">
                            <h2>病历单</h2>
                            暂无
                        </div>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${!empty patientProgress.patientPrescription}">
                        <div class="continer">
                            <h2>处方单</h2>
                            <p>处方单号：${patientProgress.patientPrescription.presId}</p>
                            <p>处方创建时间：${patientProgress.patientPrescription.createTime}</p>
                            <p>患者姓名：${patientProgress.patientInfo.name}</p>
                            <p>医生姓名：${patientProgress.doctorInfo.cname}</p>
                            <p>诊断：${patientProgress.patientPrescription.diag}</p>
                            <p>药品：
                                <c:forEach items="${patientProgress.orderDrugList}" var="item">
                                    <p><c:out value="${item.drugName}"/></p>
                                    <p><c:out value="${item.num}"/></p>
                                    <p><c:out value="${item.drugPrice}"/></p>
                                </c:forEach>
                            </p>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="continer">
                            <h2>处方单</h2>
                            暂无
                        </div>
                    </c:otherwise>
                </c:choose>

            </c:when>
            <c:otherwise>
                <div class="continer">
                   暂无预约记录
                </div>
            </c:otherwise>
        </c:choose>
        <c:if test="${next}">
            <a href="?start=${start+1}">下一记录</a>
        </c:if>

        <c:if test="${pre}">
            <a href="?start=${start-1}">上一记录</a>
        </c:if>
    </div>
</div>
</body>
</html>