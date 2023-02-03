package fruits;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        System.out.println("HW18");
        float appleWaight = 1.0F;
        Apple apple1 = new Apple(appleWaight);
        Apple apple2 = new Apple(appleWaight);
        Apple apple3 = new Apple(appleWaight);
        Apple apple4 = new Apple(appleWaight);
        Apple apple5 = new Apple(appleWaight);
        Apple apple6 = new Apple(appleWaight);
        Apple apple7 = new Apple(appleWaight);
        Apple apple8 = new Apple(appleWaight);
        ArrayList<Apple> appleArray = new ArrayList<Apple>();
        appleArray.add(apple2);
        appleArray.add(apple3);
        appleArray.add(apple4);
        Box<Apple> box = new Box<Apple>(10);
        Box<Apple> box2 = new Box<Apple>(10);
        box2.add(apple5);
        box2.add(apple6);
        box2.add(apple7);
        box2.add(apple8);
        Box<Orange> orangeBox = new Box<>(12);
        System.out.println(box.compare(orangeBox));
        box.add(apple1);
        System.out.println(box.getWeight());
        box.addMany(appleArray);
        System.out.println(box.getWeight());
        box.merge(box2);
        System.out.println(box.getWeight());

    }


}