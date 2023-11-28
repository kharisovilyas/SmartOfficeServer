package com.smartoffice.server.features.repository.controls;

import com.smartoffice.server.database.entity.control.DoorControlData;
import com.smartoffice.server.database.entity.control.HVACControlData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HVACControlRepository extends CrudRepository<HVACControlData, Long> {
    HVACControlData findByControlId(Long controlId);

    HVACControlData findByControlName(String controlName);
}
