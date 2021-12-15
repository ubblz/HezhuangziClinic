<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hhrx
  Date: 2021/12/11
  Time: 上午7:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>${guidanceType}</title>
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
                <span>${guidanceType}</span>
            </h2>
        </div>
        <div class="col text-right">
            <h2>
                <span>欢迎</span>
                <span>工号</span>
                <label>xxx</label>
            </h2>
        </div>
        <div class="col text-left">
            <h2>
                <a href=""><i class="bi bi-box-arrow-right"></i></a>
            </h2>
        </div>
    </div>
</div>

<div class="container mb-3 list-group-item shadow">
    <form id="register-form" method="post" action="registersubcribe">
        <div class="row ">
            <div class="col">
                <c:choose>
                    <c:when test="${result == 0}">
                        <p>挂号出错！</p>
                    </c:when>
                    <c:when test="${result == 1}">
                        <p>挂号成功！</p>
                    </c:when>
                    <c:when test="${result == 2}">
                        <p>该预约号码已登记或者无此预约号码！</p>
                    </c:when>
                </c:choose>
            </div>
            <input class="form-control col-4 mr-4" type="text" name="subcribeid" id="" placeholder="输入患者挂号单号" required>
            <button onclick="release()" type="button" class="btn btn-success col-1 mr-4" type="button">确认</button>
        </div>
    </form>
</div>


<div class="container list-group-item ">
    <div class="row ">
        <!-- 患者挂号表 -->
        <table class="col table text-center shadow rounded mr-3">
            <thead class="thead-dark">
            <tr>
                <th scope="col">预约单号</th>
                <th scope="col">挂号单号</th>
                <th scope="col">姓名</th>
                <th scope="col">性别</th>
                <th scope="col">年龄</th>
                <th scope="col">医生</th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${!empty registerList}">
                <c:forEach items="${registerList}" var="item">
                    <tr>
                        <td>${item.subc_id}</td>
                        <td>${item.regi_id}</td>
                        <td>${item.pati_name}</td>
                        <td>${item.pati_gen}</td>
                        <td>${item.pati_age}</td>
                        <td>${item.clin_name}</td>
                    </tr>
                </c:forEach>
            </c:if>
            </tbody>
        </table>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous">
</script>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
</script>


<%--<header>--%>
<%--    <h1>欢迎登陆${guidanceType}</h1>--%>
<%--    <p>输入预约单号，确定，生成挂号单号</p>--%>
<%--</header>--%>
<%--<section>--%>
<%--    <div>--%>
<%--        <form id="register-form" method="post" action="registersubcribe">--%>
<%--            <input placeholder="预约单号" type="text" name="subcribeid">--%>
<%--            <button onclick="release()" type="button">确定</button>--%>
<%--        </form>--%>
<%--        <!-- 单击确定，生成挂号单，进入排队等待 -->--%>

<%--        <c:choose>--%>
<%--            <c:when test="${result == 0}">--%>
<%--                <p>挂号出错！</p>--%>
<%--            </c:when>--%>
<%--            <c:when test="${result == 1}">--%>
<%--                <p>挂号成功！</p>--%>
<%--            </c:when>--%>
<%--            <c:when test="${result == 2}">--%>
<%--                <p>该预约号码已登记或者无此预约号码！</p>--%>
<%--            </c:when>--%>
<%--        </c:choose>--%>

<%--    </div>--%>
<%--    <h2>挂号队列</h2>--%>
<%--    <table>--%>
<%--        <tr>--%>
<%--            <td>挂号单号</td>--%>
<%--            <td>姓名</td>--%>
<%--            <td>性别</td>--%>
<%--            <td>年龄</td>--%>
<%--            <td>医生</td>--%>
<%--        </tr>--%>
<%--        <c:if test="${!empty registerList}">--%>
<%--            <c:forEach items="${registerList}"  var="item">--%>
<%--                <tr>--%>
<%--                    <td>${item.regi_id}</td>--%>
<%--                    <td>${item.pati_name}</td>--%>
<%--                    <td>${item.pati_gen}</td>--%>
<%--                    <td>${item.pati_age}</td>--%>
<%--                    <td>${item.clin_name}</td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>
<%--        </c:if>--%>
<%--    </table>--%>
<%--</section>--%>


<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    <%--if(!(${result} isUndefined)){--%>
    <%--    --%>
    <%--}--%>

    function release() {
        var rele = confirm("确认挂号？");
        if (rele) {
            $("#register-form").submit();
        }
    }


    // function release(){
    //     $.ajax({
    //         url:"",
    //         type:"POST",
    //         data:$("#"),
    //         dataType:"JSON",
    //         success:function (res){
    //
    //         },
    //         error:function(){
    //
    //         }
    //     })
    // }
</script>

</body>
</html>
