package com.labs.lab3;

import com.labs.lab3.cars.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {

    private static final String TITLE = "Pfaif A.A. group 8T6B";
    private static final String LINES = "________________________________";

    public static void main(String[] args) {

        System.out.println(TITLE);

        Warehouse.getWarehouseInstance().getWarehouseInfo();

        System.out.println(LINES);

        Runnable taskCreateCars = () -> {

            for (int i = 1; i < 2; i++) {

                List<CarPlant> carsPlantsList = Arrays.asList(new RusCarPlant(), new JapanCarPlant());
                CarPlant randomCarPlant = carsPlantsList.get((new Random()).nextInt(carsPlantsList.size()));

                Car car = randomCarPlant.orderCar(CarTypes.getRandomCarType());
                showCarInfo(car);

                Warehouse.getWarehouseInstance().addCar();

                System.out.println(LINES);
            }
        };

        Runnable taskBuyCars = () -> {

            Warehouse.getWarehouseInstance().removeCar();
            System.out.println(LINES);
        };

        List<Thread> threadList = Arrays.asList(new Thread(taskCreateCars), new Thread(taskBuyCars));

        ExecutorService executor= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        try{
            while(true) {
                executor.execute(threadList.get((new Random()).nextInt(threadList.size())));
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }catch(Exception err){
            err.printStackTrace();
        }
        executor.shutdown();
    }

    private static void showCarInfo(Car car) {
        System.out.println("Марка - " + car.getCarBrand());
        System.out.println("Местоположение - " + car.getCarShopGEO());
    }
}
