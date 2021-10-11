package com.example.aggregator.client;

import com.example.aggregator.dto.PaymentDto;
import com.example.aggregator.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "data")
public interface DataClient {
  @GetMapping
  ResponseDto getValue();

  @GetMapping("/payments/{paymentNumbers}")
  List<PaymentDto> getList(@PathVariable int paymentNumbers);
}
