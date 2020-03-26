package com.example.adminsystem.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * 仓库表
 */
public class Inventory implements Serializable {
    private Integer iId;
    private String number;//编号
    private String commodityName;//商品名称
    private String model;//型号
    private String unit;//单位
    private String inventoryDate;//添加时间
    private double commodityMoney;//商品金额
    private int residue;//剩余商品
    private String warehouse;//仓库(仓库1，仓库2，仓库3)
    private Integer comeEnterNum;
    private String type;

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public Integer getComeEnterNum() {
        return comeEnterNum;
    }

    public void setComeEnterNum(Integer comeEnterNum) {
        this.comeEnterNum = comeEnterNum;
    }

    public Integer getiId() {
        return iId;
    }

    public void setiId(Integer iId) {
        this.iId = iId;
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

    public String getInventoryDate() {
        return inventoryDate;
    }

    public void setInventoryDate(String inventoryDate) {
        this.inventoryDate = inventoryDate;
    }

    public double getCommodityMoney() {
        return commodityMoney;
    }

    public void setCommodityMoney(double commodityMoney) {
        this.commodityMoney = commodityMoney;
    }

    public int getResidue() {
        return residue;
    }

    public void setResidue(int residue) {
        this.residue = residue;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }
}
