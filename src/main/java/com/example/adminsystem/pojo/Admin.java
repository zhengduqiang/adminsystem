package com.example.adminsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin implements Serializable {
    private Integer id;//id
    private String admin;//用户名
    private String pwd;//密码
    private String sjs;//随机数

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSjs() {
        return sjs;
    }

    public void setSjs(String sjs) {
        this.sjs = sjs;
    }
}
