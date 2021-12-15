<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hhrx
  Date: 2021/12/11
  Time: 下午12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>医生管理界面</title>
    <link rel="icon" type="image/png" href="https://pic.imgdb.cn/item/61b497192ab3f51d910ba7e0.png" />
    <!-- Bootstrap 的 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
</head>

<body>

<div class="container" style="max-width: 100%; ">
    <div class="row">
        <div class="col text-center">
            <h2>
                <img src="https://pic.imgdb.cn/item/61b497192ab3f51d910ba7e0.png"
                     style="width: 60px; height: 60px;">
                <span class="card-title" style="color: rgb(45, 133, 168);">何庄子诊所</span>
                <span>医生页面</span>
            </h2>
        </div>
        <div class="col text-right">
            <h2>
                <span>欢迎</span>
                <span>医生</span>
                <label>${sessionScope.doctor.clin_name}</label>
            </h2>
        </div>
        <div class="col text-left">
            <h2>
                <a href="LogoutServlet?type=doctor">
                    <i class="bi bi-box-arrow-right">
                    </i></a>
            </h2>
        </div>
    </div>
</div>
<!-- 内容 -->
<div class="card-deck container" style="max-width: 100%;">
    <div class="card ml-5">
        <div class="card-body">
            <h2 class="text-success text-center">呼号</h2>
            <hr>
            <div class="row mb-3 mt-3">
                <div class="col">
                    <span>名单：</span>
                </div>
                <div class="w-100"></div>
                <div class="col">
                    <label>[人数：</label>
                    <label><strong><span class="patientSum"></span></strong></label>
                    <label>]</label>
                </div>
            </div>
            <div class="row mb-3 mt-3 vh-100" style="max-height: 580px;">
                <div class="col">
                    <div class="patientList">

                    </div>
                </div>
            </div>
            <div class="row mb-3 mt-3">
                <div class="" style="max-width: 400px;">
                    <label><p class="firstPatient"></p></label>
                    <button id="calling" type="button" onclick="callPatient()" class=" btn btn-primary shadow ml-3 mr-3">呼叫</button>
                    <span>计数：<label><strong><label id="callcount">0</label></strong></label>
                    </span>
                </div>
                <div class="col">
                    <button id="lasting" class="btn btn-secondary shadow" onclick="firstSetLast()">排到后面</button>
                </div>
            </div>
        </div>
    </div>
    <div class="card" style="max-height: 700px;">
        <div class="card-body">
            <h2 class="text-danger text-center">就诊</h2>
            <hr>
            <div class="row mb-3 mt-3">
                <div class="col">
                    <label  class="text-center firstPatienting">此处患者姓名</label>
                </div>
                <div class="col">
                    <button id="visiting" type="button" onclick="patienting()" class="btn btn-success shadow">进入就诊</button>
                </div>
            </div>
            <div id="displaych"   style="display: none" >
                <h4 >录入病历</h4>
                <div class="dropdown">
                    <button class="btn btn-info dropdown-toggle col-3 shadow" type="button" id="dropdownMenuButton"
                            data-toggle="dropdown" aria-expanded="false">
                        录入病历
                    </button>
                    <div class="dropdown-menu shadow" aria-labelledby="dropdownMenuButton">
                        <textarea name="hpi" id="casehistory"  class="form-control"  cols="50" rows="7"></textarea>
                        <button id="writing" onclick="writeCaseHis()" class="btn btn-success btn-lg btn-block"> 完成录入</button>
                    </div>
                </div>

            </div>

            <div id="choose" style="display: none" >
                <div class="mt-3">
                    <div  class=" row col">
                        <button onclick="chooseDrugPres()" class="btn btn-info mr-4" type="submit">药房</button>
                        <button onclick="choosetreat()" class="btn btn-info ml-4" type="submit">输液室</button>
                    </div>
                </div>
                <div id="drug" style="display:none" >
                    <div  class="col row ml-3 mt-3">
                        <span>搜索药品：</span>
                        <input id="drug-name" type="text" name=""  required>
                        <button  onclick="searchdrug()" type="button" class="btn btn-light"><i class="bi bi-search"></i></button>
                    </div>
                    <div class="row" >
                        <div class="col">
                            <table id="search-drugtable" class=" table text-center">
                                <thead>
                                    <tr>
                                        <td>药品编号</td>
                                        <td>药品名称</td>
                                        <td>药品单价</td>
                                        <td>库存数量</td>
                                        <td>选择数量</td>
                                        <td>#</td>
                                    </tr>
                                </thead>
                                <tbody class="search-tbody">
                                    <tr>
                                        <%--                                <td><label class="mt-2">3141314123</label></td>--%>
                                        <%--                                <td><label class="mt-2">阿莫西林</label></td>--%>
                                        <%--                                <td><label class="mt-2">44.32</label></td>--%>
                                        <%--                                <td><label class="mt-2">43</label></td>--%>
                                        <%--                                <td><input class="mt-2" type="number" name="" id="" min="1" value="1"></td>--%>
                                        <%--                                <td><button class="btn btn-success">确定</button></td>--%>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>

                    <div class="row ml-3 mt-3">
                        <div class="col mb-2">
                            <span id="chose-class">已选择药品</span>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <table  id="chose-drugtable" class="table text-center">
                                <thead>
                                <tr>
                                    <td>药品编号</td>
                                    <td>药品名称</td>
                                    <td>药品单价</td>
                                    <td>选择数量</td>
                                    <td>#</td>
                                </tr>
                                </thead>
                                <tbody class="chose-tbody">
                                <%--                        <tr>--%>
                                <%--                            <td>--%>
                                <%--                                <label class="mt-2">3141314123</label>--%>
                                <%--                            </td>--%>
                                <%--                            <td>--%>
                                <%--                                <label class="mt-2">阿莫西林</label>--%>
                                <%--                            </td>--%>
                                <%--                            <td>--%>
                                <%--                                <label class="mt-2">44.32</label>--%>
                                <%--                            </td>--%>
                                <%--                            <td>--%>
                                <%--                                <label class="mt-2">1</label>--%>
                                <%--                            </td>--%>
                                <%--                            <td>--%>
                                <%--                                <button class="btn btn-success">确定</button>--%>
                                <%--                            </td>--%>
                                <%--                        </tr>--%>
                                </tbody>

                            </table>
                        </div>
                    </div>

                    <div class="row mt-3 text-center">
                        <div class="col">
                            <button  onclick="endpatienting()" class="btn btn-success">结束就诊</button>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous">
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous">
</script>



