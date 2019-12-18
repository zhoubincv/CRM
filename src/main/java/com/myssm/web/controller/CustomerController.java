package com.myssm.web.controller;

import com.myssm.common.utils.PageBean;
import com.myssm.pojo.BaseDict;
import com.myssm.pojo.Customer;
import com.myssm.pojo.QueryCustomer;
import com.myssm.service.BaseDictService;
import com.myssm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.List;

@Controller
public class CustomerController {
    @Value("${base_dict.source}")
    private String baseDictSource;
    @Value("${base_dict.industry}")
    private String baseDictIndustry;
    @Value("${base_dict.level}")
    private String baseDictLevel;

    @Autowired
    private BaseDictService baseDictService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/list")
//    @ResponseBody
    public String customerList(QueryCustomer queryCustomer, Model model){
//        初始化查询条件
        List<BaseDict> sourceList = baseDictService.findByTypeCode(baseDictSource);
        List<BaseDict> industryList = baseDictService.findByTypeCode(baseDictIndustry);
        List<BaseDict> levelList = baseDictService.findByTypeCode(baseDictLevel);
        model.addAttribute("sourceList", sourceList);
        model.addAttribute("industryList", industryList);
        model.addAttribute("levelList", levelList);

        if(queryCustomer.getCurrentPage()==0){
            queryCustomer.setCurrentPage(1);
        }
        if(queryCustomer.getPageSize()==0){
            queryCustomer.setPageSize(5);
        }
        queryCustomer.setStartPage((queryCustomer.getCurrentPage()-1)*queryCustomer.getPageSize());
//        回显数据
        model.addAttribute("custName", queryCustomer.getCustName());
        model.addAttribute("custIndustry", queryCustomer.getCustIndustry());
        model.addAttribute("custLevel", queryCustomer.getCustLevel());
        model.addAttribute("custSource", queryCustomer.getCustSource());

//        展示分页数据
        PageBean pageBean = customerService.findByPage(queryCustomer);
        model.addAttribute("page", pageBean);

        return "customer";
    }
    @RequestMapping("/edit")
    @ResponseBody
    public Customer editCustomer(long id){
//        编辑页面展示
        return customerService.findByCustomerId(id);
    }

    @RequestMapping("/update")
    @ResponseBody
    public boolean updateCustomer(Customer customer){
        try {
            customerService.updateCustomer(customer);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @RequestMapping("/delete")
    @ResponseBody
    public boolean deleteCustomer(long id){
        try {
            customerService.deleteCustomer(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
