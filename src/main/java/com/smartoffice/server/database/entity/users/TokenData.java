package com.smartoffice.server.database.entity.users;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "Token")
public class TokenData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "token_id")
    private Long tokenId;

    @Column(name = "user_id", unique = true)
    private Long userId;

    @Column(name = "token_value", unique = true)
    private String tokenValue;

    @Column(name = "expiration_time")
    private Date expirationTime;
}