package com.smartoffice.server.database.entity.sensors;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "Sensor_Data")
@Data
public class SensorData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensor_data_id")
    private Long sensorDataId;

    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private SensorInfoData sensorInfo;

    @Column(name = "value")
    private Double value;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;
}

