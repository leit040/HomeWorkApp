package PetrolStantion;

import java.util.concurrent.ArrayBlockingQueue;

public class PetrolTank {

    private float fuelVolume;
    final private float maxCapacity;

    PetrolTank(float fuelVolume, float maxCapacity) {
        this.fuelVolume = fuelVolume;
        this.maxCapacity = maxCapacity;
    }

    PetrolTank() {
        this.fuelVolume = 0;
        this.maxCapacity = 1000;
    }


    synchronized boolean addFuel(float fuelAmount) {
        if (checkBeforeAddFuel(fuelAmount)) {
            this.fuelVolume += fuelAmount;
            return true;
        }
        return false;
    }

    synchronized float getFuelVolume() {
        return this.fuelVolume;
    }

    synchronized boolean checkBeforeAddFuel(float fuelAmount) {
        return fuelAmount + getFuelVolume() <= maxCapacity;
    }

    synchronized boolean checkBeforeGetFuel(float fuelAmount) {
        return fuelAmount <= fuelVolume;
    }

    synchronized boolean getFuel(float fuelAmount) {
        if (checkBeforeGetFuel(fuelAmount)) {
            this.fuelVolume = this.fuelVolume - fuelAmount;
            return true;
        }
        return false;
    }

}
