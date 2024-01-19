package org.tally.farm.user.application.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.tally.farm.global.exception.ErrorCode;
import org.tally.farm.user.domain.entity.User;
import org.tally.farm.user.domain.repository.UserRepository;
import org.tally.farm.user.exception.UserException;

@Component
@RequiredArgsConstructor
public class UserValidator {

    private final UserRepository userRepository;

    public void validateNotExisted(final Long userId) {
        final User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserException.UserNotFoundException(ErrorCode.USER_NOT_FOUND, userId));

    }

}
