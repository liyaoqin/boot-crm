package com.itheima.crm.controller;

import com.itheima.crm.pojo.BaseDict;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.service.BaseDictService;
import com.itheima.crm.service.CustomerService;
import com.itheima.crm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private BaseDictService dictService;
    @Autowired
    private CustomerService customerService;
    @Value("${customer_from_type}")
    private String customer_from_type;
    @Value("${customer_industry_type}")
    private String customer_industry_type;
    @Value("${customer_level_type}")
    private String customer_level_type;
    @RequestMapping("/list")
    public String list(Model model, QueryVo vo) throws UnsupportedEncodingException {
        List<BaseDict> fromType=dictService.getBaseDictByCode(customer_from_type);
        List<BaseDict> industryType=dictService.getBaseDictByCode(customer_industry_type);
        List<BaseDict> levelType=dictService.getBaseDictByCode(customer_level_type);
        model.addAttribute("fromType",fromType);
        model.addAttribute("industryType",industryType);
        model.addAttribute("levelType",levelType);
        Page<Customer> page=customerService.getCustomerByQueryVo(vo);
        model.addAttribute("page",page);
        return "customer";
    }
    @RequestMapping("edit")
    @ResponseBody
    public Customer edit(Integer id){
        Customer customer = customerService.getCustomerById(id);
        return customer;
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(Customer customer){
        String msg = "1";
        try {
            customerService.updateCustomer(customer);
            msg = "0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }
    @RequestMapping("delete")
    @ResponseBody
    public String delete(Integer id){
        String msg = "1";
        try {
            customerService.deleteCustomer(id);
            msg = "0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }
    @RequestMapping("myTag")
public String myTag(){
        return "myTag";
}
}
