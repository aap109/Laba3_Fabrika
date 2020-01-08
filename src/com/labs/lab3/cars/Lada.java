package com.labs.lab3.cars;

class Lada extends Car {

    private CarLocParam carLocParam;

     Lada(Location geo) {

        switch (geo) {
            case Japan:
                carLocParam = new JapanLocParam();
                break;
            case Rus:
                carLocParam = new RussiaLocParam();
                break;
        }
    }

    @Override
    void makeCar() {
        carBrand = "Lada";
        carShopGEO = carLocParam.getCarShopGEO();
    }
}
