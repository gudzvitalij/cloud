package com.example.producer.controller;

import com.example.producer.dto.PaymentDto;
import com.example.producer.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Validated
@RequiredArgsConstructor
public class ProducerController {
    private final ProducerService producerService;

    @PostMapping("/payments")
    public void payment(@RequestBody PaymentDto payment){
        producerService.send(payment);
    }
}