<%--<h1>医生</h1>--%>

<%--<h2>呼号名单</h2>--%>
<%--<h3>以下等待队列，总人数：<span class="patientSum"></span></h3>--%>
<%--<div class="patientList">--%>

<%--</div>--%>

<%--<h3>队列首个病人</h3>--%>
<%--<p class="firstPatient"></p>--%>
<%--<button id="calling" type="button" onclick="callPatient()">呼号</button>--%>
<%--<label>计数：</label>--%>
<%--<label id="callcount">0</label>--%>
<%--<button id="lasting" type="button" onclick="firstSetLast()">排到后面</button>--%>

<%--<br>--%>

<%--<h2>就诊</h2>--%>

<%--<label class="firstPatienting">此处患者姓名</label>--%>
<%--<button id="visiting" type="button" onclick="patienting()">进入就诊</button>--%>
<%--<br>--%>
<%--<div id="displaych" style="display: none">--%>
<%--    <h3>录入病历</h3>--%>
<%--    <textarea name="hpi" id="casehistory" cols="50" rows="6" style="margin-top: 1rem;">--%>

<%--    </textarea>--%>
<%--    <br>--%>
<%--    <button id="writing" onclick="writeCaseHis()">确定</button>--%>
<%--    <br>--%>
<%--</div>--%>

<%--<div id="choose" style="display: none">--%>
<%--    <h3>选择药房取药和输液室</h3>--%>
<%--    <button onclick="chooseDrugPres()">药房</button>--%>
<%--    <button onclick="choosetreat()">输液室</button>--%>
<%--    <div id = "drug" style="display:none">--%>
<%--        <h2 id="choose-name">药房</h2>--%>
<%--        <div >--%>
<%--            <p id="choose-search">搜索药品：</p>--%>
<%--            <input type="text" name="" id="drug-name" >--%>
<%--            <button onclick="searchdrug()">搜索</button>--%>
<%--        </div>--%>

<%--        <!-- 搜索的结果 -->--%>
<%--        <div >--%>
<%--            <h3>搜索的结果</h3>--%>
<%--            <table border="1" >--%>
<%--                <tr>--%>
<%--                    <th>药品编号</th>--%>
<%--                    <th>药品名称</th>--%>
<%--                    <th>药品单价</th>--%>
<%--                    <th>库存数量</th>--%>
<%--                    <th>选择数量</th>--%>
<%--                    <th>选择</th>--%>
<%--                </tr>--%>
<%--            </table>--%>
<%--        </div>--%>

