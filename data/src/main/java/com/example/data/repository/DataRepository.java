package com.example.data.repository;

import com.example.data.entity.Payment;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class DataRepository {
    @PersistenceContext
    private Session session;

    public void save(Payment payment) {
        session.save(payment);
    }

    public List<Payment> getPaymentsList(int paymentNumbers) {
        return session.createQuery("select p FROM Payment p ORDER BY p.id DESC", Payment.class)
                .setMaxResults(paymentNumbers)
                .getResultList();
    }
}
