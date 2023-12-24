package org.tally.farm.point.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.tally.farm.point.domain.PointStatus;

import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PointDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_detail_id")
    private Long id;

    private Long pointEventId;

    private int amount;

    @Enumerated(EnumType.STRING)
    private PointStatus status;

    private LocalDateTime expireDt;

}
