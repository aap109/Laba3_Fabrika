package com.labs.lab3.cars;

class Toyota extends Car {

    private CarLocParam carLocParam;

    Toyota(Location geo) {

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
        carBrand = "Toyota";
        carShopGEO = carLocParam.getCarShopGEO();
    }
}
