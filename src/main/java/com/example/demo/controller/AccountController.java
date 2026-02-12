package com.example.demo.controller;

import com.example.demo.dto.AccountCreationRequest;
import com.example.demo.dto.AccountCreationResponse;
import com.example.demo.dto.CustomerInquiryResponse;
import com.example.demo.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping
    public ResponseEntity<AccountCreationResponse> create(@Valid @RequestBody AccountCreationRequest request) {
        AccountCreationResponse response = accountService.createAccount(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{customerNumber}")
    public ResponseEntity<CustomerInquiryResponse> getCustomer(@PathVariable Long customerNumber) {
        CustomerInquiryResponse response = accountService.getCustomer(customerNumber);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

}
