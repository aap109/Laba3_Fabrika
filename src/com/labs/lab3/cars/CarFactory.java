package com.labs.lab3.cars;

class CarFactory {

    Car createCar(CarTypes type, Location geo) {

        Car car = null;

        switch (type) {
            case Lada:
                car = new Lada(geo);
                break;
            case Mitchubishi:
                car = new Mitchubishi(geo);
                break;
            case Toyota:
                car = new Toyota(geo);
                break;
        }

        return car;
    }
}
