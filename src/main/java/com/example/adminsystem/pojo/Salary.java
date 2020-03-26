package com.example.adminsystem.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工表
 */
public class Salary implements Serializable {

    private Integer sId;//id
    private String staffName;//员工姓名
    private double basePay;//基本工资
    private double daysOff;//休假天数
    private double ofWages;//预支工资
    private String currentMonth;//当前月份

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public double getBasePay() {
        return basePay;
    }

    public void setBasePay(double basePay) {
        this.basePay = basePay;
    }

    public double getDaysOff() {
        return daysOff;
    }

    public void setDaysOff(double daysOff) {
        this.daysOff = daysOff;
    }

    public double getOfWages() {
        return ofWages;
    }

    public void setOfWages(double ofWages) {
        this.ofWages = ofWages;
    }

    public String getCurrentMonth() {
        return currentMonth;
    }

    public void setCurrentMonth(String currentMonth) {
        this.currentMonth = currentMonth;
    }
}
