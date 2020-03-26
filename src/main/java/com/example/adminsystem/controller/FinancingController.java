package com.example.adminsystem.controller;

import com.example.adminsystem.mapper.FinancingMapper;
import com.example.adminsystem.pojo.Financing;
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
public class FinancingController {
    @Autowired
    private FinancingMapper mapper;

    public boolean ljq(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("admin");
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 按条件查询数据和分页
     *
     * @param model
     * @param financing
     * @param pageNum
     * @return
     */
    @RequestMapping("findFinancingAll")
    public ModelAndView findFinancingAll(HttpServletRequest request, Model model, Financing financing, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        if (ljq(request)) {
            //pageNum为下标位置，后者为页面容量
            PageHelper.startPage(pageNum, 12);
            List<Financing> financingAll = mapper.findFinancingAll(financing);
            PageInfo<Financing> pageInfo = new PageInfo<Financing>(financingAll);
            //需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
            model.addAttribute("pageInfo", pageInfo);
            model.addAttribute("financingAlls", financingAll);//存储Financing表数据
            model.addAttribute("PlateNum", financing.getPlateNum());//存储车牌号
            model.addAttribute("payWay", financing.getPayWay());//存储支付方式
            model.addAttribute("maintainPrincipal", financing.getMaintainPrincipal());//存储维修负责人
            model.addAttribute("maintainDate", financing.getMaintainDate());//存储维修日期
            model.addAttribute("billsDueObligor", financing.getBillsDueObligor());//存储欠账人
            return new ModelAndView("index");
        } else {
            return new ModelAndView("login");
        }
    }

    /**
     * 异步：根据id查询账本信息
     *
     * @param fId
     * @return
     */
    @ResponseBody
    @RequestMapping("findFinancingId")
    public Object findFinancingId(Integer fId, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (ljq(request)) {
            Financing financingId = mapper.findFinancingId(fId);
            return financingId;
        } else {
            response.sendRedirect("/Login");
            return "0";
        }
    }

    /**
     * 异步：修改账本信息
     *
     * @param financing
     * @return
     */
    @ResponseBody
    @RequestMapping("updateFinancingId")
    public int updateFinancingId(Financing financing, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (ljq(request)) {
            int i = mapper.updateFinancingId(financing);
            return i;
        } else {
            response.sendRedirect("/Login");
            return 0;
        }
    }

    /**
     * 异步：添加账本信息
     *
     * @param financing
     * @return
     */
    @ResponseBody
    @RequestMapping("addFinancingAll")
    public int addFinancingAll(Financing financing, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (ljq(request)) {
            if (financing.getPayWay() == " ") {
                financing.setPayWay("无欠账");
            }
            int i = mapper.addFinancingAll(financing);
            return i;
        } else {
            response.sendRedirect("/Login");
            return 0;
        }
    }
}
