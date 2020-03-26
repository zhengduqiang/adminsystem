package com.example.adminsystem.controller;

import com.example.adminsystem.mapper.SupplierMapper;
import com.example.adminsystem.pojo.Comeenterrecord;
import com.example.adminsystem.pojo.Supplier;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by XiaoDu on 2019/6/26.
 */
@Controller
public class SupplierController {
    @Autowired
    private SupplierMapper mapper;

    public boolean ljq(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("admin");
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 同步：查询所有供应商信息和按照条件查询
     *
     * @param model
     * @param supplier
     * @param pageNum
     * @return
     */
    @RequestMapping("findSupplierAll")
    public String findSupplierAll(HttpServletRequest request, Model model, Supplier supplier, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        if (ljq(request)) {
            //pageNum为下标位置，后者为页面容量
            PageHelper.startPage(pageNum, 11);
            List<Supplier> supplierAll = mapper.findSupplierAll(supplier);
            PageInfo<Supplier> pageInfo = new PageInfo<Supplier>(supplierAll);
            //需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
            model.addAttribute("pageInfo", pageInfo);
            model.addAttribute("supplierAlls", supplierAll);//存储Comeenterrecord表数据
            model.addAttribute("supplierName", supplier.getSupplierName());//存储商品名称
            model.addAttribute("supplierDate", supplier.getSupplierDate());//存储日期
            return "buy_msg";
        } else {
            return "Login";
        }
    }

    /**
     * 异步：根据ID查询供应商信息
     *
     * @param nId
     * @return
     */
    @ResponseBody
    @RequestMapping("findSuppliernId")
    public Object findSuppliernId(Integer nId, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (ljq(request)) {
            Supplier suppliernId = mapper.findSuppliernId(nId);
            return suppliernId;
        } else {
            response.sendRedirect("/Login");
            return "0";
        }
    }

    /**
     * 异步：根据nId修改供应商信息
     *
     * @param supplier
     * @return
     */
    @ResponseBody
    @RequestMapping("updateSuppliernId")
    public int updateSuppliernId(Supplier supplier, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (ljq(request)) {
            int i = mapper.updateSuppliernId(supplier);
            return i;
        } else {
            response.sendRedirect("/Login");
            return 0;
        }
    }

    /**
     * 异步：删除供应商信息
     *
     * @param nId
     * @return
     */
    @ResponseBody
    @RequestMapping("deleteSuppliernId")
    public int deleteSuppliernId(int nId, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (ljq(request)) {
            int i = mapper.deleteSuppliernId(nId);
            return i;
        } else {
            response.sendRedirect("/Login");
            return 0;
        }
    }

    /**
     * 异步：添加供应商信息
     *
     * @param supplier
     * @return
     */
    @ResponseBody
    @RequestMapping("addSupplier")
    public int addSupplier(Supplier supplier, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (ljq(request)) {
            int i = mapper.addSupplier(supplier);
            return i;
        } else {
            response.sendRedirect("/Login");
            return 0;
        }
    }

}
