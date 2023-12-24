package org.tally.farm.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;

public final class DateUtils {

    private DateUtils() {}

    public static LocalDateTime getPointExpireDt(final LocalDate now) {
        return now.plusYears(1).plusMonths(1).withDayOfMonth(1).atStartOfDay();
    }
}
