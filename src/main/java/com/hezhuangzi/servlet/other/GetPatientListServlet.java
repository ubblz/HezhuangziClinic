package com.hezhuangzi.servlet.other;

import com.alibaba.fastjson.JSON;
import com.hezhuangzi.entity.ClinicWorker;
import com.hezhuangzi.entity.DoctorPatient;
import com.hezhuangzi.entity.Sectors;
import com.hezhuangzi.listener.ApplictionListener;
import com.hezhuangzi.services.clinic.DoctorService;
import com.hezhuangzi.util.OtherUtils;
import com.hezhuangzi.websocket.NoticeDoctor;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetPatientListServlet", value = "/GetPatientListServlet")
public class GetPatientListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        DoctorPatient doctorPatient = OtherUtils.getDoctorPatient(getServletContext(), request);
        List<Sectors> attribute = (List<Sectors>) getServletContext().getAttribute(ApplictionListener.SECTOR);
        NoticeDoctor doctor = new NoticeDoctor();
        doctor.onMessage(JSON.toJSONString(attribute));
    }
}
