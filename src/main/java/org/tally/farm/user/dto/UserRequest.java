package org.tally.farm.user.dto;

import java.time.LocalDate;

public class UserRequest {

    public record JoinUserRequest(
            String email,
            String password,
            String name,
            String nickname,
            String phoneNumber,
            LocalDate birthday,
            String address1,
            String address2) {}

}
