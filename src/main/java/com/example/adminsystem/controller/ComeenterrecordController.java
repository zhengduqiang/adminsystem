package com.example.adminsystem.controller;

import com.example.adminsystem.mapper.ComeenterrecordMapper;
import com.example.adminsystem.pojo.Comeenterrecord;
import com.example.adminsystem.pojo.Inventory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class ComeenterrecordController {

    @Autowired
    private ComeenterrecordMapper mapper;

    public boolean ljq(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("admin");
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 同步：查询所有出入库记录表信息包括条件和分页
     *
     * @param comeenterrecord
     * @param model
     * @param pageNum
     * @return
     */
    @RequestMapping("findComeenterrecordAll")
    public String findComeenterrecordAll(HttpServletRequest request, Comeenterrecord comeenterrecord, Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        if (ljq(request)) {
            //pageNum为下标位置，后者为页面容量
            PageHelper.startPage(pageNum, 11);
            List<Comeenterrecord> comeenterrecordAll = mapper.findComeenterrecordAll(comeenterrecord);
            PageInfo<Comeenterrecord> pageInfo = new PageInfo<Comeenterrecord>(comeenterrecordAll);
            //需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
            model.addAttribute("pageInfo", pageInfo);
            model.addAttribute("comeenterrecordAlls", comeenterrecordAll);//存储Comeenterrecord表数据
            model.addAttribute("commodityName", comeenterrecord.getCommodityName());//存储商品名称
            model.addAttribute("model", comeenterrecord.getModel());//存储型号
            model.addAttribute("unit", comeenterrecord.getUnit());//存储单位
            model.addAttribute("warehouse", comeenterrecord.getWarehouse());//存储仓库
            model.addAttribute("type", comeenterrecord.getType());//存储出入库类型
            model.addAttribute("comeEnterDate", comeenterrecord.getComeEnterDate());//存储出入库日期
            return "baobiao";
        } else {
            return "Login";
        }
    }

    /**
     * 异步：根据ID删除出入库记录
     *
     * @param cId
     * @return
     */
    @ResponseBody
    @RequestMapping("deleteComeenterrecord")
    public int deleteComeenterrecord(int cId, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (ljq(request)) {
            int i = mapper.deleteComeenterrecord(cId);
            return i;
        } else {
            response.sendRedirect("/Login");
            return 0;
        }
    }

    /**
     * 异步：添加一条记录到出入库记录表里面
     *
     * @param comeenterrecord
     * @return
     */
    @ResponseBody
    @RequestMapping("addComeenterrecord")
    public int addComeenterrecord(Comeenterrecord comeenterrecord, Inventory inventory, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (ljq(request)) {
            int i1 = mapper.updateInventory(inventory);
            int i = mapper.addComeenterrecord(comeenterrecord);
            return i;
        } else {
            response.sendRedirect("/Login");
            return 0;
        }
    }

    /**
     * 异步：出入库修改商品数量
     *
     * @param inventory
     * @return
     */
    @ResponseBody
    @RequestMapping("updateInventory")
    public int updateInventory(Inventory inventory, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(ljq(request)){
            int i = mapper.updateInventory(inventory);
            return i;
        }else{
            response.sendRedirect("/Login");
            return 0;
        }
    }

}
