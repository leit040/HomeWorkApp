package fruits;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    int capacity;
    ArrayList<T> box;


    Box(int capacity) {
        this.capacity = capacity;
        this.box = new ArrayList<T>(capacity);
    }

    public void add(T fruit) {
        if (box.size() + 1 <= capacity) {
            box.add(fruit);
        }
    }

    public void addMany(ArrayList<T> fruits) {
        if (fruits.size() + box.size() <= capacity) {
            box.addAll(fruits);
        }
    }

    public float getWeight() {
        return box.size() == 0 ? 0 : box.size() * box.get(0).getWeight();
    }

    public boolean compare(Box box) {
        return this.getWeight() == box.getWeight();
    }

    public int fruitCount(){
        return box.size();
    }

    public void merge( Box<T> box){
        if(box.fruitCount() <= this.capacity - this.box.size()){
            this.addMany(box.box);
        }
    }

}
