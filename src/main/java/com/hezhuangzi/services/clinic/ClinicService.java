package com.hezhuangzi.services.clinic;

import com.hezhuangzi.dao.ClinicDao;
import com.hezhuangzi.entity.ClinicWorker;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.sql.SQLException;

public class ClinicService {
    private ClinicDao dao = new ClinicDao();


    public void adminLogin(HttpServletRequest request, HttpServletResponse response) {
        String clinicId = request.getParameter("clinicid");
        String pwd = request.getParameter("pwd");
        String admintype = request.getParameter("admintype");
        System.out.println(clinicId);
        System.out.println(pwd);
        System.out.println(admintype);
        //查询并保存 登录管理员的信息

        try {
            ClinicWorker worker = dao.queryAdminInfo(clinicId,pwd,admintype);
            System.out.println(worker);
            if(worker != null){
                String typ = worker.getTyp();
                System.out.println(typ);
                switch (typ){
                    case "sysadmin":
                        response.sendRedirect("systemadmin");
                        break;
                    case "cliadmin":
                        break;
                    case "druadmin":
                        break;
                    case "secadmin":
                        break;
                }
            }else{
                request.setAttribute("msg","帐号密码错误！");
                request.getRequestDispatcher("adminlogin.jsp").forward(request,response);
            }
        } catch (SQLException | IOException | ServletException e) {
            e.printStackTrace();
        }

    }
}
