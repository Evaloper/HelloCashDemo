package com.evaloper.HelloCashDemo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SMSResponse {
    private String phoneNumber;
    private String message;
}
