package com.smartoffice.server.database.entity.control;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "Lighting_Control")
public class LightingControlData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "control_id")
    @Getter
    @Setter
    private Integer controlId;

    @Column(name = "brightness")
    @Getter
    @Setter
    private Integer brightness;

    @Column(name = "color_temperature")
    @Getter
    @Setter
    private Integer colorTemperature;

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
