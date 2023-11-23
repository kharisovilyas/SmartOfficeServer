package com.smartoffice.server.database.dto.sensors;

import lombok.Data;

@Data
public class SensorInfoDTO {
    private Long sensorId;
    private String sensorName;
    private String typeName;
    private String location;
    private Double description;
    private Boolean status;
    private String roomName;
}
