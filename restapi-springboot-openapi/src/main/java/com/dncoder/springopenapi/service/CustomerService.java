package com.dncoder.springopenapi.service;


import com.dncoder.springopenapi.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DenPaden on 18/08/2022.
 */
@Service
public interface CustomerService {
    public Customer save(Customer customer);
    public List<Customer> getAll();
}
