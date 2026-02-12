package com.example.demo.dto;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Account;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerInquiryResponse {
    private Long customerNumber;
    private String customerName;
    private String customerMobile;
    private String customerEmail;
    private String address1;
    private String address2;
    private List<AccountResponse> savings;
    private int transactionStatusCode;
    private String transactionStatusDescription;

    public CustomerInquiryResponse(Long customerNumber, String customerName, String customerMobile,
                                   String customerEmail, String address1, String address2,
                                   List<AccountResponse> savings, int transactionStatusCode,
                                   String transactionStatusDescription) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.customerMobile = customerMobile;
        this.customerEmail = customerEmail;
        this.address1 = address1;
        this.address2 = address2;
        this.savings = savings;
        this.transactionStatusCode = transactionStatusCode;
        this.transactionStatusDescription = transactionStatusDescription;
    }

    public Long getCustomerNumber() { return customerNumber; }
    public String getCustomerName() { return customerName; }
    public String getCustomerMobile() { return customerMobile; }
    public String getCustomerEmail() { return customerEmail; }
    public String getAddress1() { return address1; }
    public String getAddress2() { return address2; }
    public List<AccountResponse> getSavings() { return savings; }
    public int getTransactionStatusCode() { return transactionStatusCode; }
    public String getTransactionStatusDescription() { return transactionStatusDescription; }


    public static CustomerInquiryResponse from(Customer customer) {
        List<AccountResponse> accounts = customer.getAccounts().stream()
                .map(account -> new AccountResponse(
                        account.getAccountNumber(),
                        account.getAccountType().name(),
                        account.getAvailableBalance()
                ))
                .collect(Collectors.toList());

        return new CustomerInquiryResponse(
                customer.getCustomerNumber(),
                customer.getCustomerName(),
                customer.getCustomerMobile(),
                customer.getCustomerEmail(),
                customer.getAddress1(),
                customer.getAddress2(),
                accounts,
                302,
                "Customer Account found"
        );
    }
}
