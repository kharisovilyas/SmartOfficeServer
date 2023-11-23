package com.smartoffice.server.features.repository.sensor;

import com.smartoffice.server.database.entity.company.CompanyData;
import com.smartoffice.server.database.entity.sensors.SensorData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends CrudRepository<SensorData, Long> {
    List<SensorData> findBySensorInfo_SensorId(Long sensorId);

    List<SensorData> findBySensorInfo_SensorName(String sensorName);
}
