package com.example.demo.service.impl;

import com.example.demo.dto.AccountCreationRequest;
import com.example.demo.dto.AccountCreationResponse;
import com.example.demo.dto.CustomerInquiryResponse;
import com.example.demo.entity.Account;
import com.example.demo.entity.Customer;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class AccountServiceImpl implements AccountService {


    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;

    public AccountServiceImpl(CustomerRepository customerRepository, AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountCreationResponse createAccount(AccountCreationRequest request) {
        Customer customer = new Customer();
        customer.setCustomerNumber(ThreadLocalRandom.current().nextLong(10000000, 99999999));
        customer.setCustomerName(request.getCustomerName());
        customer.setCustomerMobile(request.getCustomerMobile());
        customer.setCustomerEmail(request.getCustomerEmail());
        customer.setAddress1(request.getAddress1());
        customer.setAddress2(request.getAddress2());

        Account account = new Account();
        account.setAccountNumber(ThreadLocalRandom.current().nextLong(10000, 99999));
        account.setAccountType(request.getAccountType());
        account.setAvailableBalance(0.0);
        account.setCustomer(customer);


        System.err.println(customer.getCustomerNumber());
        System.err.println(customer.getCustomerName());
        System.err.println(customer.getCustomerMobile());

        System.err.println(account.getAccountNumber());
        System.err.println(account.getCustomer());
        customer.getAccounts().add(account);

        customerRepository.save(customer);

        return new AccountCreationResponse(
                customer.getCustomerNumber(),
                201,
                "Customer account created"
        );
    }



    @Override
    public CustomerInquiryResponse getCustomer(Long customerNumber) {
        Customer customer = customerRepository.findByCustomerNumber(customerNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        return CustomerInquiryResponse.from(customer);
    }

}
