<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hhrx
  Date: 2021/12/9
  Time: 下午4:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
  <title>科室管理</title>
</head>
<body>
<h1>欢迎 科室管理员 登录</h1>

<a href="sectoradmin">安排就诊</a>
<a href="sectormodify">修改就诊</a>
<h2>已安排的医生名单</h2>
<%--<h3>搜索</h3>--%>
<%--日期：<input type="date" name="date" > 姓名：<input type="text" name="cname">--%>
<%--时间：<select name="time">--%>
<%--  <option value="am">上午</option>--%>
<%--  <option value="pm">下午</option>--%>
<%--</select>--%>
<%--<input type="button" name="search" value="搜索">--%>
<%--<h3>医生名单</h3>--%>
<table>
  <%--
  <td>${item.arrangeId}</td>
      <td>${item.clinicId}</td>
      <td>${item.cname}</td>
      <td>${item.gen}</td>
      <td>${item.age}</td>
      <td>${item.birth}</td>
      <td>${item.phone}</td>
      <td>${item.subnum}</td>
      <td>${item.subdate}</td>
      <td>${item.ampm}</td>
      <td>取消</td>
  --%>
  <tr>
    <th>序号</th>
    <th>工号</th>
    <th>姓名</th>
    <th>性别</th>
    <th>年龄</th>
    <th>出生日期</th>
    <th>手机号</th>
    <th>科室</th>
    <th>挂号数</th>
    <th>日期</th>
    <th>时间</th>
    <th>取消</th>
  </tr>
  <c:forEach items="${arrangeDoctorList}" var="item">
    <%--
    private Integer arrangeId;
    private String clinicId;
    private Integer subnum;
    private String ampm;
    private Date subdate;
    private String cname;
    private Integer age;
    private Date birth;
    private String phone;
    private String gen;
    --%>
    <tr id="tr${item.arra_id}">
      <td>${item.arra_id}</td>
      <td>${item.clin_id}</td>
      <td>${item.clin_name}</td>
      <td>${item.clin_gen}</td>
      <td>${item.clin_age}</td>
      <td>${item.clin_birth}</td>
      <td>${item.clin_phone}</td>
      <td>${item.clin_post}</td>
      <td>${item.arra_subnum}</td>
      <td>${item.arra_subdate}</td>
      <td>${item.arra_ampm}</td>
      <td><a href="#" onclick="cancelArrange(${item.arra_id})">取消</a></td>
    </tr>
  </c:forEach>
</table>


<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script>
  function cancelArrange(arrangeId){
    $.ajax({
      url:"cancelarrange",
      type:"GET",
      data:{arrangeId:arrangeId},
      dataType:"TEXT",
      success:function(res){
        if(res.trim() === "success"){
          alert("取消成功！");
          $("#tr"+arrangeId).remove();
        }
      },
      error:function(){

      }
    })
  }
</script>
</body>
</html>
