package SimpleStream;

import java.util.Calendar;

public class Product {
    static int protoId = 0;
    int id;
    String type;
    float price;
    boolean isDiscounted;
    Calendar createdAt;


    public String getType() {
        return type;
    }
    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public float getPriceWithDiscount(float discount) {

        return this.isDiscounted ? this.price / 100 * discount : this.price;
    }

    public boolean isDiscounted() {
        return isDiscounted;
    }

    public Calendar getCreatedAt() {
        return createdAt;
    }

    public Product(String type, float price, boolean isDiscounted) {
        this.id = ++protoId;
        this.type = type;
        this.price = price;
        this.isDiscounted = isDiscounted;
        this.createdAt = Calendar.getInstance();
    }


    public int compareByPrice(Product p) {
        return Float.compare(this.price, p.getPrice());
    }


    public int compareByCreatedAt(Product p) {
        return this.createdAt.compareTo(p.getCreatedAt());
    }


}
