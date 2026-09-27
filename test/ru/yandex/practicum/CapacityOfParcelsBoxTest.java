package ru.yandex.practicum;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ru.yandex.practicum.delivery.*;

import java.util.Random;

public class CapacityOfParcelsBoxTest {

    ParcelBox<StandardParcel>   standardParcelBox;
    ParcelBox<FragileParcel>    fragileParcelParcelBox;
    ParcelBox<PerishableParcel> perishableParcelBox;
    ParcelBox<Parcel> parcelBox;
    StandardParcel   standardParcel;
    PerishableParcel perishableParcel;
    FragileParcel    fragileParcel;
    static Random random;

    @BeforeAll
    public static void preparation() {
        random = new Random();

    }
    @AfterEach
    public void parcelBoxPreparation() {

        fragileParcelParcelBox = new ParcelBox<>(random.nextInt(10,50));
        perishableParcelBox    = new ParcelBox<>(random.nextInt(10,50));
    }

    @Test
    public void exceedingMaximumWeightParcelBox() {
        int weight  = random.nextInt(1,9);
        int sendDay = random.nextInt(1,30);
        int sumWeight = 0;

        parcelBox = new ParcelBox<>(random.nextInt(10,50));
        standardParcel    = new StandardParcel("Книга",
                                         "улица Пушкина, дом Колотушкина",
                                                       weight,
                                                       sendDay);
        while(sumWeight < parcelBox.getMaxWeight()) {
            sumWeight += weight;
            parcelBox.addParcel(standardParcel);
        }

        int capacityOfStandardParcelBox = parcelBox.getNumberOfParcels();

        for (int i = 0; i < 3; i++) {
            parcelBox.addParcel(standardParcel);
        }

        Assertions.assertEquals(parcelBox.getNumberOfParcels(),capacityOfStandardParcelBox);

    }

    @Test
    public void addParcelInUnfilledParcelBox() {
        int weight  = random.nextInt(1,3);
        int sendDay = random.nextInt(1,30);
        parcelBox = new ParcelBox<>(random.nextInt(10,50));
        standardParcel    = new StandardParcel("Книга",
                "улица Пушкина, дом Колотушкина",
                weight,
                sendDay);
        int numberOfParcelsThenLessMaxWeight = parcelBox.getNumberOfParcels();

        for (int i = 0; i < 3; i++) {
            parcelBox.addParcel(standardParcel);
        }

        Assertions.assertEquals(parcelBox.getNumberOfParcels(),numberOfParcelsThenLessMaxWeight + 3);

    }
}
