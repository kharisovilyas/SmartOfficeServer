package com.smartoffice.server.database.entity.users;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Rental")
public class RentalData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    @Getter
    @Setter
    private Integer rentalId;

    @Column(name = "start_date")
    @Getter
    @Setter
    private LocalDateTime startDate;

    @Column(name = "end_date")
    @Getter
    @Setter
    private LocalDateTime endDate;
}
