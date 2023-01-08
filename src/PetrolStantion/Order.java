package PetrolStantion;

public class Order {
    private final fuelType type;
    private final float amount;

    Order(fuelType type, float amount){
    this.type = type;
    this.amount = amount;
    }

    public fuelType getType() {
        return type;
    }

    public float getAmount() {
        return amount;
    }
}
