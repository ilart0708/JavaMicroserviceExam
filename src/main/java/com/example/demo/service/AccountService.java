package com.example.demo.service;

import com.example.demo.dto.AccountCreationRequest;
import com.example.demo.dto.AccountCreationResponse;
import com.example.demo.dto.CustomerInquiryResponse;

public interface AccountService {
    AccountCreationResponse createAccount(AccountCreationRequest request);
    CustomerInquiryResponse getCustomer(Long customerNumber);
}
