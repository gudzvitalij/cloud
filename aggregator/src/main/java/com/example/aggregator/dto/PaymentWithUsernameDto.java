package com.example.aggregator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PaymentWithUsernameDto {
    private long id;
    private long senderId;
    private long amount;
    private String comment;
    private String cardNumber;
    private String username;
}
