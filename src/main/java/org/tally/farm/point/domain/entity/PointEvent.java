package org.tally.farm.point.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.tally.farm.global.BaseEntity;
import org.tally.farm.point.domain.PointStatus;

import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PointEvent extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_event_id")
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Enumerated(EnumType.STRING)
    private PointStatus status;

    private int amount;

    private int balance;

    private LocalDateTime expireDt;

}
