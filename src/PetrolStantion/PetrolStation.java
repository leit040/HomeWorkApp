package PetrolStantion;

import java.sql.Array;
import java.util.concurrent.ArrayBlockingQueue;

public class PetrolStation {
    final  ArrayBlockingQueue<Order> queue;

    final PetrolTank gasoline;
    final PetrolTank diesel;
    final PetrolTank propan;


    public PetrolStation(int threadCount) {
        this.gasoline = new PetrolTank(3000, 3000);
        this.diesel = new PetrolTank(2000, 2000);
        this.propan = new PetrolTank(1750, 1750);
        this.queue = new ArrayBlockingQueue<Order>(1000);
        this.startWork(threadCount);

    }

    public void doRefuel(fuelType fuelType, float fuelAmount) {
        Order order = new Order(fuelType, fuelAmount);
        if (queue.add(order)) {
            System.out.printf("Create new order, %f litres, %s \n", fuelAmount, fuelType);
            return;
        }
        System.err.printf("Didn't create new order, %f litres, %s  - queue is full!\n", fuelAmount, fuelType);
    }

    public PetrolTank getTank(fuelType type){
        PetrolTank retvalue = null;
        switch (type){
            case gasoline -> retvalue = this.gasoline;
            case diesel -> retvalue = this.diesel;
            case propan -> retvalue = this.propan;
        }
        return retvalue;
    }

    public void startWork(int threadCount){
        for(int i=0;i<threadCount;i++){
            DoRefuel thread = new DoRefuel(this);
            thread.start();
        }

    }




}
