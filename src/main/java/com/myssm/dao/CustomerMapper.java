package com.myssm.dao;

import com.myssm.pojo.Customer;
import com.myssm.pojo.QueryCustomer;

import java.util.List;

public interface CustomerMapper {
    List<Customer> findCustomerList(QueryCustomer queryCustomer);

    int findTotalCount(QueryCustomer queryCustomer);

    Customer findByCustomerId(long id);

    void updateCustomer(Customer customer);

    void deleteCustomer(long id);
}
