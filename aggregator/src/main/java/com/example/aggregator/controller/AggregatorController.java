package com.example.aggregator.controller;

import com.example.aggregator.dto.PaymentWithUsernameDto;
import com.example.aggregator.dto.ResponseDto;
import com.example.aggregator.dto.UserDto;
import com.example.aggregator.service.AggregatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api")
@EnableFeignClients
@RequiredArgsConstructor
public class AggregatorController {
    private final DiscoveryClient discoveryClient;
    private final AggregatorService aggregatorService;
    private final int PAYMENT_COUNT = 100;

    @GetMapping("/value")
    public ResponseDto value() {
        return aggregatorService.getValue();
    }

    @GetMapping("/payments")
    public List<PaymentWithUsernameDto> stats() {
        return aggregatorService.getStatistics(PAYMENT_COUNT);
    }

    @GetMapping("/users")
    public List<UserDto> users() {
        return aggregatorService.getUsers();
    }

}
