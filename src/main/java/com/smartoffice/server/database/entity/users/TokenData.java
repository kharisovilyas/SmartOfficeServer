package com.smartoffice.server.database.entity.users;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Token")
public class TokenData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "token_id")
    @Getter
    @Setter
    private Long tokenId;

    @Column(name = "user_id")
    @Getter
    @Setter
    private Long userId;

    @Column(name = "token_value", unique = true)
    @Getter
    @Setter
    private String tokenValue;

    @Column(name = "expiration_time")
    @Getter
    @Setter
    private LocalDateTime expirationTime;
}