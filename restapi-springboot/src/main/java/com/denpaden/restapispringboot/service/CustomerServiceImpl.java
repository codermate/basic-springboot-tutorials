package com.denpaden.restapispringboot.service;

import com.denpaden.restapispringboot.model.Customer;
import com.denpaden.restapispringboot.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DenPaden on 18/08/2022.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Override
    public Customer save(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepo.findAll();
    }
}
