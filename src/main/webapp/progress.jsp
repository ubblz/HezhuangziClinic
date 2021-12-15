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

    <link rel="icon" type="image/png" href="https://pic.imgdb.cn/item/61b497192ab3f51d910ba7e0.png" />
    <!-- Bootstrap 的 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="assets/css/bold.css">
</head>
<body>
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
                    <i class="bi bi-box-arrow-right">
                    </i>
                </a>
            </h2>
        </div>
    </div>
</div>
<div class="container bg-primary rounded-lg mb-4">
    <div class="row text-center">
        <div class="col mt-2">
            <h3><a href="patientinfo" class="text-decoration-none text-light">个人信息</a></h3>
        </div>
        <div class="col m-2">
            <h3><a href="subcribe" class="text-decoration-none text-light">预约挂号</a></h3>
        </div>
        <div class="col m-2">
            <h3><a href="" class="text-decoration-none text-light bolder">进度查询</a></h3>

        </div>
    </div>
</div>

<!--  预约单号 -->
<c:choose>
    <%--            <jsp:useBean id="patientProgress" scope="request" type="com.hezhuangzi.entity.SubcRegiCasePres"/>--%>
    <c:when test="${!empty patientProgress}">
        <%-- 查询预约单号的模块 --%>
        <c:choose>
            <c:when test="${!empty patientProgress.patientSubcribe}">
                <div class="container mt-2 rounded shadow">
                    <div class="row bg-light">
                        <div class="col">
                            <h2 class="h2 text-center">预约单号</h2>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col text-center">
                            <h4>预约单号：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientSubcribe.subc_id}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>预约创建时间：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientSubcribe.subc_createtime}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>患者编号：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientSubcribe.pati_id}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>患者姓名：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientSubcribe.pati_name}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>患者年龄：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientSubcribe.pati_age}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>患者性别：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientSubcribe.pati_gen}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>医生职称：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientSubcribe.clin_post}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>医生姓名：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientSubcribe.clin_name}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>日期：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientSubcribe.arra_subdate}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>时间：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientSubcribe.arra_ampm}</label>
                        </div>
                    </div>
                    <c:if test="${patientProgress.patientSubcribe.subc_cancel == 1}">
                        <div class="row">
                            <div class="col text-center">
                                <h4>已取消预约</h4>
                            </div>
                                <%--                <div class="col">--%>
                                <%--                    <label for="" class="text-left">${patientProgress.patientSubcribe.arra_ampm}</label>--%>
                                <%--                </div>--%>
                        </div>
                    </c:if>
                    <c:if test="${breakTime}">
                        <div class="row">
                            <div class="col text-center">
                                <h4>已爽约</h4>
                            </div>
                        </div>
                    </c:if>
                </div>
                <c:if test="${cancel}">
                    <div class="row">
                        <div class="col"></div>
                        <div class="col text-left mb-3">
                            <a href="cancelsubcribe?subcId=${patientProgress.patientSubcribe.subc_id}">
                                <button class="btn btn-danger">取消预约</button>
                            </a>
                        </div>
                    </div>
                </c:if>
            </c:when>
            <c:otherwise>
                <div class="row bg-light">
                    <div class="col">
                        <h2 class="h2 text-center">预约单</h2>
                    </div>
                </div>
                <div class="row">
                    <div class="text-left">
                        <h3 for="">暂无</h3>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>
        <!-- 挂号单 -->


        <div class="container mt-4 rounded shadow">
            <c:choose>
                <c:when test="${patientProgress.patientRegister != null}">
                    <div class="row bg-light">
                        <div class="col">
                            <h2 class="h2 text-center">挂号单</h2>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>挂号单号：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientRegister.regi_id}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>挂号创建时间：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientRegister.regi_createtime}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>打印人员：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientRegister.regi_clin_id}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>患者编号：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientSubcribe.pati_id}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>患者姓名：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientSubcribe.pati_name}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>患者年龄：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientSubcribe.pati_age}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>患者性别：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientSubcribe.pati_gen}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>医生职称：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientSubcribe.clin_post}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>医生姓名：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientSubcribe.clin_name}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>日期：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientSubcribe.arra_subdate}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>时间：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientSubcribe.arra_ampm}</label>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="row bg-light">
                        <div class="col">
                            <h2 class="h2 text-center">挂号单</h2>
                        </div>
                    </div>
                    <div class="row">
                        <div class="text-left">
                            <h3 for="">暂无</h3>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>


        <!-- 病历单 -->


        <div class="container mt-4 rounded shadow">
            <c:choose>
                <c:when test="${patientProgress.patientCaseHistory != null}">

                    <div class="row bg-light">
                        <div class="col">
                            <h2 class="h2 text-center">病历单</h2>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>病历单号：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientCaseHistory.case_id}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>病历创建时间：</h4>
                        </div>
                        <div class="col">
                            <label for=""
                                   class="text-left">：${patientProgress.patientCaseHistory.case_createtime}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>患者编号：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientSubcribe.pati_id}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>患者姓名：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientSubcribe.pati_name}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>患者年龄：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientSubcribe.pati_age}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>患者性别：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientSubcribe.pati_gen}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>医生职称：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientSubcribe.clin_post}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>医生姓名：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientSubcribe.clin_name}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>日期：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientSubcribe.arra_subdate}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>时间：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientSubcribe.arra_ampm}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>病历录入日期：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientCaseHistory.case_date}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>现病史：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientCaseHistory.case_hpi}</label>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="row bg-light">
                        <div class="col">
                            <h2 class="h2 text-center">病历单</h2>
                        </div>
                    </div>
                    <div class="row">
                        <div class="text-left">
                            <h3 for="">暂无</h3>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>

        </div>

        <!-- 处方单 -->


        <div class="container mt-4 rounded shadow">
            <c:choose>
                <c:when test="${patientProgress.patientPrescription != null}">

                    <div class="row bg-light">
                        <div class="col">
                            <h2 class="h2 text-center">处方单</h2>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>处方单号：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientPrescription.pres_id}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>处方创建时间：</h4>
                        </div>
                        <div class="col">
                            <label for=""
                                   class="text-left">${patientProgress.patientPrescription.pres_createtime}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>患者编号：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientSubcribe.pati_id}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>患者姓名：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientSubcribe.pati_name}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>患者年龄：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientSubcribe.pati_age}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>患者性别：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientSubcribe.pati_gen}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>医生职称：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientSubcribe.clin_post}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>医生姓名：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientSubcribe.clin_name}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>日期：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientSubcribe.arra_subdate}</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <h4>时间：</h4>
                        </div>
                        <div class="col">
                            <label for="" class="text-left">${patientProgress.patientSubcribe.arra_ampm}</label>
                        </div>
                    </div>
