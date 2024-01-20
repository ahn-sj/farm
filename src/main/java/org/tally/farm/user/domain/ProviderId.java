package org.tally.farm.user.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.tally.farm.global.exception.BusinessException;
import org.tally.farm.global.exception.ErrorCode;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum ProviderId {

    EMAIL("email"),
    GOOGLE("google"),
    KAKAO("kakao")
    ;

    private final String key;

    public static ProviderId find(final String providerId) {
        return Arrays.stream(values())
                .filter(id -> id.getKey().equalsIgnoreCase(providerId))
                .findFirst()
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));
    }

}
