package org.tally.farm.user.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.tally.farm.global.response.ApplicationResponse;
import org.tally.farm.user.application.UserService;
import org.tally.farm.user.dto.UserRequest;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/v1/users")
    public ApplicationResponse<Void> joinUser(@RequestBody final UserRequest.JoinUserRequest request) {
        userService.join(request);
        return ApplicationResponse.created().build();
    }

    @GetMapping("/v1/users/{userId}")
    public ApplicationResponse<Void> getDetailedUser(@PathVariable final Long userId) {
        userService.getDetailedUser(userId);
        return ApplicationResponse.created().build();
    }
}
