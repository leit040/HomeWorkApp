import SimpleStream.Product;
import SimpleStream.ProductList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("HW19");
        Random rand = new Random();
        ProductList pl = new ProductList();
        String[] types = {"Book","Notepad","Pen"};
        for(int i = 0;i<10;i++){
            Product product = new Product(types[rand.nextInt(0,2)], rand.nextFloat(65,300), rand.nextBoolean());
            pl.add(product);

        }
        System.out.println("pl.getBookProducts");
        printList(pl.getBookProducts());
        System.out.println("pl.getBookProductsWithDiscount()");
        printList(pl.getBookProductsWithDiscount());
        System.out.println("Book with min price");
        printProduct(pl.getBookWithMinPrice());
        System.out.println("getlastThreeProducts");
        printList(pl.getlastThreeProducts());
        System.out.println("pl.Calculate");
        System.out.printf("Calculation: %f\n",pl.Calculate());
        System.out.println("pl.getMap()");
        System.out.println(pl.getMap());
    }
    public static void printList(List<Product> pList){

        for (Product p:pList) {
            printProduct(p);
        }
    }

    public static void printProduct(Product p){

        System.out.println("--------------------------------------------");
        System.out.println(p.getId());
        System.out.println(p.getType());
        System.out.println(p.getPriceWithDiscount(0.9F));
        System.out.println(p.getCreatedAt().getTime());
        System.out.println(p.isDiscounted());
        System.out.println("--------------------------------------------");
    }

}