<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<jsp:useBean id="patientProgress" scope="request" type="com.hezhuangzi.entity.SubcRegiCasePres"/>--%>

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
    <%--
        private PatientSubcribe patientSubcribe; //预约 包含了所有的信息
        private PatientRegister patientRegister; //挂号单
        private PatientCaseHistory patientCaseHistory; //病历
        private PatientPrescription patientPrescription; //处方
        private List<OrderDrug> orderDrugList; //处方的药品
    --%>

<%--    进度面板--%>
    <div class="main w">
        <c:choose>
<%--            <jsp:useBean id="patientProgress" scope="request" type="com.hezhuangzi.entity.SubcRegiCasePres"/>--%>
            <c:when test="${!empty patientProgress}">
                <%-- 查询预约单号的模块 --%>
                <c:choose>
                    <c:when test="${!empty patientProgress.patientSubcribe}">
                        <div class="continer">
                            <h2>预约单号</h2>
                            <p>预约单号：${patientProgress.patientSubcribe.subc_id}</p>
                            <p>预约创建时间：${patientProgress.patientSubcribe.subc_createtime}</p>
                            <p>患者编号：${patientProgress.patientSubcribe.pati_id}</p>
                            <p>患者姓名：${patientProgress.patientSubcribe.pati_name}</p>
                            <p>患者年龄：${patientProgress.patientSubcribe.pati_age}</p>
                            <p>患者性别：${patientProgress.patientSubcribe.pati_gen}</p>
                            <p>科室：${patientProgress.patientSubcribe.clin_post}</p>
                            <p>医生姓名：${patientProgress.patientSubcribe.clin_name}</p>
                            <p>日期：${patientProgress.patientSubcribe.arra_subdate}</p>
                            <p>时间：${patientProgress.patientSubcribe.arra_ampm}</p>
                            <c:if test="${patientProgress.patientSubcribe.subc_cancel == 1}">
                                <p>已取消</p>
                            </c:if>
                            <c:if test="${breakTime}">
                                <p>已爽约</p>
                            </c:if>
                        </div>
                        <c:if test="${cancel}">
                            <a href="cancelsubcribe?subcId=${patientProgress.patientSubcribe.subc_id}">取消预约</a>
                        </c:if>

                    </c:when>
                    <c:otherwise>
                        <div class="continer">
                            <h2>预约单</h2>
                            暂无
                        </div>
                    </c:otherwise>
                </c:choose>

                <%-- 查询挂号单的模块 --%>
                <c:choose>
                    <c:when test="${!empty patientProgress.patientRegister}">
                        <div class="continer">
                            <h2>挂号单</h2>
                            <p>挂号单号：${patientProgress.patientRegister.regi_id}</p>
                            <p>挂号创建时间：${patientProgress.patientRegister.regi_createtime}</p>
                            <p>打印人员：${patientProgress.patientRegister.regi_clin_id}</p>
                            <p>患者编号：${patientProgress.patientSubcribe.pati_id}</p>
                            <p>患者姓名：${patientProgress.patientSubcribe.pati_name}</p>
                            <p>患者年龄：${patientProgress.patientSubcribe.pati_age}</p>
                            <p>患者性别：${patientProgress.patientSubcribe.pati_gen}</p>
                            <p>科室：${patientProgress.patientSubcribe.clin_post}</p>
                            <p>医生姓名：${patientProgress.patientSubcribe.clin_name}</p>
                            <p>日期：${patientProgress.patientSubcribe.arra_subdate}</p>
                            <p>时间：${patientProgress.patientSubcribe.arra_ampm}</p>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="continer">
                            <h2>挂号单</h2>
                            暂无
                        </div>
                    </c:otherwise>
                </c:choose>

                <%-- 查询病历的模块 --%>
                <c:choose>
                    <c:when test="${!empty patientProgress.patientCaseHistory}">
                        <div class="continer">
                            <h2>病历单</h2>
                            <p>病历单号：${patientProgress.patientCaseHistory.case_id}</p>
                            <p>病历创建时间：${patientProgress.patientCaseHistory.case_createtime}</p>
                            <p>患者编号：${patientProgress.patientSubcribe.pati_id}</p>
                            <p>患者姓名：${patientProgress.patientSubcribe.pati_name}</p>
                            <p>患者年龄：${patientProgress.patientSubcribe.pati_age}</p>
                            <p>患者性别：${patientProgress.patientSubcribe.pati_gen}</p>
                            <p>科室：${patientProgress.patientSubcribe.clin_post}</p>
                            <p>医生姓名：${patientProgress.patientSubcribe.clin_name}</p>
                            <p>日期：${patientProgress.patientSubcribe.arra_subdate}</p>
                            <p>时间：${patientProgress.patientSubcribe.arra_ampm}</p>
                            <p>病历录入日期：${patientProgress.patientCaseHistory.case_date}</p>
                            <p>现病史：${patientProgress.patientCaseHistory.case_hpi}</p>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="continer">
                            <h2>病历单</h2>
                            暂无
                        </div>
                    </c:otherwise>
                </c:choose>

                <%-- 查询处方的模块 --%>
                <c:choose>
                    <c:when test="${!empty patientProgress.patientPrescription}">
                        <div class="continer">
                            <h2>处方单</h2>
                            <p>处方单号：${patientProgress.patientPrescription.pres_id}</p>
                            <p>处方创建时间：${patientProgress.patientPrescription.pres_createtime}</p>
                            <p>患者编号：${patientProgress.patientSubcribe.pati_id}</p>
                            <p>患者姓名：${patientProgress.patientSubcribe.pati_name}</p>
                            <p>患者年龄：${patientProgress.patientSubcribe.pati_age}</p>
                            <p>患者性别：${patientProgress.patientSubcribe.pati_gen}</p>
                            <p>科室：${patientProgress.patientSubcribe.clin_post}</p>
                            <p>医生姓名：${patientProgress.patientSubcribe.clin_name}</p>
                            <p>日期：${patientProgress.patientSubcribe.arra_subdate}</p>
                            <p>时间：${patientProgress.patientSubcribe.arra_ampm}</p>
                            <p>诊断：${patientProgress.patientPrescription.pres_diag}</p>
                            <p>药品：
                                <c:forEach items="${patientProgress.orderDrugList}" var="item">
                                    <p><c:out value="${item.drug_name}"/></p>
                                    <p><c:out value="${item.drug_num}"/></p>
                                    <p><c:out value="${item.drug_price}"/></p>
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