package com.smartoffice.server.features.repository.sensor;

import com.smartoffice.server.database.entity.control.LightingControlData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LightingControlRepository extends CrudRepository<LightingControlData, Long> {
    LightingControlData findByControlId(Long controlId);
}
