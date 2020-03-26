package com.example.adminsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by XiaoDu on 2019/6/26.
 */
@Controller
public class AllController {
    //跳转登录页面
    @RequestMapping("Login")
    public String findAdminLogin() {
        return "login";
    }

    //图片背景验证码
    @RequestMapping("index2")
    public ModelAndView index2() {
        return new ModelAndView("index2");
    }


    public boolean ljq(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("admin");
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }

    //跳转账本，的添加账本页面
    @RequestMapping("group_ticket_apply")
    public String group_ticket_apply() {
        return "group_ticket_apply";
    }

    //跳转库存，添加库存表
    @RequestMapping("manage")
    public String manage(HttpServletRequest request, HttpServletResponse response) {
        if (ljq(request)) {
            return "manage";
        } else {
            return "Login";
        }
    }

    //跳转到供应商，供应商管理
    @RequestMapping("buy_msg")
    public String buy_msg(HttpServletRequest request, HttpServletResponse response) {
        if (ljq(request)) {
            return "buy_msg";
        } else {
            return "Login";
        }
    }

    //跳转到供应商，添加供应商
    @RequestMapping("send_msg")
    public String send_msg(HttpServletRequest request, HttpServletResponse response) {
        if (ljq(request)) {
            return "send_msg";
        } else {
            return "Login";
        }
    }

    //跳转到供应商，添加工资
    @RequestMapping("salaryadd")
    public String salaryadd(HttpServletRequest request, HttpServletResponse response) {
        if (ljq(request)) {
            return "salaryadd";
        } else {
            return "Login";
        }
    }

    @RequestMapping("salaryadd2")
    public String salaryadd2(HttpServletRequest request, HttpServletResponse response) {
        if (ljq(request)) {
            return "salaryadd2";
        } else {
            return "Login";
        }
    }
    //跳转主页
    @RequestMapping("findAdminLogin2")
    public String findAdminLogin2(HttpSession session) {
        session.setAttribute("admin", "zdq");
        return "index";
    }

    @RequestMapping("exitLogin")
    public void exitLogin(HttpSession session, HttpServletResponse response) throws IOException {
        session.removeAttribute("admin");
        response.sendRedirect("/Login");
    }


}
