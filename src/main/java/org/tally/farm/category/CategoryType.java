package org.tally.farm.category;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CategoryType {

    FRUIT("과일")
    ;

    private final String description;
}
