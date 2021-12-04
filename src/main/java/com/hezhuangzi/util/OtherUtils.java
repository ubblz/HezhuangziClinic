package com.hezhuangzi.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OtherUtils {
    public static String getCurrentTimeMillis(){
        SimpleDateFormat df = new SimpleDateFormat("yyMMddHHmmss");
        String ctm = df.format(new Date());
        return ctm;
    }
}
