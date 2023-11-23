package com.smartoffice.server.database.entity.sensors;

import javax.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "Sensor_Type")
public class SensorTypeData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensor_type_id")
    private Long sensorTypeId;

    @OneToMany(mappedBy = "sensorType", cascade = CascadeType.ALL)
    private List<SensorInfoData> sensorInfoList;

    @Column(name = "type_name")
    private String typeName;
}