package com.smartoffice.server.database.entity.schedule;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "Exit_Event")
public class ExitEventData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exit_id")
    @Getter
    @Setter
    Integer exitId;

    @Column(name = "schedule_id", unique = true)
    @Getter
    @Setter
    Integer scheduleId;

    @Column(name = "exit_time")
    @Getter
    @Setter
    LocalDateTime exitTime;
}
