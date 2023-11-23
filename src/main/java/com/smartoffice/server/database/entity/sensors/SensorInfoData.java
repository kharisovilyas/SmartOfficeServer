package com.smartoffice.server.database.entity.sensors;

import com.smartoffice.server.database.entity.rooms.RoomData;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Sensor_Info")
public class SensorInfoData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensor_id")
    private Long sensorId;

    @Column(name = "sensor_name")
    private String sensorName;

    @ManyToOne
    @JoinColumn(name = "sensor_type_id")
    private SensorTypeData sensorType;

    @OneToOne
    @JoinColumn(name = "room_id")
    private RoomData roomData;

    @OneToMany(mappedBy = "sensorInfo", cascade = CascadeType.ALL)
    private List<SensorData> sensorDataList;

    @Column(name = "location")
    private String location;

    @Column(name = "description")
    private Double description;

    @Column(name = "status")
    private Boolean status;
}
