package org.tally.farm.user.domain.model;

import java.time.LocalDate;

public record UserCommand(
        String email,
        String password,
        String name,
        String nickname,
        String providerId,
        String phoneNumber,
        LocalDate birthday,
        String address1,
        String address2) {
}
