package com.labs.lab3.cars;

public class RusCarPlant extends CarPlant {

    @Override
    protected Car createCar(CarTypes type) {

        CarFactory carFactory = new CarFactory();
        return carFactory.createCar(type, Location.Rus);
    }
}
