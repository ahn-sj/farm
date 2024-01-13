package org.tally.farm.user.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tally.farm.user.domain.repository.UserRepository;
import org.tally.farm.user.dto.UserRequest;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void join(final UserRequest.JoinUserRequest request) {

    }
}
