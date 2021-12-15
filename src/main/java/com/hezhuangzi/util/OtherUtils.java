package com.hezhuangzi.util;

import com.hezhuangzi.dao.PatientDao;
import com.hezhuangzi.entity.*;
import com.hezhuangzi.listener.ApplictionListener;
import com.hezhuangzi.services.clinic.DoctorService;
import com.hezhuangzi.websocket.NoticeDoctor;

import javax.print.Doc;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;

public class OtherUtils {

    public static String getCurrentTimeMillis() {
        SimpleDateFormat df = new SimpleDateFormat("yyMMddHHmmss");
        String ctm = df.format(new Date());
        return ctm;
    }

    public String convertAmPm() {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());

        return "";
    }

    public static String subcribeNum() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSS");
        return sdf.format(new Date());
    }

    public static String dateConvert(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sdfDate = sdf.format(date);
        return sdfDate;
    }

    /*日期转星期*/
    public static String dateToWeek(String datetime) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        Date datet = null;
        try {
            datet = f.parse(datetime);
            cal.setTime(datet);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    public static Date addOneDate(Date date){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        return calendar.getTime();
    }

    public static int getMonDayCount() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date nowDate = new Date();
        int count = 0;
        if(OtherUtils.dateToWeek(simpleDateFormat.format(nowDate)).equals("星期一")){
            nowDate = addOneDate(nowDate);
        }
        while (!OtherUtils.dateToWeek(simpleDateFormat.format(nowDate)).equals("星期一")) {
            nowDate = addOneDate(nowDate);
            count++;
        }
        return ++count;
    }

    public static Date getSunDay(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date addDate = addDay(date);
        while (!OtherUtils.dateToWeek(simpleDateFormat.format(date)).equals("星期日")) {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            calendar.add(Calendar.DATE, 1);
            date = calendar.getTime();
        }
//        System.out.println(count);
        return date;
    }


    public static String getMondayDate(int count) {
        Date nowDate = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(nowDate);
        calendar.add(Calendar.DATE, count);
        nowDate = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String monday = sdf.format(nowDate);
        return monday;
    }

    public static AmPm getAmPm() {
        LocalTime nowTime = LocalTime.now();
        //上午时间段
        LocalTime amStart = LocalTime.of(8, 0, 0);
        LocalTime amEnd = LocalTime.of(12, 0, 0);
        //下午时间段
        LocalTime pmStart = LocalTime.of(13, 30, 0);
        LocalTime pmEnd = LocalTime.of(17, 30, 0);
        AmPm amPm = null;
        if (nowTime.compareTo(amStart) > 0 && nowTime.compareTo(amEnd) < 0) {
            amPm = AmPm.AM;
        } else if (nowTime.compareTo(pmStart) > 0 && nowTime.compareTo(pmEnd) < 0) {
            amPm = AmPm.PM;
        } else {
            amPm = AmPm.NO;
        }
        return amPm;
    }

    public static AmPm getAmPm(LocalTime t) {
        //上午时间段
        LocalTime amStart = LocalTime.of(8, 0, 0);
        LocalTime amEnd = LocalTime.of(12, 0, 0);
        //下午时间段
        LocalTime pmStart = LocalTime.of(13, 30, 0);
        LocalTime pmEnd = LocalTime.of(17, 30, 0);
        AmPm amPm = null;
        if (t.compareTo(amStart) < 0) {
            amPm = AmPm.beforeAM;
        } else if (t.compareTo(amStart) > 0 && t.compareTo(amEnd) < 0) {
            amPm = AmPm.AM;
        } else if (t.compareTo(pmStart) < 0) {
            amPm = AmPm.beforePM;
        } else if (t.compareTo(pmStart) > 0 && t.compareTo(pmEnd) < 0) {
            amPm = AmPm.PM;
        } else {
            amPm = AmPm.NO;
        }
        return amPm;
    }

    //判断是否相同
    public static boolean sameDate(Date date) {
        Date nowDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dataStr = sdf.format(date);
        String nowDateStr = sdf.format(nowDate);
        if (nowDateStr.equals(dataStr)) {
            return true;
        } else {
            return false;
        }
    }

    //判断是否爽约
    public static boolean queryBreakTimeDate(String pati_id) {
        boolean rightSubcirbe = true;
        PatientDao dao = new PatientDao();
        try {
            ArrangeDoctor arrangeDoctor = dao.queryWhetherBreak(pati_id);
            Date subMaxDate = arrangeDoctor.getArra_subdate();
            String subMaxAmPm = arrangeDoctor.getArra_ampm();
            if (subMaxDate != null && subMaxAmPm != null) {
                Date nowDate = new Date();
                boolean breakFlag = true;
                if (OtherUtils.sameDate(subMaxDate)) { //相同日期
                    if (subMaxAmPm.equals("am")) {//在上午时间段
                        if (OtherUtils.getAmPm() == AmPm.AM || OtherUtils.getAmPm() == AmPm.beforeAM) {
                            breakFlag = false;
                        }
                    } else {
                        if (OtherUtils.getAmPm() == AmPm.PM || OtherUtils.getAmPm() == AmPm.beforePM) {
                            breakFlag = false;
                        }
                    }
                } else {//不相同日期
                    if (subMaxDate.compareTo(nowDate) < 0) {
                        breakFlag = false;
                    }
                }
                //假设已经爽约了，查看是否超过爽约的的日期和时间段的那个星期。
                if (!breakFlag) {
                    //1.先找出爽约的那个周日，然后是否已经超过现在的日期
                    Date sunDay = OtherUtils.getSunDay(subMaxDate);
//                    Date addOneDay = OtherUtils.addDay(nowDate);
                    if (nowDate.compareTo(sunDay) < 0) {
                        rightSubcirbe = false;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rightSubcirbe;

    }


    public static boolean queryBreakTimeDate(Date date, String ap) {
        boolean rightSubcirbe = true;
        if (date != null && ap != null) {
            Date nowDate = new Date();
            boolean breakFlag = true;
            if (OtherUtils.sameDate(date)) { //相同日期
                if (ap.equals("am")) {//在上午时间段
                    if (OtherUtils.getAmPm() == AmPm.AM || OtherUtils.getAmPm() == AmPm.beforeAM) {
                        breakFlag = false;
                    }
                } else {
                    if (OtherUtils.getAmPm() == AmPm.PM || OtherUtils.getAmPm() == AmPm.beforePM) {
                        breakFlag = false;
                    }
                }
            } else {//不相同日期
                if (date.compareTo(nowDate) < 0) {
                    breakFlag = false;
                }
            }
            //假设已经爽约了，查看是否超过爽约的的日期和时间段的那个星期。
            if (!breakFlag) {
                //1.先找出爽约的那个周日，然后是否已经超过现在的日期
                Date sunDay = OtherUtils.getSunDay(date);
//                Date addOneDay = OtherUtils.addDay(nowDate);
                if (nowDate.compareTo(sunDay) < 0) {
                    rightSubcirbe = false;
                }
            }
        }
        return rightSubcirbe;
    }


    public static DoctorPatient getDoctorPatient(ServletContext servletContext, HttpServletRequest request){
        List<Sectors> attribute = (List<Sectors>) servletContext.getAttribute(ApplictionListener.SECTOR);
//        NoticeDoctor noticeDoctor = new NoticeDoctor();
        HttpSession session = request.getSession(true);
        ClinicWorker d = (ClinicWorker)session.getAttribute(DoctorService.DOCTOR);
        for (Sectors sectors : attribute) {
            if(sectors.getSector().equals(d.getClin_type())){
                for (DoctorPatient doctorPatient : sectors.getDoctorPatientList()) {
                    if(doctorPatient.getDoctor().getClin_id().equals(d.getClin_id())){
//                        noticeDoctor.onMessage(JSON.toJSONString(doctorPatient));
                        return doctorPatient;
                    }
                }
            }
        }
        return null;
    }

    public static DoctorPatient setDoctorPatientNull(ClinicWorker clinicWorker){
        List<Sectors> attribute = (List<Sectors>) ApplictionListener.getAllSectorPatient();
//        NoticeDoctor noticeDoctor = new NoticeDoctor();
        for (int i = 0; i < attribute.size(); i++) {
            if(attribute.get(i).getSector().equals(clinicWorker.getClin_type())){

            }
        }
        for (Sectors sectors : attribute) {
            if(sectors.getSector().equals(clinicWorker.getClin_type())){
                for (DoctorPatient doctorPatient : sectors.getDoctorPatientList()) {
                    if(doctorPatient.getDoctor().getClin_id().equals(clinicWorker.getClin_id())){
//                        noticeDoctor.onMessage(JSON.toJSONString(doctorPatient));
                        sectors.getDoctorPatientList().remove(doctorPatient);
                        break;
                    }
                }
            }
        }
        return null;
    }



    //查看医生是否在线
    public static DoctorPatient toRegisterGetDoctorPatient(PatientRegister register){
        List<Sectors> allSectorPatient = ApplictionListener.getAllSectorPatient();
        for (Sectors sectors : allSectorPatient) {
            if(sectors.getSector().equals(register.getClin_type())){
                for (DoctorPatient doctorPatient : sectors.getDoctorPatientList()) {
                    if(doctorPatient.getDoctor().getClin_id().equals(register.getClin_id())){
//                        noticeDoctor.onMessage(JSON.toJSONString(doctorPatient));
                        return doctorPatient;
                    }
                }
            }
        }
        return null;
    }


    public static List<Sectors> setFristToLast(HttpServletRequest request){
        List<Sectors> allSectorPatient = ApplictionListener.getAllSectorPatient();

        HttpSession session = request.getSession(true);
        ClinicWorker d = (ClinicWorker)session.getAttribute(DoctorService.DOCTOR);

        for (Sectors sectors : allSectorPatient) {
            if(sectors.getSector().equals(d.getClin_type())){
                for (DoctorPatient doctorPatient : sectors.getDoctorPatientList()) {
                    if(doctorPatient.getDoctor().getClin_id().equals(d.getClin_id())){
                        LinkedList<PatientRegister> registerList = doctorPatient.getRegisterList();
                        PatientRegister first = registerList.removeFirst();
                        registerList.addLast(first);
                    }
                }
            }
        }
        return allSectorPatient;
    }

    public static void sendDoctorPatientList(String json){
        NoticeDoctor noticeDoctor = new NoticeDoctor();
        noticeDoctor.onMessage(json);
    }
    public static PrintWriter setAndGetJSONOut(HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        return response.getWriter();
    }

}
