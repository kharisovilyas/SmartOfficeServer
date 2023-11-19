package com.smartoffice.server.database.entity.sensors;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "Sensor_Data")

public class SensorData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensor_data_id")
    @Getter
    @Setter
    private Long sensorDataId;

    @Column(name = "sensor_id")
    @Getter
    @Setter
    private Long sensorId;

    @Column(name = "value")
    @Getter
    @Setter
    private Double value;

    @Column(name = "timestamp")
    @Getter
    @Setter
    private LocalDateTime timestamp;
}

