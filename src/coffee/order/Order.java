package coffee.order;

public class Order {
    private static int count = 0;
    private final int id;
    private final String name;
    private final ProductList product;

    public Order(String name, ProductList product) {
        this.id = ++count;
        this.name = name;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ProductList getProduct() {
        return product;
    }
}