<%--                    <div class="row">--%>
<%--                        <div class="col text-center">--%>
<%--                            <h4>诊断：</h4>--%>
<%--                        </div>--%>
<%--                        <div class="col">--%>
<%--                            <label for="" class="text-left">${patientProgress.patientPrescription.pres_diag}</label>--%>
<%--                        </div>--%>
<%--                    </div>--%>
                    <div class="row">
                        <div class="col text-center">
                            <h4>药品：</h4>
                        </div>
                        <div class="col">
                            <table class="table text-center">
                                <tbody class="thead-light">
                                <c:forEach items="${patientProgress.orderDrugList}" var="item">
                                <tr>
                                    <th>药品名称</th>
                                    <td>${item.drug_name}</td>
                                </tr>
                                </tbody>
                                <tbody class="thead-light">
                                <tr>
                                    <th>数量</th>
                                    <td>${item.drug_num}</td>
                                </tr>
                                </tbody>
                                <tbody class="thead-light">
                                <tr>
                                    <th>单价</th>
                                    <td>${item.drug_price}</td>
                                </tr>

                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="row bg-light">
                        <div class="col">
                            <h2 class="h2 text-center">处方单</h2>
                        </div>
                    </div>
                    <div class="row">
                        <div class="text-left">
                            <h3 for="">暂无</h3>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </c:when>
    <c:otherwise>
        <div class="row bg-light">
            <div class="col">
                <h2 class="h2 text-center">暂无预约信息</h2>
            </div>
        </div>
        <%--        <div class="row">--%>
        <%--            <div class="text-left">--%>
        <%--                <h3 for="">暂无</h3>--%>
        <%--            </div>--%>
        <%--        </div>--%>
    </c:otherwise>
</c:choose>


<div class="container mt-3">
    <div class="row">
        <c:if test="${next}">
            <div class="col text-right mr-3">
                <a href="?start=${start+1}">
                    <button class="btn btn-info" type="submit">下一记录</button>
                </a>
            </div>
        </c:if>

        <c:if test="${pre}">
            <div class="col text-left ml-3">
                <a href="?start=${start-1}">
                    <button class="btn btn-info" type="submit">上一记录</button>
                </a>
            </div>
        </c:if>
    </div>
</div>

<script src="assets/modules/jquery/dist/jquery.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous">
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous">
</script>


<%--<div class="continer">--%>

<%--    &lt;%&ndash;    <%@ include file="patientheader.jsp"%>&ndash;%&gt;--%>


