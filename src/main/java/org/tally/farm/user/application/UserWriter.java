package org.tally.farm.user.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.tally.farm.user.domain.entity.User;
import org.tally.farm.user.domain.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class UserWriter {

    private final UserRepository userRepository;

    @Transactional
    public User save(final User user) {
        return userRepository.save(user);
    }
}
