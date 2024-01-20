package org.tally.farm.user.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.tally.farm.user.domain.ProviderId;
import org.tally.farm.user.domain.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT COUNT(u.id) > 0 FROM User u WHERE u.email = :email AND u.providerId = :#{#providerId.name()}")
    boolean existsUserByEmailAndProviderId(@Param("email") String email, @Param("providerId") ProviderId providerId);

}