<%--    <div class="nav ">--%>
<%--        <div class="nav-list w">--%>
<%--            <a href="patientinfo">个人信息</a>--%>
<%--            <a href="subcribe">预约挂号</a>--%>
<%--            <a href="progress" style="color: #2B81D5; font-weight: bold;">进度查询</a>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    &lt;%&ndash;--%>
<%--        private PatientSubcribe patientSubcribe; //预约 包含了所有的信息--%>
<%--        private PatientRegister patientRegister; //挂号单--%>
<%--        private PatientCaseHistory patientCaseHistory; //病历--%>
<%--        private PatientPrescription patientPrescription; //处方--%>
<%--        private List<OrderDrug> orderDrugList; //处方的药品--%>
<%--    &ndash;%&gt;--%>

<%--    &lt;%&ndash;    进度面板&ndash;%&gt;--%>
<%--    <div class="main w">--%>
<%--        <c:choose>--%>
<%--            &lt;%&ndash;            <jsp:useBean id="patientProgress" scope="request" type="com.hezhuangzi.entity.SubcRegiCasePres"/>&ndash;%&gt;--%>
<%--            <c:when test="${!empty patientProgress}">--%>
<%--                &lt;%&ndash; 查询预约单号的模块 &ndash;%&gt;--%>
<%--                <c:choose>--%>
<%--                    <c:when test="${!empty patientProgress.patientSubcribe}">--%>
<%--                        <div class="continer">--%>
<%--                            <h2>预约单号</h2>--%>
<%--                            <p>预约单号：${patientProgress.patientSubcribe.subc_id}</p>--%>
<%--                            <p>预约创建时间：${patientProgress.patientSubcribe.subc_createtime}</p>--%>
<%--                            <p>患者编号：${patientProgress.patientSubcribe.pati_id}</p>--%>
<%--                            <p>患者姓名：${patientProgress.patientSubcribe.pati_name}</p>--%>
<%--                            <p>患者年龄：${patientProgress.patientSubcribe.pati_age}</p>--%>
<%--                            <p>患者性别：${patientProgress.patientSubcribe.pati_gen}</p>--%>
<%--                            <p>科室：${patientProgress.patientSubcribe.clin_post}</p>--%>
<%--                            <p>医生姓名：${patientProgress.patientSubcribe.clin_name}</p>--%>
<%--                            <p>日期：${patientProgress.patientSubcribe.arra_subdate}</p>--%>
<%--                            <p>时间：${patientProgress.patientSubcribe.arra_ampm}</p>--%>
<%--                            <c:if test="${patientProgress.patientSubcribe.subc_cancel == 1}">--%>
<%--                                <p>已取消</p>--%>
<%--                            </c:if>--%>
<%--                            <c:if test="${breakTime}">--%>
<%--                                <p>已爽约</p>--%>
<%--                            </c:if>--%>
<%--                        </div>--%>

<%--                        <c:if test="${cancel}">--%>
<%--                            <a href="cancelsubcribe?subcId=${patientProgress.patientSubcribe.subc_id}">取消预约</a>--%>
<%--                        </c:if>--%>

<%--                    </c:when>--%>
<%--                    <c:otherwise>--%>
<%--                        <div class="continer">--%>
<%--                            <h2>预约单</h2>--%>
<%--                            暂无--%>
<%--                        </div>--%>
<%--                    </c:otherwise>--%>
<%--                </c:choose>--%>

<%--                &lt;%&ndash; 查询挂号单的模块 &ndash;%&gt;--%>
<%--                <c:choose>--%>
<%--                    <c:when test="${patientProgress.patientRegister != null}">--%>
<%--                        <div class="continer">--%>
<%--                            <h2>挂号单</h2>--%>
<%--                            <p>挂号单号：${patientProgress.patientRegister.regi_id}</p>--%>
<%--                            <p>挂号创建时间：${patientProgress.patientRegister.regi_createtime}</p>--%>
<%--                            <p>打印人员：${patientProgress.patientRegister.regi_clin_id}</p>--%>
<%--                            <p>患者编号：${patientProgress.patientSubcribe.pati_id}</p>--%>
<%--                            <p>患者姓名：${patientProgress.patientSubcribe.pati_name}</p>--%>
<%--                            <p>患者年龄：${patientProgress.patientSubcribe.pati_age}</p>--%>
<%--                            <p>患者性别：${patientProgress.patientSubcribe.pati_gen}</p>--%>
<%--                            <p>科室：${patientProgress.patientSubcribe.clin_post}</p>--%>
<%--                            <p>医生姓名：${patientProgress.patientSubcribe.clin_name}</p>--%>
<%--                            <p>日期：${patientProgress.patientSubcribe.arra_subdate}</p>--%>
<%--                            <p>时间：${patientProgress.patientSubcribe.arra_ampm}</p>--%>
<%--                        </div>--%>
<%--                    </c:when>--%>
<%--                    <c:otherwise>--%>
<%--                        <div class="continer">--%>
<%--                            <h2>挂号单</h2>--%>
<%--                            暂无--%>
<%--                        </div>--%>
<%--                    </c:otherwise>--%>
<%--                </c:choose>--%>

