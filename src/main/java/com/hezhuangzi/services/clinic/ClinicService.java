package com.hezhuangzi.services.clinic;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.fastjson.JSON;
import com.hezhuangzi.dao.ClinicDao;
import com.hezhuangzi.entity.ArrangeDoctor;
import com.hezhuangzi.entity.ClinicWorker;
import com.hezhuangzi.util.OtherUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                String typ = worker.getClin_type();
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
                        response.sendRedirect("sectoradmin");
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

    public void getExcelData(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //获取目录路径
        String savePath = servletContext.getRealPath("/WEB-INF/upload");

        System.out.println(savePath);
        //获取目录对象
        File file = new File(savePath);
        //判断目录是否存在，不存在就创建
        if(!file.exists() && !file.isFile()){
            file.mkdir();
        }

        String msg = "";
        try {
            //开始上传文件
            DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
            upload.setHeaderEncoding("UTF-8");
            if(!ServletFileUpload.isMultipartContent(request)){
                return ;
            }
            List<FileItem> list = upload.parseRequest(request);
            for (FileItem fileItem : list) {
                if (fileItem.isFormField()) {

                }else{
                    //自定义文件名字
//                    String fileName = fileItem.getName();
//                    System.out.println(fileName);
//                    if(fileName == null || fileName.trim().equals("")){
//                        continue;
//                    }
//                    fileName = fileName.substring(fileName.lastIndexOf("\\"))
                    InputStream in = fileItem.getInputStream();
                    FileOutputStream outputStream = new FileOutputStream(savePath+"/"+"excel.xlsx");
                    byte[] buffer = new byte[1024];
                    int len = 0;
                    while((len=in.read(buffer)) != -1){
                        outputStream.write(buffer,0,len);
                    }
                    in.close();
                    outputStream.close();
                    fileItem.delete();
                    msg = "success";
                }
            }

        } catch (FileUploadException | IOException e) {
            e.printStackTrace();
            Map<String,String> result = new HashMap<>();
            result.put("msg","error");
            out.println(JSON.toJSONString(result));
            return;
        }


        /*
         * 下面是导入数据库！ 检查格式
         * */

        String path = servletContext.getRealPath("/WEB-INF/upload");
        String fileName = path+ File.separator+ "excel.xlsx";
        String finalMsg = msg;
        EasyExcel.read(fileName, ClinicWorker.class,new PageReadListener<ClinicWorker>(dataList ->{
            Map<String,Object> result = new HashMap<>();
            try {
                dao.addExcelData(dataList);
                result.put("msg",finalMsg);
                result.put("data",dataList);
            } catch (SQLException e) {
                e.printStackTrace();
                result.put("msg","error");
            }
            out.println(JSON.toJSONString(result));
        })).sheet().doRead();
    }

    public void queryArrangeDoctor(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json;charset=utf-8");
        String date = request.getParameter("date");
        String sector = request.getParameter("sector");
        String time = request.getParameter("time");
        System.out.println(date);
        System.out.println(sector);
        System.out.println(time);
        PrintWriter out = null;
        Map<String,Object> result = new HashMap<>();
        try {
            out = response.getWriter();
            List<ClinicWorker> workers = dao.queryArrange(date,sector,time);
            result.put("msg","success");
            result.put("data",workers);
            out.println(JSON.toJSONString(result));
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            result.put("msg","success");
            out.println(JSON.toJSONString(result));
        }
    }

    public void chooseArrangeDoctor(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/text;charset=utf-8");

        String clinicId = request.getParameter("clinicId");
        String date = request.getParameter("date");
        String ampm = request.getParameter("ampm");
        String subnum = request.getParameter("subnum");

        System.out.println(clinicId);
        System.out.println(date);
        System.out.println(ampm);
        System.out.println(subnum);

        PrintWriter out = null;
        String msg = "";
        try {
            out = response.getWriter();
            int count = dao.arrangeOneDoctor(clinicId,date,ampm,subnum);
            msg = count > 0 ?"success":"error";
        } catch (SQLException | IOException e) {
            msg = "error";
            e.printStackTrace();
        }
        out.println(msg);

    }

    public void sectorModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String date = request.getParameter("date");
//        String name = request.getParameter("cname");
//        String time = request.getParameter("time");

        request.setAttribute("cancelResult",request.getParameterValues("cancelResult"));
        try {
            List<ArrangeDoctor> list = dao.queryArrangeDoctor();
            if(!list.isEmpty()){
                request.setAttribute("arrangeDoctorList",list);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("sectormodify.jsp").forward(request,response);
    }

    public void cancelArrange(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/text;charset=utf-8");
        String arrangeId = request.getParameter("arrangeId");
        String msg = "";

        PrintWriter out = null;

        try {
            out = response.getWriter();
            if(dao.cancelArrangeDoctor(arrangeId) > 0){
                msg = "success";
            }else{
                msg = "error";
            }
        } catch (SQLException | IOException e) {
            msg = "error";
            e.printStackTrace();
        }
        out.println(msg);

    }

    public void sectorAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String startData = OtherUtils.getMondayDate(OtherUtils.getMonDayCount());
        String endData = OtherUtils.getMondayDate(OtherUtils.getMonDayCount() + 6);
//        System.out.println(startData);
//        System.out.println(endData);

        request.setAttribute("startData",startData);
        request.setAttribute("endDate",endData);

        request.getRequestDispatcher("sectoradmin.jsp").forward(request,response);
    }
}
