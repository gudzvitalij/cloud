package com.example.data.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Table(name = "payments")
public class Payment implements Payload{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private long senderId;
    @Column(nullable = false)
    private long amount;
    @Column(nullable = false)
    private String comment;
    @Column(nullable = false)
    private String cardNumber;
}
