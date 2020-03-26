package com.example.adminsystem.pojo;

import java.io.Serializable;
import java.util.Date;

/*
* 出入库记录表
* */
public class Comeenterrecord implements Serializable {
    private Integer cId;//id
    private String number;//编号
    private String commodityName;//商品名称
    private String model;//型号
    private String unit;//单位
    private String type;//状态是出库还是入库
    private String comeEnterDate;//出入库时间
    private int comeEnterNum;//出入库多少商品
    private String remark;//出入库备注
    private String warehouse;//几号仓库

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getComeEnterDate() {
        return comeEnterDate;
    }

    public void setComeEnterDate(String comeEnterDate) {
        this.comeEnterDate = comeEnterDate;
    }

    public int getComeEnterNum() {
        return comeEnterNum;
    }

    public void setComeEnterNum(int comeEnterNum) {
        this.comeEnterNum = comeEnterNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }
}
