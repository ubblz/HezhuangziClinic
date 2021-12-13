<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>预约挂号</title>
    <link rel="stylesheet" href="css/subscribe.css">
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
            <a href="" style="color: #2B81D5; font-weight: bold;">预约挂号</a>
            <a href="progress">进度查询</a>
        </div>
    </div>
<%-- 预约面板 --%>
    <div class="main w">
        <div class="continer">
            <form id="form-doctor" action="#"  method="post"  onsubmit="return false">
                <input type="date" name="date" id="" max="${max}" min="${min}"}>
                <select name="sector">
                    <option value="neike">内科</option>
                    <option value="waike">外科</option>
                    <option value="erke">儿科</option>
                    <option value="pifuke">皮肤科</option>
                    <option value="wuguanke">五官科</option>
                </select>
                <select name="time">
                    <option value="am">上午</option>
                    <option value="pm">下午</option>
                </select>
                <br>
                <input type="button" value="查询" onclick="selectDoctor()">
            </form>
            <div id="doctor-list">

            </div>

<%--            <button type="button" onclick="subcribe()">预约</button>--%>
        </div>
    </div>
</div>
<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script>
    // var arrangeId = "";

    function selectDoctor(){
        $.ajax({
            url:"querysubcribedoctor",
            type:"POST",
            dateType:"JSON",
            data:$('#form-doctor').serialize(),
            success:function(result){
                $(".doctor").remove();
                for(var index in result){
                    let other = result[index];
                    console.log(other);
                    $("#doctor-list").append("" +
                        "<div class='doctor' onclick=''>" +
                            "<img src='img/pic.png' width='100' height='100' alt=''>" +
                            "<p>姓名：<span>"+other.clin_name+"</span></p>" +
                            "<p>科室：<span>"+other.clin_post+"</span></p>" +
                            "<p>性别：<span>"+other.clin_gen+"</span></p>" +
                            "<p>年龄：<span>"+other.clin_age+"</span></p>" +
                            "<p>挂号数：<span id= 'subnum"+other.arra_id+"'"+">"+other.arra_subnum+"</span></p>" +
                            "<button type='button' onclick='subcribe("+ other.arra_id+","+other.arra_subnum+")'>预约</button>" +
                        "</div>");
                }
            },
            error:function(error){
                alert("error");
            }
        });
    }

    function subcribe(arrangeId,num){

        $.ajax({
            url: "subcribedoctor",
            type: "POST",
            data: {"arrangeId": arrangeId,},
            dataType: "JSON",
            success: function(res) {
                var result = res.result;
                if(result === 0){
                    alert("预约出现错误，请重试！");
                }else if(result === 1){
                    alert("预约成功！");
                    var devnum = num - 1;
                    document.getElementById("subnum"+arrangeId).innerHTML = devnum;
                }else if(result === 2){
                    alert("已有预约，不能再预约了");
                }else if(result === 3){
                    alert("已有爽约，等待下周再预约！");
                }
            },
            error: function(err) {
                alert("出现错误！");
            }
        });
    }

</script>
</body>
</html>