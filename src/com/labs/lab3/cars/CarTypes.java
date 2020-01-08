package com.labs.lab3.cars;

import java.util.Random;

public enum CarTypes {
    Lada,
    Mitchubishi,
    Toyota;

    public static CarTypes getRandomCarType() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
