package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ru.yandex.practicum.delivery.PerishableParcel;


import java.util.Random;

public class PerishableParcelTimeToLiveTest {
    PerishableParcel perishableParcel;

    static Random random;

    @BeforeAll
    public static void preparation() {
        random = new Random();
    }

    @Test
    public void perishableParcelIsExpiredTrue() {
        int weight     = random.nextInt(1,15);
        int sendDay    = random.nextInt(1,30);
        int currentDay = random.nextInt(sendDay,30 + sendDay);
        int timeToLive = currentDay + sendDay + random.nextInt(1,30);

        perishableParcel = new PerishableParcel("Камчатский краб",
                                             "Улица Пушкина, дом Колотушкина",
                                                           weight, sendDay,timeToLive);
        Assertions.assertTrue(perishableParcel.isExpired(currentDay),"За это время посылка не испортится");
    }

    @Test
    public void perishableParcelIsExpiredFalse() {
        int weight     = random.nextInt(1,15);
        int sendDay    = random.nextInt(1,30);
        int currentDay = random.nextInt(1,30) + sendDay;
        int timeToLive = random.nextInt(sendDay, currentDay) - 1;
        perishableParcel = new PerishableParcel("Камчатский краб",
                "Улица Пушкина, дом Колотушкина",
                weight, sendDay,timeToLive);
        Assertions.assertFalse(perishableParcel.isExpired(currentDay));
    }
}
