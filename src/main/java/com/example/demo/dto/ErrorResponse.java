package com.example.demo.dto;

public class ErrorResponse {
    private int transactionStatusCode;
    private String transactionStatusDescription;

    public ErrorResponse(int transactionStatusCode, String transactionStatusDescription) {
        this.transactionStatusCode = transactionStatusCode;
        this.transactionStatusDescription = transactionStatusDescription;
    }

    public int getTransactionStatusCode() { return transactionStatusCode; }
    public String getTransactionStatusDescription() { return transactionStatusDescription; }
}
