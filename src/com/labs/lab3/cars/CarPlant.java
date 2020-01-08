package com.labs.lab3.cars;

public abstract class CarPlant {

    public Car orderCar(CarTypes type) {

        Car car = createCar(type);
        car.makeCar();

        return car;
    }

    protected abstract Car createCar(CarTypes type);
}
