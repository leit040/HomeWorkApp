package PetrolStantion;

import java.util.concurrent.ArrayBlockingQueue;

public class DoRefuel extends Thread {

    final PetrolStation station;

    public DoRefuel(PetrolStation station) {
        this.station = station;
    }

    public void run() {
        Order order;
        while (true) {
            try {
                order = station.queue.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            PetrolTank tank = station.getTank(order.getType());
            if (tank.getFuel(order.getAmount())) {
                System.out.printf(this.getName() + " filled the tank with %f liters %s!\n", order.getAmount(), order.getType());
                continue;
            }
            System.err.printf(this.getName() + " did not fill the tank with %f liters %s: fuel ran out!\n", order.getAmount(), order.getType());
        }

    }

}


