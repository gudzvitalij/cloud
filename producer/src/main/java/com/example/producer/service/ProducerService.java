package com.example.producer.service;

import com.example.producer.data.Payment;
import com.example.producer.dto.PaymentDto;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.lang.NonNull;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@RequiredArgsConstructor
public class ProducerService {
  private final Log logger = LogFactory.getLog(this.getClass());
  private final KafkaTemplate<String, Payment> template;


  public void send(PaymentDto payment) {
    final ListenableFuture<SendResult<String, Payment>> future = template.send(
        new ProducerRecord<>("payments", "ibank", new Payment(
                System.currentTimeMillis(),
                payment.getId(),
                payment.getAmount(),
                payment.getComment(),
                payment.getCardNumber()
        )));
    future.addCallback(new ListenableFutureCallback<>() {
      @Override
      public void onFailure(@NonNull Throwable e) {
        e.printStackTrace();
      }

      @Override
      public void onSuccess(SendResult<String, Payment> result) {
        logger.info(result);
      }
    });
  }
}
