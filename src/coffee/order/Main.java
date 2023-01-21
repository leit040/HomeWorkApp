package coffee.order;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("HW15");
        CoffeeOrderBoard cor = new CoffeeOrderBoard();
        cor.add("Ivan",ProductList.Capuchino);
        cor.add("John",ProductList.DoubleEspresso);
        cor.add("Johanna",ProductList.Late);
        cor.add("Viktor",ProductList.Raf);
        cor.add("Ivan",ProductList.Late);
        cor.add("John",ProductList.Raf);
        cor.add("Johanna",ProductList.Capuchino);
        cor.add("Viktor",ProductList.DoubleEspresso);
        cor.draw();

        cor.deliver();
        cor.deliver();
        cor.draw();
        cor.deliver(6);
        cor.deliver(8);
        cor.draw();


    }
}