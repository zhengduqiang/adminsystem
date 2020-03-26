package com.example.adminsystem.controller;

import com.example.adminsystem.mapper.InventoryMapper;
import com.example.adminsystem.pojo.Financing;
import com.example.adminsystem.pojo.Inventory;
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
import java.io.IOException;
import java.util.List;

@Controller
public class InventoryController {

    @Autowired
    private InventoryMapper mapper;

    public boolean ljq(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("admin");
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 同步：查询所有库存信息数据和条件查询加分页
     *
     * @param inventory
     * @param model
     * @param pageNum
     * @return
     */
    @RequestMapping("findInventoryAll")
    public String findInventoryAll(HttpServletRequest request, Inventory inventory, Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        if (ljq(request)) {
            //pageNum为下标位置，后者为页面容量
            PageHelper.startPage(pageNum, 12);
            List<Inventory> inventoryAll = mapper.findInventoryAll(inventory);
            PageInfo<Inventory> pageInfo = new PageInfo<Inventory>(inventoryAll);
            //需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
            model.addAttribute("pageInfo", pageInfo);
            model.addAttribute("inventoryAlls", inventoryAll);//存储inventory表数据
            model.addAttribute("commodityName", inventory.getCommodityName());//存储商品名称
            model.addAttribute("warehouse", inventory.getWarehouse());//存储几号仓库
            model.addAttribute("model", inventory.getModel());//存储型号
            model.addAttribute("unit", inventory.getUnit());//存储单位
            return "detail";
        } else {
            return "Login";
        }
    }

    /**
     * 异步：根据Id查询库存信息
     *
     * @param iId
     * @return
     */
    @ResponseBody
    @RequestMapping("findInventoryiId")
    public Object findInventoryiId(Integer iId, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(ljq(request)){
            Inventory inventoryiId = mapper.findInventoryiId(iId);
            return inventoryiId;
        }else{
            response.sendRedirect("/Login");
            return iId;
        }
    }

    /**
     * 异步：根据Id修改库存信息
     *
     * @param inventory
     * @return
     */
    @ResponseBody
    @RequestMapping("updateInventoryiId")
    public int updateInventoryiId(Inventory inventory, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (ljq(request)) {
            int i = mapper.updateInventoryiId(inventory);
            return i;
        } else {
            response.sendRedirect("/Login");
            return 0;
        }
    }

    /**
     * 异步：根据ID删除库存信息
     *
     * @param iId
     * @return
     */
    @ResponseBody
    @RequestMapping("deleteInventoryiId")
    public int deleteInventoryiId(Integer iId, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(ljq(request)){
            int i = mapper.deleteInventoryiId(iId);
            return i;
        }else{
            response.sendRedirect("/Login");
            return 0;
        }
    }

    /**
     * 异步：添加库存信息
     *
     * @param inventory
     * @return
     */
    @ResponseBody
    @RequestMapping("addInventoryAll")
    public int addInventoryAll(Inventory inventory, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(ljq(request)){
            int i = mapper.addInventoryAll(inventory);
            return i;
        }else{
            response.sendRedirect("/Login");
            return 0;
        }
    }

}
