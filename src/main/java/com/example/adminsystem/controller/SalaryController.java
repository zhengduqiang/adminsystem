package com.example.adminsystem.controller;

import com.example.adminsystem.mapper.SalaryMapper;
import com.example.adminsystem.pojo.Bonusandfine;
import com.example.adminsystem.pojo.Financing;
import com.example.adminsystem.pojo.Salary;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by XiaoDu on 2019/6/26.
 */
@Controller
public class SalaryController {

    @Autowired
    private SalaryMapper mapper;

    public boolean ljq(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("admin");
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 同步：查询所有员工工资和按条件查询
     *
     * @param model
     * @param salary
     * @param pageNum
     * @return
     */
    @RequestMapping("findSalaryAll")
    public ModelAndView findSalaryAll(HttpServletRequest request, Model model, Salary salary, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        if (ljq(request)) {
            //pageNum为下标位置，后者为页面容量
            PageHelper.startPage(pageNum, 12);
            List<Salary> financingAll = mapper.findSalaryAll(salary);
            PageInfo<Salary> pageInfo = new PageInfo<Salary>(financingAll);
            //需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
            model.addAttribute("pageInfo", pageInfo);
            model.addAttribute("financingAlls", financingAll);//存储Financing表数据
            model.addAttribute("staffName", salary.getStaffName());//存储员工姓名
            model.addAttribute("currentMonth", salary.getCurrentMonth());//存储添加时间
            return new ModelAndView("salaryadmin");
        } else {
            return new ModelAndView("Login");
        }
    }

    /**
     * 异步：根据id查询员工工资信息
     *
     * @param sId
     * @return
     */
    @ResponseBody
    @RequestMapping("findSalaryId")
    public Object findFinancingId(Integer sId,HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (ljq(request)) {Salary salarysId = mapper.findSalarysId(sId);
            return salarysId;
        } else {
            response.sendRedirect("/Login");
            return "0";
        }
    }

    /**
     * 异步：根据ID修改员工工资
     *
     * @param salary
     * @return
     */
    @ResponseBody
    @RequestMapping("updateSalarysId")
    public int updateSalarysId(Salary salary,HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (ljq(request)) {
            int i = mapper.updateSalarysId(salary);
            return i;
        } else {
            response.sendRedirect("/Login");
            return 0;
        }
    }

    /**
     * 异步：添加员工工资信息
     *
     * @param salary
     * @return
     */
    @ResponseBody
    @RequestMapping("addSalaryAll")
    public int addSalaryAll(Salary salary,HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (ljq(request)) {
            int i = mapper.addSalaryAll(salary);
            return i;
        } else {
            response.sendRedirect("/Login");
            return 0;
        }
    }


}
