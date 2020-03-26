package com.example.adminsystem.pojo;

import java.io.Serializable;
import java.util.Date;
/**
 * 客户表
 */
public class Financing implements Serializable {
    private Integer fId;//id
    private String maintainDate="";//维修日期
    private String PlateNum="";//车牌号
    private String maintenanceItems;//维修项目
    private double itemsMoney;//维修项目价格
    private String payWay="";//支付方式(现金，支付宝，微信，欠账)
    private String maintainPrincipal="";//维修负债人
    private String billsDueObligor;//欠账负责人
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getMaintainDate() {
        return maintainDate;
    }

    public void setMaintainDate(String maintainDate) {
        this.maintainDate = maintainDate;
    }

    public String getPlateNum() {
        return PlateNum;
    }

    public void setPlateNum(String plateNum) {
        PlateNum = plateNum;
    }

    public String getMaintenanceItems() {
        return maintenanceItems;
    }

    public void setMaintenanceItems(String maintenanceItems) {
        this.maintenanceItems = maintenanceItems;
    }

    public double getItemsMoney() {
        return itemsMoney;
    }

    public void setItemsMoney(double itemsMoney) {
        this.itemsMoney = itemsMoney;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public String getMaintainPrincipal() {
        return maintainPrincipal;
    }

    public void setMaintainPrincipal(String maintainPrincipal) {
        this.maintainPrincipal = maintainPrincipal;
    }

    public String getBillsDueObligor() {
        return billsDueObligor;
    }

    public void setBillsDueObligor(String billsDueObligor) {
        this.billsDueObligor = billsDueObligor;
    }
}
