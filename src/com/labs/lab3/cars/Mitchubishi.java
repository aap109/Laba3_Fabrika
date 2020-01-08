package com.labs.lab3.cars;

class Mitchubishi extends Car {

    private CarLocParam CarLocParam;

    Mitchubishi(Location geo) {

        switch (geo) {
            case Japan:
                CarLocParam = new JapanLocParam();
                break;
            case Rus:
                CarLocParam = new RussiaLocParam();
                break;
        }
    }

    @Override
    void makeCar() {
        carBrand = "Mitchubishi";
        carShopGEO = CarLocParam.getCarShopGEO();
    }
}
