package com.hezhuangzi.servlet.other;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.hezhuangzi.entity.ClinicWorker;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ExcelTestServlet", value = "/ExcelTestServlet")
public class ExcelTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String path = this.getServletContext().getRealPath("/WEB-INF/upload");
//        FileInputStream in = new FileInputStream(path+"/"+"workerList.xlsx");
//        XSSFWorkbook excel = (XSSFWorkbook) XSSFWorkbookFactory.create(in);
//
//        in.close();
//        Sheet sheet = excel.getSheetAt(0);
//        int rows = sheet.getLastRowNum();
//        System.out.println(rows);
//        for(int rowNo = 1; rowNo <= rows;rowNo++){
//            Map<String,String> map = new HashMap<>();
//            Row row = sheet.getRow(rowNo);
//            int cells = row.getLastCellNum();
//            /*
//            * _NONE(-1),
//                NUMERIC(0),
//                STRING(1),
//                FORMULA(2),
//                BLANK(3),
//                BOOLEAN(4),
//            * */
//            System.out.println(cells);
//            for(int cellNo = 0;cellNo < cells;cellNo++){
//                Cell cell = row.getCell(cellNo);
//                if(cell != null){
//                    System.out.print(cells.);
//                }
//            }
//            System.out.println();
//        }
        String path = this.getServletContext().getRealPath("/WEB-INF/upload");
        String fileName = path+ File.separator+ "workerList.xlsx";
        EasyExcel.read(fileName, ClinicWorker.class,new PageReadListener<ClinicWorker>(dataList ->{
            for (ClinicWorker worker : dataList) {
                System.out.println(worker);
            }
        })).sheet().doRead();


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
