package org.tally.farm.user.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.tally.farm.user.application.UserService;
import org.tally.farm.user.dto.UserRequest;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/v1/users")
    public void joinUser(@RequestBody final UserRequest.JoinUserRequest request) {

        userService.join(request);




    }
}
