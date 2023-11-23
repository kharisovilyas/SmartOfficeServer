package com.smartoffice.server.features.repository.sensor;

import com.smartoffice.server.database.entity.sensors.SensorTypeData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SensorTypeRepository extends CrudRepository<SensorTypeData, Long> {
    SensorTypeData findByTypeName(String typeName);
}
