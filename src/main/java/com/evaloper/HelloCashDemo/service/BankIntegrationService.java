package com.evaloper.HelloCashDemo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BankIntegrationService {
    private final RestTemplate restTemplate;

    public BankIntegrationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean validatePhoneNumberWithBank(String phoneNumber) {
        // Mock implementation - replace with actual API call
        String url = "http://localhost:8080/api/v1/user/check-phone?phoneNumber=" + phoneNumber;
        try {
            String response = restTemplate.getForObject(url, String.class);
            System.out.println("Bank API response: " + response); // Print the response for debugging
            // Parse the response if needed. Assuming the API returns a simple boolean in plain text for now.
            return Boolean.parseBoolean(response.trim());
        } catch (Exception e) {
            System.err.println("Error validating phone number with bank: " + e.getMessage());
            return false;
        }
    }

//    public String checkBalance(String phoneNumber) {
//        // Mock implementation - replace with actual API call
//        String url = "http://localhost:8080/api/v1/user/check-balance?phoneNumber=" + phoneNumber;
//        try {
//            String response = restTemplate.getForObject(url, String.class);
//            System.out.println("Bank API response: " + response); // Print the response for debugging
//            return response.trim();
//        } catch (Exception e) {
//            System.err.println("Error checking balance with bank: " + e.getMessage());
//            return "Error checking balance";
//        }
//    }
//
//    public void transferFunds(String phoneNumber, String accountNumber) {
//        // Mock implementation - replace with actual API call
//        String url = "http://localhost:8080/api/v1/user/transfer-funds?phoneNumber=" + phoneNumber + "&accountNumber=" + accountNumber;
//        try {
//            restTemplate.postForObject(url, null, String.class);
//            System.out.println("Funds transferred successfully.");
//        } catch (Exception e) {
//            System.err.println("Error transferring funds: " + e.getMessage());
//        }
//    }
//
//    public void buyAirtime(String phoneNumber, String amount) {
//        // Mock implementation - replace with actual API call
//        String url = "http://localhost:8080/api/v1/user/buy-airtime?phoneNumber=" + phoneNumber + "&amount=" + amount;
//        try {
//            restTemplate.postForObject(url, null, String.class);
//            System.out.println("Airtime purchased successfully.");
//        } catch (Exception e) {
//            System.err.println("Error buying airtime: " + e.getMessage());
//        }
//    }
}
