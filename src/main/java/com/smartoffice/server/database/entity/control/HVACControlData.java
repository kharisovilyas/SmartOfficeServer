package com.smartoffice.server.database.entity.control;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "HVAC_Control")
public class HVACControlData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "control_id")
    @Getter
    @Setter
    private Integer controlId;

    @Column(name = "temperature")
    @Getter
    @Setter
    private Double temperature;

    @Column(name = "humidity")
    @Getter
    @Setter
    private Double humidity;

    @Column(name = "control_time")
    @Getter
    @Setter
    private LocalDateTime controlTime;

    @Column(name = "room_id")
    @Getter
    @Setter
    private Integer roomId;

    @Column(name = "rental_id")
    @Getter
    @Setter
    private Integer rentalId;
}