<%--        <!-- 确认的药品 -->--%>
<%--        <div >--%>
<%--            <h3 id="chose-class">已选择的药品</h3>--%>
<%--            <table border="1" id="chose-drugtable">--%>

<%--            </table>--%>
<%--        </div>--%>
<%--        <br>--%>
<%--        <button onclick="endpatienting()">结束就诊</button>--%>
<%--    </div>--%>
<%--    <br>--%>
<%--</div>--%>


<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    var clinicId = "${sessionScope.doctor.clin_id}";
    var type = "${sessionScope.doctor.clin_type}";
    console.log(clinicId);
    var webSocket = new WebSocket("ws://127.0.0.1:8080/HezhuangziClinic/websocket/noticedoctor");
    var savePatientList;
    var count = 0;
    var saveFirstPatient;
    var flagPatienting = false;
    var saveSearchDrug;
    var choseDrugs = new Array();//已选择的药品

    //
    // function displayChoseDrugList(data){
    //     $("#chose-drugtable").empty();
    //     $("#chose-drugtable").append("<tr > <th>药品编号</th> <th>药品名称</th> <th>药品单价</th> <th>选择数量</th> <th>取消</th> </tr>");
    //     for (let i = 0; i < data.length; i++) {
    //         $("#chose-drugtable").append("<tr id='cancel-tr"+i+"'> " +
    //             "<td>"+ data[i].drug_id+"</td> " +
    //             "<td>"+ data[i].drug_name+"</td> " +
    //             "<td>"+ data[i].drug_price+"</td> " +
    //             "<td>"+ data[i].choose_num+"</td> " +
    //             "<td><button onclick='cancelChoseDrug("+i+")'>确定</button></td> " +
    //             "</tr>");
    //     }
    // }


    function displayChoseDrugList(data){
        console.log("已选择的药品："+data);
        $(".chose-tbody").empty();
        // $("#chose-drugtable").append("<tr > <th>药品编号</th> <th>药品名称</th> <th>药品单价</th> <th>选择数量</th> <th>取消</th> </tr>");
        for (let i = 0; i < data.length; i++) {
            $(".chose-tbody").append("<tr id='cancel-tr"+i+"'> " +
                "<td  class='mt-2'>"+ data[i].drug_id+"</td> " +
                "<td class='mt-2'>"+ data[i].drug_name+"</td> " +
                "<td class='mt-2'>"+ data[i].drug_price+"</td> " +
                "<td class='mt-2'>"+ data[i].choose_num+"</td> " +
                "<td><button class='btn btn-success' onclick='cancelChoseDrug("+i+")'>确定</button></td> " +
                "</tr>");
        }
    }

    function cancelChoseDrug(index){
        var con = confirm("确认取消？");
        if(conf){
            $.ajax({
                url:"CancelChoseDrugServlet",
                type:"POST",
                data:{"orderid":choseDrugs[index].order_id},
                dataType:"JSON",
                success:function(res){
                    if(res.result === 1){
                        alert("取消成功！");
                        choseDrugs.splice(index,1);

                    }else{
                        alert("取消失败！");
                    }
                    $("#cancel-tr"+index).remove();
                },
                error:function(err){
                    alert("取消出错！");
                }
            });
        }
    }

    //选择治疗
    function choosetreat(){
        // $("#drug").hide();
        // $("#treat").show();
        $("#drug").show();
        $.ajax({
            url:"ChooseMethodServlet",
            type:"POST",
            data:{registerid:saveFirstPatient.regi_id,"choose":1},
            dataType:"JSON",
            success:function(res){
                if(res.result === 1){
                    alert("选择成功!")
                    modifyVisit();
                }else{
                    alert("选择失败!")
                }
            },
            error:function(){
                alert("选择出错！");
            }
        });
    }
    //药房的
    function modifyDrug(){
        $("#choose-name").text("药物治疗");
        $("#choose-search").text("搜索药品");
        $("#chose-class").text("已选择的药品")
    }

    function modifyVisit(){
        $("#choose-name").text("输液注射治疗");
        $("#choose-search").text("搜索输液注射药品");
        $("#chose-class").text("已选择的输液注射药品")
    }

    //选择药房
    function chooseDrugPres(){
        //修改名字
        // $("#drug").show();
        // $("#treat").hide();
        $("#drug").show();
        $.ajax({
            url:"ChooseMethodServlet",
            type:"POST",
            data:{registerid:saveFirstPatient.regi_id,"choose":0},
            dataType:"JSON",
            success:function(res){
                if(res.result === 1){
                    alert("选择成功!");
                    modifyDrug();
                }else{
                    alert("选择失败!");
                }
            },
            error:function(){
                alert("选择出错！");
            }
        });
    }

    function searchdrug(){
        $.ajax({
            url:"SearchDrugServlet",
            type:"POST",
            data:{drugname:$("#drug-name").val()},
            dataType:"JSON",
            success:function(res){
                if(res.result === 1){
                    displaySearchDrug(res.data);
                }else if(res.result === 2){
                    $("#search-drugtable").empty();
                    $("#search-drugtable").append("<p>无此药品</p>")
                    alert("无此药品，请重新搜索！");
                }else{
                    alert("获取药房信息失败！");
                }
            },
            error:function(err){
                alert("搜索出错" +err);
            }
        })
    }

    function displaySearchDrug(data){
        saveSearchDrug = data;
        $(".search-tbody").empty();
        // $("#search-drugtable").append("<tr> <th>药品编号</th> <th>药品名称</th> <th>药品单价</th> <th>库存数量</th> <th>选择数量</th><th>选择</th> </tr>");
        for (let i = 0; i < data.length; i++) {
            $(".search-tbody").append("<tr id='drug-tr"+i+"'> " +
                "<td><label class='mt-2'>"+data[i].drug_id+"</label></td> " +
                "<td><label class='mt-2'>"+data[i].drug_name+"</label></td> " +
                "<td><label class='mt-2'>"+data[i].drug_price+"</label></td> " +
                "<td><label class='mt-2'>"+data[i].drug_num+"</label></td> " +
                "<td><input class='mt-2' value='1' id='choosenum"+i+"' type='number' max='"+data[i].drug_num+"'></td> " +
                "<td><button  class='btn btn-success' onclick='chooseSigleDrug("+i+")'>确定</button></td> " +
                "</tr>");
        }
    }
    //
    // function displaySearchDrug(data){
    //     saveSearchDrug = data;
    //     $("#search-drugtable").empty();
    //     $("#search-drugtable").append("<tr> <th>药品编号</th> <th>药品名称</th> <th>药品单价</th> <th>库存数量</th> <th>选择数量</th><th>选择</th> </tr>");
    //     for (let i = 0; i < data.length; i++) {
    //         $("#search-drugtable").append("<tr id='drug-tr"+i+"'> " +
    //             "<td>"+data[i].drug_id+"</td> " +
    //             "<td>"+data[i].drug_name+"</td> " +
    //             "<td>"+data[i].drug_price+"</td> " +
    //             "<td>"+data[i].drug_num+"</td> " +
    //             "<td><input value='1' id='choosenum"+i+"' type='number' max='"+data[i].drug_num+"'></td> " +
    //             "<td><button  onclick='chooseSigleDrug("+i+")'>确定</button></td> " +
    //             "</tr>")
    //     }
    // }

    function chooseSigleDrug(i){
        var con = confirm("确定选择？");
        if(con){
            var cnum = $("#choosenum"+i).val();
            $.ajax({
                url:"ChooseSigleDrugServlet",
                type:"POST",
                data:{"registerid":saveFirstPatient.regi_id,"drugid":saveSearchDrug[i].drug_id,"choosenum":cnum},
                dataType:"JSON",
                success:function(res){
                    if (res.result === 1) {
                        alert("选择药品成功！")
                        $("#drug-tr"+i).remove();
                        var orderid = res.orderid
                        var drug = {
                            "drug_id":saveSearchDrug[i].drug_id,
                            "drug_name":saveSearchDrug[i].drug_name,
                            "drug_price":saveSearchDrug[i].drug_price,
                            "choose_num":cnum,
                            "order_id":orderid
                        };
                        choseDrugs.push(drug);
                        displayChoseDrugList(choseDrugs);
                    }else{
                        alert("选择药品失败！")
                    }
                },
                error:function(){
                    alert("选择药品出错！")
                }
            });
        }
    }

    // $("#choose").hide();
    // $("#displaych").hide();
    function writeCaseHis(){
        $("#choose").show();
        $.ajax({
            url:"WriteCaseHistoryServlet",
            type:"POST",
            data:{"registerid":saveFirstPatient.regi_id,"hpi":$("#casehistory").val()},
            success:function(res){
                if(res.trim() === "success"){
                    alert("录入病历成功！")
                    $("#writing").attr("disabled",true);
                    $("#casehistory").attr("disabled",true);
                }else{
                    alert("录入病历失败！")
                }
            },
            error:function(){
                alert("录入病历出错！")
            }
        })
    }

    function endpatienting() {
        $.ajax({
            url:"EndPatientingServlet",
            type:"POST",
            success:function(res){
                location.reload();
            },
            error:function(){

            }
        });
        // flagPatienting = false;
    }

    //进入就诊
    function patienting() {
        flagPatienting = true;
        var con = confirm("确定进入就诊状态？");
        if(con){
            $.ajax({
                url: "PatientingServlet",
                type: "POST",
                success: function () {
                    // alert("正在就诊");
                    $("#displaych").show();
                    $("#lasting").attr("disabled",true);
                    $("#calling").attr("disabled",true);
                    $("#visiting").attr("disabled",true);
                },
                error: function () {
                    alert("就诊失败")
                }
            });
        }

    }

    function callPatient() {
        if (count >= 3) {
            var c = confirm("已呼叫3次，是否继续呼叫");
            if (c) {
                letCall();
                count++;
            }
        }else {
            letCall();
            count++;
        }
        $("#callcount").text(count);
    }

    function letCall(){
        $.ajax({
            url:"CallPatientServlet",
            type:"POST",
            data:{"patientname":saveFirstPatient.pati_name},
            success:function(){
                $("#calling").attr("disabled",true);
                setTimeout(function(){
                    $("#calling").attr("disabled",false);
                },4000);
            },
            error:function(){
                alert("呼叫出错！");
            }
        });
    }

    function callSendDisplay(){

    }

    function firstSetLast() {
        // if (!flagPatienting) {
            $.ajax({
                url: "FirstSetLastServlet",
                type: "POST",
                success: function (res) {
                    console.log("设置到最后成功！");
                    // var p = getDoctorPaitent(res);
                    // var t = p.pop();
                    // console.log(t);
                    // p.splice(0,0,t);
                    // displayPatientList(p);
                },
                error: function () {
                    console.log("设置到最后失败！");
                }
            })
            count = 0;
            $("#callcount").text(count);
        // } else {
        //     alert("正在就诊");
        // }

    }

    //显示
    function displayPatientList(patients) {
        console.log(patients);
        $(".patientList").empty();
        $(".patientSum").text(patients.length);
        if(patients.length === 0){
            $("#visiting").attr("disabled",true);
            $("#calling").attr("disabled",true);
            $("#lasting").attr("disabled",true);
        }else{
            $("#visiting").attr("disabled",false);
            $("#calling").attr("disabled",false);
            $("#lasting").attr("disabled",false);
        }
        for (let i = 0; i < patients.length; i++) {
            if (i === 0) {
                if (!flagPatienting) {
                    saveFirstPatient = patients[i];
                    $(".firstPatienting").text(patients[i].pati_name);
                }
                $(".firstPatient").text(patients[i].pati_name);
            }
            $(".patientList").append("" +
                "<p>编号:" + patients[i].pati_id + ",名字:" + patients[i].pati_name + "</p>" +
                "");
        }
    }

