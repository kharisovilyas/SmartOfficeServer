package com.smartoffice.server.features.repository;

import com.smartoffice.server.database.entity.rooms.RoomData;
import com.smartoffice.server.database.entity.sensors.SensorTypeData;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<RoomData, Long> {
    RoomData findByRoomName(String roomName);
}
