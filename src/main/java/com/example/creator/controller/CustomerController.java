package com.example.creator.controller;

import com.example.creator.model.Customer;
import com.example.creator.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(value = "/customer")
    public List<Customer> getCustomer(){
        return customerRepository.findAll();
    }

    @PostMapping(value = "/saved")
    public String saveCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return "Saved";
    }

    @PutMapping(value = "update/{id}")
    public String updateCustomer(@PathVariable int id, @RequestBody Customer customer){
        Customer updatedCustomer = customerRepository.findById(id).get();
        updatedCustomer.setName(customer.getName());
        updatedCustomer.setSurname(customer.getSurname());
        updatedCustomer.setAddress(customer.getAddress());
        updatedCustomer.setEmail(customer.getEmail());
        updatedCustomer.setNipNumber(customer.getNipNumber());
        updatedCustomer.setPostcode(customer.getPostcode());
        customerRepository.save(updatedCustomer);
        return "Updated";
    }
}
