package com.example.adminsystem.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 供应商表
 */
public class Supplier implements Serializable {
    private Integer nId;//id
    private String supplierName;//供应商名称
    private String supplierDate;//日期
    private double loanAmount;//货款金额
    private double amountInArear;//欠款金额
    private double settlementAmout;//结算金额
    private Date date2;

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public Integer getnId() {
        return nId;
    }

    public void setnId(Integer nId) {
        this.nId = nId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierDate() {
        return supplierDate;
    }

    public void setSupplierDate(String supplierDate) {
        this.supplierDate = supplierDate;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getAmountInArear() {
        return amountInArear;
    }

    public void setAmountInArear(double amountInArear) {
        this.amountInArear = amountInArear;
    }

    public double getSettlementAmout() {
        return settlementAmout;
    }

    public void setSettlementAmout(double settlementAmout) {
        this.settlementAmout = settlementAmout;
    }
}
