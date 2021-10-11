package com.example.aggregator.service;

import com.example.aggregator.client.DataClient;
import com.example.aggregator.client.UserClient;
import com.example.aggregator.dto.PaymentWithUsernameDto;
import com.example.aggregator.dto.ResponseDto;
import com.example.aggregator.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AggregatorService {
    private final DataClient dataClient;
    private final UserClient userClient;

    public List<PaymentWithUsernameDto> getStatistics(int paymentNumbers) {
        final var payments = dataClient.getList(paymentNumbers);
        ArrayList<Long> usersIdList = new ArrayList<>();
        payments.forEach(p -> usersIdList.add(p.getSenderId()));
        final var userDtoList = userClient.getUsersById(usersIdList);
        return payments.stream().map(o ->
                new PaymentWithUsernameDto(o.getId(), o.getSenderId(), o.getAmount(),o.getComment(),o.getCardNumber(),
                        userDtoList.get((int) o.getId()).getUsername()
                        ))
                .collect(Collectors.toList());
    }

    public List<UserDto> getUsers() {
        return userClient.getUsers();
    }

    public ResponseDto getValue() {
        return dataClient.getValue();
    }
}
