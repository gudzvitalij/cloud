package com.example.data;

import com.example.data.dto.ResponseDto;
import com.example.data.entity.Payment;
import com.example.data.repository.DataRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@SpringBootApplication
@Service
@RequiredArgsConstructor
public class DataApplication {
  private final Log logger = LogFactory.getLog(this.getClass());
  private final DataRepository dataRepository;

  @KafkaListener(groupId = "data", topics = "processPayment")
  public void listen(Payment message) {
    logger.info(message);
    dataRepository.save(message);
  }

  public static void main(String[] args) {
    SpringApplication.run(DataApplication.class, args);
  }

}
