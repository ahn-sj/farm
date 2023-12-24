package org.tally.farm.point.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.tally.farm.global.BaseEntity;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PointChargeType extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_charge_type_id")
    private Long id;

    @Column(name = "charge_type_name", nullable = false)
    private String name;

    private String description;

    private int amount;

    private Long createdBy;

    public int getBalanceAfterSumChargeAmount(final int currnetPoint) {
        return amount += currnetPoint;
    }

}