<%--                &lt;%&ndash; 查询病历的模块 &ndash;%&gt;--%>
<%--                <c:choose>--%>
<%--                    <c:when test="${patientProgress.patientCaseHistory != null}">--%>
<%--                        <div class="continer">--%>
<%--                            <h2>病历单</h2>--%>
<%--                            <p>病历单号：${patientProgress.patientCaseHistory.case_id}</p>--%>
<%--                            <p>病历创建时间：${patientProgress.patientCaseHistory.case_createtime}</p>--%>
<%--                            <p>患者编号：${patientProgress.patientSubcribe.pati_id}</p>--%>
<%--                            <p>患者姓名：${patientProgress.patientSubcribe.pati_name}</p>--%>
<%--                            <p>患者年龄：${patientProgress.patientSubcribe.pati_age}</p>--%>
<%--                            <p>患者性别：${patientProgress.patientSubcribe.pati_gen}</p>--%>
<%--                            <p>科室：${patientProgress.patientSubcribe.clin_post}</p>--%>
<%--                            <p>医生姓名：${patientProgress.patientSubcribe.clin_name}</p>--%>
<%--                            <p>日期：${patientProgress.patientSubcribe.arra_subdate}</p>--%>
<%--                            <p>时间：${patientProgress.patientSubcribe.arra_ampm}</p>--%>
<%--                            <p>病历录入日期：${patientProgress.patientCaseHistory.case_date}</p>--%>
<%--                            <p>现病史：${patientProgress.patientCaseHistory.case_hpi}</p>--%>
<%--                        </div>--%>
<%--                    </c:when>--%>
<%--                    <c:otherwise>--%>
<%--                        <div class="continer">--%>
<%--                            <h2>病历单</h2>--%>
<%--                            暂无--%>
<%--                        </div>--%>
<%--                    </c:otherwise>--%>
<%--                </c:choose>--%>

<%--                &lt;%&ndash; 查询处方的模块 &ndash;%&gt;--%>
<%--                <c:choose>--%>
<%--                    <c:when test="${patientProgress.patientPrescription != null}">--%>
<%--                        <div class="continer">--%>
<%--                            <h2>处方单</h2>--%>
<%--                            <p>处方单号：${patientProgress.patientPrescription.pres_id}</p>--%>
<%--                            <p>处方创建时间：${patientProgress.patientPrescription.pres_createtime}</p>--%>
<%--                            <p>患者编号：${patientProgress.patientSubcribe.pati_id}</p>--%>
<%--                            <p>患者姓名：${patientProgress.patientSubcribe.pati_name}</p>--%>
<%--                            <p>患者年龄：${patientProgress.patientSubcribe.pati_age}</p>--%>
<%--                            <p>患者性别：${patientProgress.patientSubcribe.pati_gen}</p>--%>
<%--                            <p>科室：${patientProgress.patientSubcribe.clin_post}</p>--%>
<%--                            <p>医生姓名：${patientProgress.patientSubcribe.clin_name}</p>--%>
<%--                            <p>日期：${patientProgress.patientSubcribe.arra_subdate}</p>--%>
<%--                            <p>时间：${patientProgress.patientSubcribe.arra_ampm}</p>--%>
<%--                            <p>诊断：${patientProgress.patientPrescription.pres_diag}</p>--%>
<%--                            <p>药品：--%>
<%--                                <c:forEach items="${patientProgress.orderDrugList}" var="item">--%>
<%--                            <p><c:out value="${item.drug_name}"/></p>--%>
<%--                            <p><c:out value="${item.drug_num}"/></p>--%>
<%--                            <p><c:out value="${item.drug_price}"/></p>--%>
<%--                            </c:forEach>--%>
<%--                            </p>--%>
<%--                        </div>--%>
<%--                    </c:when>--%>
<%--                    <c:otherwise>--%>
<%--                        <div class="continer">--%>
<%--                            <h2>处方单</h2>--%>
<%--                            暂无--%>
<%--                        </div>--%>
<%--                    </c:otherwise>--%>
<%--                </c:choose>--%>

<%--            </c:when>--%>
<%--            <c:otherwise>--%>
<%--                <div class="continer">--%>
<%--                    暂无预约记录--%>
<%--                </div>--%>
<%--            </c:otherwise>--%>
<%--        </c:choose>--%>

<%--        <c:if test="${next}">--%>
<%--            <a href="?start=${start+1}">下一记录</a>--%>
<%--        </c:if>--%>

<%--        <c:if test="${pre}">--%>
<%--            <a href="?start=${start-1}">上一记录</a>--%>
<%--        </c:if>--%>
<%--    </div>--%>
<%--</div>--%>

</body>
</html>