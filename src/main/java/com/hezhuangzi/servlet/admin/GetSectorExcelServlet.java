package com.hezhuangzi.servlet.admin;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.fastjson.JSON;
import com.hezhuangzi.dao.ClinicDao;
import com.hezhuangzi.entity.ClinicSector;
import com.hezhuangzi.entity.ClinicWorker;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "GetSectorExcelServlet", value = "/GetSectorExcelServlet")
public class GetSectorExcelServlet extends HttpServlet {
    private static final String FILE = "sector.xlsx";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //获取目录路径
        String savePath = getServletContext().getRealPath("/WEB-INF/upload");

        System.out.println(savePath);
        //获取目录对象
        File file = new File(savePath);
        //判断目录是否存在，不存在就创建
        if (!file.exists() && !file.isFile()) {
            file.mkdir();
        }

        String msg = "";
        try {
            //开始上传文件
            DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
            upload.setHeaderEncoding("UTF-8");
            if (!ServletFileUpload.isMultipartContent(request)) {
                return;
            }
            List<FileItem> list = upload.parseRequest(request);
            for (FileItem fileItem : list) {
                if (fileItem.isFormField()) {

                } else {
                    //自定义文件名字
//                    String fileName = fileItem.getName();
//                    System.out.println(fileName);
//                    if(fileName == null || fileName.trim().equals("")){
//                        continue;
//                    }
//                    fileName = fileName.substring(fileName.lastIndexOf("\\"))
                    InputStream in = fileItem.getInputStream();
                    FileOutputStream outputStream = new FileOutputStream(savePath + File.separator + FILE);
                    byte[] buffer = new byte[1024];
                    int len = 0;
                    while ((len = in.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, len);
                    }
                    in.close();
                    outputStream.close();
                    fileItem.delete();
                    msg = "success";
                }
            }

        } catch (FileUploadException | IOException e) {
            e.printStackTrace();
            Map<String, String> result = new HashMap<>();
            result.put("msg", "error");
            out.println(JSON.toJSONString(result));
            return;
        }

        /*
         * 下面是导入数据库！ 检查格式
         * */
        ClinicDao dao = new ClinicDao();
        String path = getServletContext().getRealPath("/WEB-INF/upload");
        String fileName = path + File.separator + FILE;
        EasyExcel.read(fileName, ClinicSector.class, new PageReadListener<ClinicSector>(dataList -> {
            int count = 0;
            boolean success = true;
            Map<String, Object> result = new HashMap<>();
            List<ClinicSector> errorList = new ArrayList<>();
            for (ClinicSector clinicSector : dataList) {
                try {
                    dao.addExcelSectorOneData(clinicSector);
//                    dao.addExcelData(dataList);
                } catch (Exception e) {
                    count++;
                    success = false;
                    errorList.add(clinicSector);
                    e.printStackTrace();
                }
            }
            if (!success) {
                result.put("result", 2);
                result.put("data", errorList);
                result.put("count",count);
            } else {
                result.put("msg", 1);
            }
            out.println(JSON.toJSONString(result));
        })).sheet().doRead();
    }
}
