package com.hezhuangzi.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OtherUtils {
    public static String getCurrentTimeMillis(){
        SimpleDateFormat df = new SimpleDateFormat("yyMMddmmssSS");
        String ctm = df.format(new Date());
        return ctm;
    }
}