/*   websocket   */
    //连接
    webSocket.onopen = function () {
        console.log("连接成功！");
        //第一次连接就发送消息
        // $.ajax({
        //     url: "GetPatientListServlet",
        //     type: "POST",
        //     success: function (res) {
        //         console.log("第一次获取成功！");
        //     },
        //     error: function (err) {
        //         console.log("第一次获取失败! ");
        //     }
        // });
    }
    //接收消息
    webSocket.onmessage = function (event) {
        //    获取
        var allData = JSON.parse(event.data);
        console.log(allData);
        var patients = getDoctorPaitent(allData);
        savePatientList = patients;
        displayPatientList(savePatientList);
    }

    function getDoctorPaitent(allData){
        for (const sectors in allData) {
            console.log(sectors);
            if(allData[sectors].sector === type){
                console.log(allData[sectors].sector);
                for (const doctorPatient in allData[sectors].doctorPatientList) {
                    if(allData[sectors].doctorPatientList[doctorPatient].doctor.clin_id === clinicId){
                        return allData[sectors].doctorPatientList[doctorPatient].registerList;
                    }
                }
            }
        }
    }

    //关闭
    webSocket.onclose = function () {
        console.log("已关闭连接！");
    }

    window.onbeforeunload = function (event) {
        console.log("关闭WebSocket连接！");
        webSocket.close();
    }

</script>
</body>
</html>
