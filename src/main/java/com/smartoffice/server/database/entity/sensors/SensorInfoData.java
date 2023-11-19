package com.smartoffice.server.database.entity.sensors;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Sensor_Info")
public class SensorInfoData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensor_id")
    @Getter
    @Setter
    private Long sensorId;

    @Column(name = "sensor_type_id")
    @Getter
    @Setter
    private Long sensorTypeId;

    @Column(name = "location")
    @Getter
    @Setter
    private String location;

    @Column(name = "description")
    @Getter
    @Setter
    private Double description;

    @Column(name = "status")
    @Getter
    @Setter
    private Boolean status;

    @Column(name = "room_id")
    @Getter
    @Setter
    private Long roomId;
}
