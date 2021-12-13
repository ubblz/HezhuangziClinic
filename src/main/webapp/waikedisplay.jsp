<%--
  Created by IntelliJ IDEA.
  User: hhrx
  Date: 2021/12/12
  Time: 下午8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>外科室显示屏</title>
    <link rel="stylesheet" href="css/display.css">
</head>
<body>

<div class="main">
    <h1>儿科室显示屏</h1>
    <div id="docpati-info" class="display-info" >
<%--        <div class="doctor-list">--%>
<%--            <h2 class="doctor">医生</h2>--%>
<%--            <p class="remainder">正在就诊：</p>--%>
<%--            <p class="patient">患*者</p>--%>
<%--            <p class="remainder">正在等待：</p>--%>
<%--            <p class="patient">患者1</p>--%>
<%--            <p class="patient">患者2</p>--%>
<%--            <p>....</p>--%>
<%--            <p class="patient-sum">总人数：<span>20</span></p>--%>
<%--        </div>--%>
<%--        <div class="doctor-list">--%>
<%--            <h2 class="doctor">医生</h2>--%>
<%--            <p class="remainder">正在就诊：</p>--%>
<%--            <p class="patient">患*者</p>--%>
<%--            <p class="remainder">正在等待：</p>--%>
<%--            <p class="patient">患者1</p>--%>
<%--            <p class="patient">患者2</p>--%>
<%--            <p>....</p>--%>
<%--            <p class="patient-sum">总人数：<span>20</span></p>--%>
<%--        </div>--%>
<%--        <div class="doctor-list">--%>
<%--            <h2 class="doctor">医生</h2>--%>
<%--            <p class="remainder">正在就诊：</p>--%>
<%--            <p class="patient">患*者</p>--%>
<%--            <p class="remainder">正在等待：</p>--%>
<%--            <p class="patient">患者1</p>--%>
<%--            <p class="patient">患者2</p>--%>
<%--            <p>....</p>--%>
<%--            <p class="patient-sum">总人数：<span>20</span></p>--%>
<%--        </div>--%>
<%--        <div class="doctor-list">--%>
<%--            <h2 class="doctor">医生</h2>--%>
<%--            <p class="remainder">正在就诊：</p>--%>
<%--            <p class="patient">患*者</p>--%>
<%--            <p class="remainder">正在等待：</p>--%>
<%--            <p class="patient">患者1</p>--%>
<%--            <p class="patient">患者2</p>--%>
<%--            <p>....</p>--%>
<%--            <p class="patient-sum">总人数：<span>20</span></p>--%>
<%--        </div>--%>
<%--        <div class='doctor-list'>--%>
<%--            <h2 class='doctor'>医生</h2>--%>
<%--            <p class='remainder'>正在就诊：</p>--%>
<%--            <p class='patient'>患*者</p>--%>
<%--            <p class='remainder'>正在等待：</p>--%>
<%--            <p class='patient'>患者1</p>--%>
<%--            <p class='patient'>患者2</p>--%>
<%--            <p>....</p>--%>
<%--            <p class='patient-sum'>总人数：<span>20</span></p>--%>
<%--        </div>--%>
    </div>

    <div id="call-info" style="display: none">
        <p class="call-remainder">
            正在呼叫：
        </p>
        <p class="call-name">
            患者名字
        </p>
    </div>

</div>
<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    var sectorName = "waike";
    var timer;
    var webSocket = new WebSocket("ws://localhost:8080/HezhuangziClinic//websocket/infodisplay");
    webSocket.onopen = function () {
        console.log("已连接");
    }
    webSocket.onmessage = function (event) {
        console.log("显示屏客户端接收到消息...");
        console.log(event.data);
        var result = JSON.parse(event.data);
        var type = result.type;
        console.log(type);
        if(type === "info"){
            var doctorPaitent = result.data;
            console.log(doctorPaitent.length);
            displayInfo(doctorPaitent);
        }else if(type === "call"){
            var name = result.data;
            clearInterval(timer);
            $(".call-name").text(modifyName(name));
            $("#docpati-info").css("display","none");
            $("#call-info").css("display","block");
            timer = setInterval(function(){
                $("#docpati-info").css("display","flex");
                $("#call-info").css("display","none");
            },4000);
        }
    }
    webSocket.onclose = function () {
        console.log("已关闭");
    }

    function displayInfo(doctorPaitent){
        for (let s = 0; s < doctorPaitent.length; s++) {
            if (doctorPaitent[s].sector === sectorName) {
                console.log("医生的所有病人")
                console.log(doctorPaitent[s].doctorPatientList);
                $(".display-info").empty();
                for (let i = 0; i < doctorPaitent[s].doctorPatientList.length; i++) {
                    var dp = doctorPaitent[s].doctorPatientList[i];
                    var patientName;
                    if(dp.patienting !== undefined){
                        patientName = dp.patienting.pati_name;
                    }else{
                        patientName = "无";
                    }
                    var doctorName = dp.doctor.clin_name;
                    var patientList = dp.registerList;
                    var patientSum = patientList.length;
                    var p1;
                    var p2;
                    if (patientSum >= 2) {
                        p1 = patientList[0].pati_name;
                        p2 = patientList[1].pati_name;
                        createDoctorList(doctorName, patientName, p1, p2, patientSum);
                    } else if (patientSum === 1) {
                        p1 = patientList[0].pati_name;
                        createDoctorList(doctorName, patientName, p1, "", 1);
                    } else {
                        createDoctorList(doctorName, patientName, "", "", 0);
                    }
                }
            }
        }
    }

    function createDoctorList(doctorName, patientName, patient1, patient2, patientSum) {
        $(".display-info").append("" +
            "<div class='doctor-list'> " +
            "<h2 class='doctor'>" + doctorName + "</h2> " +
            "<p class='remainder'>正在就诊：</p> " +
            "<p class='patient'>"+modifyName(patientName)+"</p> " +
            "<p class='remainder'>正在等待：</p> " +
            "<p class='patient'>" + modifyName(patient1) + "</p> " +
            "<p class='patient'>" + modifyName(patient2) + "</p> " +
            "<p style='font-size: 1.5em;letter-spacing: 10px;'>....</p> " +
            "<p class='patient-sum'>总人数：<span>" + patientSum + "</span></p> " +
            "</div>");
    }

    function modifyName(name){
        /*
        * 1. 大于2
        * 2. 等于2
        * 2. 等于1
        * */
        if(name !== undefined){
            if(name === "无"){
                return "无";
            }
            if(name.length > 2){
                return name[0] + "*" + name.substr(2);
            }else if(name.length === 2){
                return name[0] + "*";
            }else if(name.length === 1){
                return name[0] + "*";
            }else{
                return "";
            }
        }
    }

</script>
</body>
</html>
