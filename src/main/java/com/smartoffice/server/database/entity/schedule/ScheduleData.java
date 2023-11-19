package com.smartoffice.server.database.entity.schedule;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Schedule")
public class ScheduleData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    @Getter
    @Setter
    private Integer scheduleId;

    @Column(name = "user_id")
    @Getter
    @Setter
    private Integer userId;

    @Column(name = "rental_id")
    @Getter
    @Setter
    private Integer rentalId;
}
