package org.tally.farm.point.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.tally.farm.point.domain.PointStatus;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PointDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_detail_id")
    private Long id;

    private Long pointEventId;

    private int amount;

    private PointStatus status;

    private LocalDateTime expireDt;

}
