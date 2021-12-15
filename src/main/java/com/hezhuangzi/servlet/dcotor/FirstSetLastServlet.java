package com.hezhuangzi.servlet.dcotor;

import com.alibaba.fastjson.JSON;
import com.hezhuangzi.entity.Sectors;
import com.hezhuangzi.listener.ApplictionListener;
import com.hezhuangzi.util.OtherUtils;
import com.hezhuangzi.websocket.InfoDisplay;
import com.hezhuangzi.websocket.NoticeDoctor;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "FirstSetLastServlet", value = "/FirstSetLastServlet")
public class FirstSetLastServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        PrintWriter out = OtherUtils.setAndGetJSONOut(response);
//        List<Sectors> doctorPatient = ApplictionListener.getAllSectorPatient();
//        out.println(JSON.toJSONString(doctorPatient));
        List<Sectors> sectorsList = OtherUtils.setFristToLast(request);

        //发送给医生
        NoticeDoctor doctor = new NoticeDoctor();
        doctor.onMessage(JSON.toJSONString(sectorsList));
        //发送给显示屏
        InfoDisplay.getTypeData(InfoDisplay.INFO,ApplictionListener.getAllSectorPatient());
    }
}
