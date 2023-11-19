package com.smartoffice.server.database.entity.sensors;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Sensor_Type")
public class SensorTypeData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensor_type_id")
    @Getter
    @Setter
    private Long sensorTypeId;

    @Column(name = "type_name")
    @Getter
    @Setter
    private String typeName;
}
