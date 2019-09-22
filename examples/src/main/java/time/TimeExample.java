package time;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class TimeExample {

    public static void main(String[] args) {
        Clock clock = Clock.systemUTC();

        Instant instant = clock.instant();

//        Duration duration = Duration.between();

        LocalDate ld = LocalDate.now();
        System.out.println(ld);

        LocalTime lt = LocalTime.now();
        System.out.println(lt);

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        System.out.println(instant);

        System.out.println(ZoneId.systemDefault());

        ZoneId berlin = ZoneId.of("Europe/Berlin");
        ZoneId phoenix = ZoneId.of("America/Phoenix");
        ZoneId kiev = ZoneId.of("Europe/Kiev");

        System.out.println(berlin.getRules());

        LocalTime berlinNow = LocalTime.now(berlin);
        LocalTime kievNow = LocalTime.now(kiev);

        System.out.println(berlinNow.isBefore(kievNow));

        System.out.println(phoenix.getRules());
        System.out.println(kiev.getRules());

        System.out.println(ChronoUnit.MINUTES.between(kievNow, berlinNow));

        System.out.println(ldt.getHour());

        System.out.println(ldt.getDayOfWeek());

        Date now = new Date();

        now.setTime(10);
        System.out.println(now);

        Duration duration = Duration.ofMinutes(20);
        Duration duration1 = Duration.ofHours(15);

        Duration plus = duration1.plus(duration);

        System.out.println(Duration.ofHours(500).get(ChronoUnit.SECONDS));

        Instant instant1 = Instant.ofEpochMilli(System.currentTimeMillis());


    }

}
