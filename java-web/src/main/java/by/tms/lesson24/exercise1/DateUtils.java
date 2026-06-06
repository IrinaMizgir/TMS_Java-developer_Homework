package by.tms.lesson24.exercise1;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Ирина Мизгир
 * @date 06.06.2026 14:58
 */
public final class DateUtils {
    private DateUtils() {
    }

    public static String getDateStringByTimeZoneString(String zoneIdString) {
        return ZonedDateTime.now(ZoneId.of(zoneIdString))
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
    }

}
