package org.tally.farm.user.application.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.tally.farm.global.exception.ErrorCode;
import org.tally.farm.user.domain.repository.UserRepository;

import static org.tally.farm.user.exception.UserException.UserNotFoundException;

@Component
@RequiredArgsConstructor
public class UserValidator {

    private final UserRepository userRepository;

    public void validateNotExisted(final Long userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND, userId));
    }

    public boolean existsUserByEmailAndProviderId(final String email, final String providerId) {
        return userRepository.existsUserByEmailAndProviderId(email, providerId);
    }
}
