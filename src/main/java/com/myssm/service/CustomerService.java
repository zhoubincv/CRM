package com.myssm.service;

import com.myssm.common.utils.PageBean;
import com.myssm.pojo.Customer;
import com.myssm.pojo.QueryCustomer;

public interface CustomerService {
    PageBean findByPage(QueryCustomer queryCustomer);

    Customer findByCustomerId(long id);

    void updateCustomer(Customer customer);

    void deleteCustomer(long id);
}
