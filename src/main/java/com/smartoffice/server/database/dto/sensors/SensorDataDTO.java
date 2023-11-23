package com.smartoffice.server.database.dto.sensors;

import com.smartoffice.server.database.entity.sensors.SensorInfoData;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SensorDataDTO {
    private Long sensorDataId;
    private String sensorName;
    private SensorInfoData sensorInfo;
    private Double value;
    private LocalDateTime timestamp;
}
