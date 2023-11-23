package com.smartoffice.server.features.repository.sensor;

import com.smartoffice.server.database.entity.company.CompanyData;
import com.smartoffice.server.database.entity.sensors.SensorData;
import com.smartoffice.server.database.entity.sensors.SensorInfoData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorInfoRepository extends CrudRepository<SensorInfoData, Long> {
    SensorInfoData findBySensorName(String sensorName);
}
