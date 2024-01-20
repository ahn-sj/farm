package org.tally.farm.user.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tally.farm.global.exception.ErrorCode;
import org.tally.farm.user.application.validator.UserValidator;
import org.tally.farm.user.dto.UserRequest;

import static org.tally.farm.user.exception.UserException.UserEmailAndProviderIsExistsException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserWriter userWriter;
    private final UserReader userReader;
    private final UserValidator userValidator;

    public void join(final UserRequest.JoinUserRequest request) {

        if(userValidator.existsUserByEmailAndProviderId(request.email(), request.providerId())) {
            throw new UserEmailAndProviderIsExistsException(ErrorCode.USER_EMAIL_EXISTED, request.email(), request.providerId());
        }







    }
}
