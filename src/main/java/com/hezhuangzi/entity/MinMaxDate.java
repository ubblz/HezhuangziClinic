package com.hezhuangzi.entity;

import com.alibaba.fastjson.serializer.ToStringSerializer;

import java.time.LocalDate;
import java.util.Date;

public class MinMaxDate {
    Date maxDate;
    Date minDate;

    public Date getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(Date maxDate) {
        this.maxDate = maxDate;
    }

    public Date getMinDate() {
        return minDate;
    }

    public void setMinDate(Date minDate) {
        this.minDate = minDate;
    }


    @Override
    public String toString() {
        return "MinMaxDate{" +
                "maxDate=" + maxDate +
                ", minDate=" + minDate +
                '}';
    }

    public boolean nowDateCompareToMinDate(){
        Date nowDate = new Date();
        if(minDate.after(nowDate)){
            return true;
        }else{
            return false;
        }

    }

}
