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
</head>
<body>
<h1>欢迎 科室管理员 登录</h1>

<a href="sectoradmin">安排就诊</a>
<a href="sectormodify">修改就诊</a>

<form id="querydoctor-form">
      日期：<input id="date" type="date" name="date" max="${endDate}" min="${startData}">
      科室：<select id="sector" name="sector">
                  <option value="neike">内科</option>
                  <option value="waike">外科</option>
                  <option value="erke">儿科</option>
                  <option value="wuguanke">五官科</option>
                  <option value="pifuke">皮肤科</option>
            </select>
      时间：<select id="time" name="time">
                  <option value="am">上午</option>
                  <option value="pm">下午</option>
            </select>
      <input onclick="queryDoctor()" type="button" value="查询">
</form>

<div class="main">
    <table id="arrange-table" border="1px">
    </table>
</div>

<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    var saveData;
    function queryDoctor(){
        $.ajax({
            url:"arrangequery",
            type:"POST",
            data:$("#querydoctor-form").serialize(),
            dataType:"JSON",
            success:function(res){
                if(res.msg === "success"){
                    alert("查询成功！");
                    displayDoctor(res.data);
                }
            },
            error:function(){

            }
        });
    }

    function displayDoctor(data){
        saveData = data;
        $("#arrange-table").empty();
        $("#arrange-table").append("<tr> <th>医生工号</th> <th>医生姓名</th> <th>设置挂号数</th> <th>安排</th> </tr>");
        for (let i = 0; i < data.length; i++) {
            $("#arrange-table").append("<tr id='tr"+i+"'> " +
                "<td>"+data[i].clin_id+"</td> " +
                "<td>"+data[i].clin_name+"</td> " +
                "<td><input id='"+"subnum"+i+"' name='subnum' value='20' type='number''></td>"+
                "<td><a href='#' onclick='arrangeDoctor("+i+")'>选择</a></td>"+
                    "</tr>");
        }
    }

    function arrangeDoctor(index){
        // console.log($("#subnum"+index).val());
        // console.log($("#date").val());
        // console.log($("#time").val());
        // console.log($("#sector").val());

        var clinicId = saveData[index].clin_id;
        var subnum = $("#subnum"+index).val();
        var ampm = $("#time").val();
        var subdate = $("#date").val();
        //删除
        $.ajax({
            url:"choosearrangedoctor",
            type:"POST",
            data:{clinicId:clinicId,subnum:subnum,ampm:ampm,date:subdate},
            dataType:"TEXT",
            success:function(res){
                console.log(res);
                if(res.trim() === "success"){
                    alert("已安排！");
                    $("#tr"+index).remove();
                }
            },
            error:function(){

            }
        });
    }

</script>
</body>
</html>
