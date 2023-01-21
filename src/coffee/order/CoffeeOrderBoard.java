package coffee.order;

import java.util.TreeMap;

public class CoffeeOrderBoard {
    private final TreeMap<Integer, Order> queue;

    CoffeeOrderBoard() {
        this.queue = new TreeMap<Integer, Order>();
    }

    void add(String name, ProductList product) {
        Order order = new Order(name, product);
        this.queue.put(order.getId(), order);
    }

    Order deliver(int id) {
        Order order = this.queue.get(id);
        this.queue.remove(id);
        return order;
    }

    Order deliver() {
        return this.deliver(queue.firstKey());
    }

    void draw() {

        System.out.println("|\tNum\t|\tName\t\t|\tProduct\t|");
        for (Order order : queue.values()) {
            System.out.printf("\t%d\t|\t%s\t\t|\t%s\n", order.getId(), order.getName(), order.getProduct());
        }
        System.out.println("\n----------------------------------------------------\n");
    }

}
