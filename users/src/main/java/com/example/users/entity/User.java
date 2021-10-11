package com.example.users.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Table(name = "users")
public class User {
    @Id
    @Column(nullable = false)
    private long id;
    @Column(nullable = false)
    private String username;
}
