package com.hezhuangzi.listener;

import com.alibaba.fastjson.JSON;
import com.hezhuangzi.entity.Sectors;
import com.hezhuangzi.websocket.InfoDisplay;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.ArrayList;
import java.util.List;

@WebListener
public class ApplictionListener implements ServletContextListener,HttpSessionAttributeListener {


    private static String[] sectors = {"erke","neike","waike","pifuke","wuguanke"};
    public static final String SECTOR = "sector";

    public static HttpSession getSession() {
        return session;
    }

    public static HttpSession session;
    public static ServletContext getAppContext() {
        return appContext;
    }

    private static ServletContext appContext;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        System.out.println("服务器启动");
        List<Sectors> sectorsList = new ArrayList<>();
        for (String sector : sectors) {
            Sectors sectors = new Sectors();
            sectors.setSector(sector);
            sectorsList.add(sectors);
        }
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute(SECTOR,sectorsList);
        System.out.println(JSON.toJSONString(sectorsList));

        //有了全局的科室对象了
        appContext = servletContext;
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
        System.out.println("服务器销毁");

    }


    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        /* This method is called when an attribute is added to a session. */
//        ClinicWorker clinicWorker = (ClinicWorker)event.getSession().getAttribute("doctor");
//        String clinicId = clinicWorker.getClin_id();
//        String type = clinicWorker.getClin_type();
//        List<Sectors> attribute = (List<Sectors>) ApplictionListener.appContext.getAttribute(ApplictionListener.SECTOR);
//        for (Sectors sectors : attribute) {
//            if(sectors.getSector().equals(type)){
//                for (DoctorPatient doctorPatient : sectors.getDoctorPatientList()) {
//                    if(doctorPatient.getDoctor().getClin_id().equals(clinicId)){
//                        noticeDoctor.onMessage(JSON.toJSONString(doctorPatient));
//                        break;
//                    }
//                }
//            }
//        }
        session = event.getSession();

    }

    public static List<Sectors> getAllSectorPatient(){
        return (List<Sectors>) ApplictionListener.appContext.getAttribute(ApplictionListener.SECTOR);
    }
    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        //有人登陆的时候发送
        List<Sectors> attribute = (List<Sectors>) ApplictionListener.appContext.getAttribute(ApplictionListener.SECTOR);
        InfoDisplay.getTypeData(InfoDisplay.INFO,attribute);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {

    }

}
