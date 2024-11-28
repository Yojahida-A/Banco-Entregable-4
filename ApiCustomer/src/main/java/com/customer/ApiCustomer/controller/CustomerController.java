package com.customer.ApiCustomer.controller;

import com.customer.ApiCustomer.model.Customer;
import java.util.List;
import java.util.Map;

import com.customer.ApiCustomer.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/customers")

@Tag(name = "Customers", description = "Customer Management")

public class CustomerController {
    @Autowired
    private  CustomerService customerService;


    @Operation(summary = "List all customers")
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }


    @Operation(summary = "Create a new customer")
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.createCustomer(customer), HttpStatus.CREATED);
    }

    @Operation(summary = "Get customer by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        return customer != null ? ResponseEntity.ok(customer) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Update customer")
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.updateCustomer(id, customer), HttpStatus.OK);
    }

    @Operation(summary = "Delete customer")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }





}
