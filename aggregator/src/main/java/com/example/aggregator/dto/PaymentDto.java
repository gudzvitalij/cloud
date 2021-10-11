package com.example.aggregator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentDto {
    private long id;
    private long senderId;
    private long amount;
    private String comment;
    private String cardNumber;
}
