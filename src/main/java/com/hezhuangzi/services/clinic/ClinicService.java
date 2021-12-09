package com.hezhuangzi.services.clinic;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.fastjson.JSON;
import com.hezhuangzi.dao.ClinicDao;
import com.hezhuangzi.entity.ClinicWorker;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.ref.ReferenceQueue;
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
}
