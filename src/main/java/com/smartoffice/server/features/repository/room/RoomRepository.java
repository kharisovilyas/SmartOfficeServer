package com.smartoffice.server.features.repository.room;

import com.smartoffice.server.database.entity.rooms.RoomData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<RoomData, Long> {
}
