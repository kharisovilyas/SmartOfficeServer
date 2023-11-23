package com.smartoffice.server.features.repository.controls;

import com.smartoffice.server.database.entity.control.DoorControlData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoorControlRepository extends CrudRepository<DoorControlData, Long> {

    DoorControlData findByControlId(Long controlId);
}
