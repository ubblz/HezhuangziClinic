package com.hezhuangzi.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class OtherUtils {

    public static String getCurrentTimeMillis(){
        SimpleDateFormat df = new SimpleDateFormat("yyMMddHHmmss");
        String ctm = df.format(new Date());
        return ctm;
    }

    public String convertAmPm(){
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());

        return "";
    }

    public static String subcribeNum(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSS");
        return sdf.format(new Date());
    }

    public static String dateConvert(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sdfDate = sdf.format(date);
        return sdfDate;
    }

}
