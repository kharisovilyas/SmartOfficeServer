package com.smartoffice.server.database.entity.schedule;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Data
@Table(name = "EntryEvent")
public class EntryEventData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entry_id")
    Integer entryId;

    @Column(name = "schedule_id", unique = true)
    Integer scheduleId;

    @Column(name = "entry_time", unique = true)
    LocalDateTime entryTime;
}
