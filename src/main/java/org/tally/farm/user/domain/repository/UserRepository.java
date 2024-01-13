package org.tally.farm.user.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tally.farm.user.domain.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
