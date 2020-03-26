package com.example.adminsystem.pojo;

import java.io.Serializable;
import java.util.Date;

/*奖金和罚款表*/
public class Bonusandfine implements Serializable {
    private Integer bId;
    private String staffName;//员工姓名
    private double bonus;//奖金金额
    private String bonusRemark;//奖金备注
    private double fine;//罚款金额
    private String fineRemark;//罚款备注
    private String bonusandfineDate;//奖金和罚款月份

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public String getBonusRemark() {
        return bonusRemark;
    }

    public void setBonusRemark(String bonusRemark) {
        this.bonusRemark = bonusRemark;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public String getFineRemark() {
        return fineRemark;
    }

    public void setFineRemark(String fineRemark) {
        this.fineRemark = fineRemark;
    }

    public String getBonusandfineDate() {
        return bonusandfineDate;
    }

    public void setBonusandfineDate(String bonusandfineDate) {
        this.bonusandfineDate = bonusandfineDate;
    }
}
