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
</head>
<body>
<header>
    <h1>欢迎登陆${guidanceType}</h1>
    <p>输入预约单号，确定，生成挂号单号</p>
</header>
<section>
    <div>
        <form id="register-form" method="post" action="registersubcribe">
            <input placeholder="预约单号" type="text" name="subcribeid">
            <button onclick="release()" type="button">确定</button>
        </form>
        <!-- 单击确定，生成挂号单，进入排队等待 -->

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
    <h2>挂号队列</h2>
    <table>
        <tr>
            <td>挂号单号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>年龄</td>
            <td>医生</td>
        </tr>
        <c:if test="${!empty registerList}">
            <c:forEach items="${registerList}"  var="item">
                <tr>
                    <td>${item.regi_id}</td>
                    <td>${item.pati_name}</td>
                    <td>${item.pati_gen}</td>
                    <td>${item.pati_age}</td>
                    <td>${item.clin_name}</td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</section>
<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    <%--if(!(${result} isUndefined)){--%>
    <%--    --%>
    <%--}--%>

    function release(){
        var rele = confirm();
        if(rele){
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
