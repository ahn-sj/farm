package org.tally.farm.point.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tally.farm.point.domain.entity.PointChargeType;

@Repository
public interface PointChargeTypeJpaRepository extends JpaRepository<PointChargeType, Long> {
}
