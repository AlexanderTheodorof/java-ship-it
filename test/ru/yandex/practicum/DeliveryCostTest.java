package ru.yandex.practicum;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandardParcel;

import java.util.Random;


public class DeliveryCostTest {
    StandardParcel   standardParcell;
    FragileParcel    fragileParcel;
    PerishableParcel perishableParcel;
    static Random random;

    @BeforeAll
    public static void preparation() {
        random = new Random();
    }

    @Test
    public void correctnesOfCalculateDeliveryCostStandardParcel() {
        int weight  = random.nextInt(1,15);
        int sendDay = random.nextInt(1,30);
        int standardParcelDeliveryCost = 2;
        standardParcell = new StandardParcel("Книга",
                                          "улица Пушкина, дом Колотушкина",
                                                        weight,
                                                        sendDay);
        Assertions.assertEquals(standardParcell.calculateDeliveryCost(), weight * standardParcelDeliveryCost);
    }

    @Test
    public void correctnesOfCalculateDeliveryCostFragileParcel() {
        int weight  = random.nextInt(1,15);
        int sendDay = random.nextInt(1,30);
        int fragileParcelDeliveryCost = 4;

        fragileParcel = new FragileParcel("Хрустальная ваза",
                                       "улица Пушкина, дом Колотушкина",
                                                    weight,
                                                    sendDay);
        Assertions.assertEquals(fragileParcel.calculateDeliveryCost(), weight * fragileParcelDeliveryCost);
    }

    @Test
    public void correctnesOfCalculateDeliveryCostPerishableParcel() {
        int weight     = random.nextInt(1,15);
        int sendDay    = random.nextInt(1,30);
        int timeToLive = random.nextInt(1,30);
        int perishableParcelDeliveryCost = 3;

        perishableParcel = new PerishableParcel("Хрустальная ваза",
                                             "улица Пушкина, дом Колотушкина",
                                                           weight,
                                                           sendDay,
                                                           timeToLive);
        Assertions.assertEquals(perishableParcel.calculateDeliveryCost(),weight * perishableParcelDeliveryCost);
    }
}
