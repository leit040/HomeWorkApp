package ThreadSafeList;

public class Main {
    public static void main(String[] args)  {
        System.out.println("HW12");
        ThreadSafeList thlist = new ThreadSafeList();
        thlist.add("Test string 1");
        thlist.add(23);
        thlist.add(0.345);
        thlist.add(true);

        for (Object item: thlist
             ) {
            System.out.println(item);
        }

    }
}