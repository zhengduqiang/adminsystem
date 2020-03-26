package com.example.adminsystem.controller;

import com.example.adminsystem.mapper.AdminMapper;
import com.example.adminsystem.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.util.DigestUtils;

import java.util.Random;

@Controller
public class AdminController {
    @Autowired
    private AdminMapper mapper;


    /**
     * 登录
     *
     * @param admin
     * @return
     */
    @ResponseBody
    @RequestMapping("findAdminLogin")
    public String findAdminLogin(Admin admin, HttpSession session, Model model) {
        String pwd = admin.getPwd() + "e1e5f098-e17f-4928-96e6-54bc46b03f0e";
        String md5Password = DigestUtils.md5DigestAsHex(pwd.getBytes());
        admin.setPwd(md5Password);
        Admin adminLogin = mapper.findAdminLogin(admin);
        if (adminLogin == null) {
            //登录失败！存放错误信息
            return "0";
        } else {
            session.setAttribute("admin", adminLogin);
            return "1";
        }
    }


}
