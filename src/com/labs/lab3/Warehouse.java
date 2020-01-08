package com.labs.lab3;

import java.util.concurrent.atomic.AtomicInteger;

class Warehouse {

    private static Warehouse warehouseInstance;

    private AtomicInteger numCars;

    private static final int MAX_CARS = 10;

    private Warehouse() {
        numCars = new AtomicInteger();
        numCars.set(0);
    }

    static Warehouse getWarehouseInstance() {

        if (warehouseInstance == null) {
            warehouseInstance = new Warehouse();
        }

        return warehouseInstance;
    }

    void getWarehouseInfo() {
        System.out.println("Максимум авто - " + MAX_CARS);
        System.out.println("Сейчас авто - " + numCars.get());
    }

    void addCar() {
        if (numCars.get() < MAX_CARS) {
            System.out.println("Было авто на складе - " + numCars.get());
            numCars.getAndIncrement();
            System.out.println("Стало авто на складе - " + numCars.get());
        } else {
            System.out.println("На складе нет места");
        }
    }

    void removeCar() {
        if (numCars.get() > 0) {
            System.out.println("Было авто на складе - " + numCars.get());
            numCars.getAndDecrement();
            System.out.println("Стало авто на складе - " + numCars.get());
        } else {
            System.out.println("На складе нет авто");
        }
    }
}
