package com.smartoffice.server.database.entity.qr;
import com.smartoffice.server.database.entity.control.DoorControlData;
import com.smartoffice.server.database.entity.rooms.RoomData;
import com.smartoffice.server.database.entity.users.UserData;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "QR_Access")
@Data
public class QRAccessData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "access_id")
    private Long accessId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserData user;

    @ManyToMany
    @JoinTable(
            name = "door_qr_access",
            joinColumns = @JoinColumn(name = "access_id"),
            inverseJoinColumns = @JoinColumn(name = "door_id")
    )
    private List<DoorControlData> doors = new ArrayList<>();

    @Column(name = "qr_code", unique = true)
    private String qrCode;

    @Column(name = "access_status")
    private String accessStatus;

    @Column(name = "expiration_time")
    private LocalDateTime expirationTime;

}
