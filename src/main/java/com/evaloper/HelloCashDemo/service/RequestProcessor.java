package com.evaloper.HelloCashDemo.service;


import com.evaloper.HelloCashDemo.model.SMSRequest;
import com.evaloper.HelloCashDemo.model.UserEntity;
import com.evaloper.HelloCashDemo.repository.UserRepository;
import com.evaloper.HelloCashDemo.service.BankIntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestProcessor {

    private final BankIntegrationService bankIntegrationService;
    private final UserRepository userRepository;

    @Autowired
    public RequestProcessor(BankIntegrationService bankIntegrationService, UserRepository userRepository) {
        this.bankIntegrationService = bankIntegrationService;
        this.userRepository = userRepository;
    }

    public String processRequest(String message) {
        String[] parts = message.split(":");
        if (parts.length < 2) {
            return "Invalid request format. Use: PHONE_NUMBER:COMMAND";
        }

        String phoneNumber = parts[0];
        String command = parts[1].toUpperCase();

        switch (command) {
            case "ACTIVATE":
                if (bankIntegrationService.validatePhoneNumberWithBank(phoneNumber)) {
                    // Mock input for PIN; in real scenario, you would handle this securely
                    int pin = 1234;  // For simplicity, setting a static PIN; replace with real input
                    UserEntity user = new UserEntity();
                    user.setPhoneNumber(phoneNumber);
                    user.setPin(pin);
                    userRepository.save(user);
                    return "User activated. Use menu: 1. Transfer 2. Check balance 3. Buy airtime";
                } else {
                    return "Phone number not registered with bank.";
                }
//            case "BAL":
//                UserEntity user = userRepository.findByPhoneNumber(phoneNumber);
//                if (user != null) {
//                    return "Balance: " + bankIntegrationService.checkBalance(phoneNumber);
//                } else {
//                    return "User not activated.";
//                }
            default:
                return "Unknown command. Use: ACTIVATE, BAL";
        }
    }
}
