package com.example.producer.dto;

import com.example.producer.validation.CardNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentDto {
    private long id;
    @Min(100)
    private long amount;
    private String comment;
    @CardNumber
    private String cardNumber;
}
