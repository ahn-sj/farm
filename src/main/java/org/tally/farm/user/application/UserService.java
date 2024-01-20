package org.tally.farm.user.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tally.farm.global.exception.BusinessException;
import org.tally.farm.global.exception.ErrorCode;
import org.tally.farm.user.application.validator.UserValidator;
import org.tally.farm.user.domain.ProviderId;
import org.tally.farm.user.domain.entity.User;
import org.tally.farm.user.domain.model.UserCommand;
import org.tally.farm.user.domain.model.UserMapper;
import org.tally.farm.user.dto.UserRequest;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserWriter userWriter;
    private final UserReader userReader;
    private final UserValidator userValidator;

    private final UserMapper userMapper;

    public void join(final UserRequest.JoinUserRequest request) {
        final ProviderId providerId = ProviderId.find(request.providerId());

        if(userValidator.existsUserByEmailAndProviderId(request.email(), providerId)) {
            throw new BusinessException(ErrorCode.USER_EXISTED);
        }

        final UserCommand userCommand = userMapper.toUserCommand(request);
        final User user = new User(userCommand);

        userWriter.save(user);
    }
}
