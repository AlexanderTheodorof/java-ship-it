package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel {

    public StandardParcel(String description,
                          String deliveryAddress,
                          int weight,
                          int sendDay) {
        super(description, deliveryAddress, weight, sendDay);
        super.type = "Стандартная посылка";
    }

    @Override
    public int getDeliveryCost() {
        return super.getDeliveryCost() + 1; 
    }
}
