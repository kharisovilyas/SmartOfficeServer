package com.smartoffice.server.features.repository.controls;

import com.smartoffice.server.database.entity.control.DoorControlData;
import com.smartoffice.server.database.entity.control.LightingControlData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LightningControlRepository extends CrudRepository<LightingControlData, Long> {

}
