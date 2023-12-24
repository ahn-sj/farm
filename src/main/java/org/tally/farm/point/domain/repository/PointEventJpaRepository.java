package org.tally.farm.point.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.tally.farm.point.domain.entity.PointEvent;

@Repository
public interface PointEventJpaRepository extends JpaRepository<PointEvent, Long> {

    @Query("SELECT sum(pe.amount) " +
            "FROM PointEvent pe " +
            "WHERE pe.userId = :userId " +
            "GROUP BY pe.userId")
    Long findCurrentPoint(@Param("userId") Long userId);
}
