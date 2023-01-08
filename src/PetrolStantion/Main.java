package PetrolStantion;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("HW12");
        String[] types = Arrays.toString(fuelType.values()).replaceAll("^.|.$", "").split(", ");
        PetrolStation station = new PetrolStation(3);
        for(int i=0;i<100;i++){
            station.doRefuel(fuelType.valueOf(types[new Random().nextInt(0,3)]),new Random().nextFloat(3,50));
          //  Thread.sleep(1000);
        }
    }
}