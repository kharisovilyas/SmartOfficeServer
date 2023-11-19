package com.smartoffice.server.database.entity.users;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "EntryEvent")
public class EntryEventData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entry_id")
    @Getter
    @Setter
    Integer entryId;

    @Column(name = "schedule_id", unique = true)
    @Getter
    @Setter
    Integer scheduleId;

    //добавить userId
    //добавить doorId

    @Column(name = "entry_time", unique = true)
    @Getter
    @Setter
    LocalDateTime entryTime;
}
