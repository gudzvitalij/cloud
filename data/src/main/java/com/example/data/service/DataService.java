package com.example.data.service;

import com.example.data.dto.ResponseDto;
import com.example.data.entity.Payment;
import com.example.data.repository.DataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DataService {
    private final DataRepository dataRepository;

    public List<Payment> getPaymentsList(int paymentNumbers){
        return dataRepository.getPaymentsList(paymentNumbers);
    }

}
