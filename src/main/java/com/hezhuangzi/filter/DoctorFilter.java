package com.hezhuangzi.filter;

import com.hezhuangzi.entity.ClinicWorker;
import com.hezhuangzi.entity.PatientInfo;
import com.hezhuangzi.services.clinic.DoctorService;
import com.hezhuangzi.services.clinic.GuidanceService;
import com.hezhuangzi.services.patient.PatientService;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "DoctorFilter")
public class DoctorFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpSession session =  httpServletRequest.getSession(true);
        ClinicWorker info = (ClinicWorker)session.getAttribute(DoctorService.DOCTOR);
        if (info!=null){
            chain.doFilter(request, response);
        }else{
            httpServletResponse.sendRedirect("doctorlogin.jsp");
        }
    }
}
