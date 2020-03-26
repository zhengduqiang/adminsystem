package com.example.adminsystem.controller;

import com.example.adminsystem.mapper.BonusandfineMapper;
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

@Controller
public class BonusandfineController {
    @Autowired
    private BonusandfineMapper mapper;

    public boolean ljq(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("admin");
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 同步：查询罚款奖金表的所有数据按照条件查询
     *
     * @param model
     * @param bonusandfine
     * @param pageNum
     * @return
     */
    @RequestMapping("findBonusandfineAll")
    public ModelAndView findSalaryAll(HttpServletRequest request, Model model, Bonusandfine bonusandfine, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        if (ljq(request)) {
            //pageNum为下标位置，后者为页面容量
            PageHelper.startPage(pageNum, 12);
            List<Bonusandfine> bonusandfineAll = mapper.findBonusandfineAll(bonusandfine);
            PageInfo<Bonusandfine> pageInfo = new PageInfo<Bonusandfine>(bonusandfineAll);
            //需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
            model.addAttribute("pageInfo", pageInfo);
            model.addAttribute("bonusandfineAlls", bonusandfineAll);//存储Bonusandfine表数据
            model.addAttribute("staffName", bonusandfine.getStaffName());//存储员工姓名
            model.addAttribute("bonusandfineDate", bonusandfine.getBonusandfineDate());//存储添加时间
            return new ModelAndView("bonusadmin");
        } else {
            return new ModelAndView("Login");
        }
    }

    /**
     * 异步：根据id查询奖罚信息
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("findBonusandfine")
    public Object findBonusandfine(Integer bId, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (ljq(request)) {
            Bonusandfine bonusandfine = mapper.findBonusandfine(bId);
            return bonusandfine;
        } else {
            response.sendRedirect("/Login");
            return "0";
        }
    }

    /**
     * 异步：修改奖罚信息
     *
     * @param financing
     * @return
     */
    @ResponseBody
    @RequestMapping("updateBonusandfine")
    public int updateBonusandfine(Bonusandfine financing, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (ljq(request)) {
            int i = mapper.updateBonusandfine(financing);
            return i;
        } else {
            response.sendRedirect("/Login");
            return 0;
        }

    }

    /**
     * 异步：删除奖罚信息
     *
     * @param bId
     * @return
     */
    @ResponseBody
    @RequestMapping("deleteBonusandfinebId")
    public int deleteBonusandfinebId(Integer bId, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (ljq(request)) {
            int i = mapper.deleteBonusandfinebId(bId);
            return i;
        } else {
            response.sendRedirect("/Login");
            return 0;
        }
    }

    /**
     * 异步：添加奖惩信息
     *
     * @param bonusandfine
     * @return
     */
    @ResponseBody
    @RequestMapping("addBonusandfine")
    public int addBonusandfine(Bonusandfine bonusandfine, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (ljq(request)) {
            int i = mapper.addBonusandfine(bonusandfine);
            return i;
        } else {
            response.sendRedirect("/Login");
            return 0;
        }
    }


}
