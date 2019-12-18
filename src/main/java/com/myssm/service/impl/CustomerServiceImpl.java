package com.myssm.service.impl;

import com.myssm.common.utils.PageBean;
import com.myssm.dao.CustomerMapper;
import com.myssm.pojo.Customer;
import com.myssm.pojo.QueryCustomer;
import com.myssm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private PageBean pageBean;

    @Autowired
    private CustomerMapper customerMapper;

    public Customer findByCustomerId(long id) {

        return customerMapper.findByCustomerId(id);
    }

    public PageBean findByPage(QueryCustomer queryCustomer) {
        List<Customer> customerList = customerMapper.findCustomerList(queryCustomer);
        pageBean.setList(customerList);
        int totalCount = customerMapper.findTotalCount(queryCustomer);
        pageBean.setTotalCount(totalCount);
        pageBean.setCurrentPage(queryCustomer.getCurrentPage());
        pageBean.setPageSize(queryCustomer.getPageSize());
        return pageBean;
    }

    public void updateCustomer(Customer customer) {

        customerMapper.updateCustomer(customer);
    }

    public void deleteCustomer(long id) {

        customerMapper.deleteCustomer(id);
    }
}
