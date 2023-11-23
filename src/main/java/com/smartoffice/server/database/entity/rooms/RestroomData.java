package com.smartoffice.server.database.entity.rooms;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "Restroom")
public class RestroomData {
    @Id
    @Column(name = "restroom_id")
    private Long restroomId;

    @Column(name = "restroom_name")
    private String restroomName;

    @Column(name = "gender_type")
    private String genderType;

    @Column(name = "room_id")
    private Long roomId;
}