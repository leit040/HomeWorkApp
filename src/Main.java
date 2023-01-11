import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("HW13");

        String[] testArray = {"test1", "test2", "test3", "test4", "test5", "test6", "test7", "test8", "test9", "test10", "test2", "test3", "test3", "test2", "test3"};
        int[] testInt = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(Tools.toList(testInt));
        System.out.println(Tools.countOccurance(Arrays.asList(testArray), "test3"));
        System.out.println(Tools.findUnique(Arrays.asList(testArray)));
        for (WordCount wc : Tools.findOccurance(Arrays.asList(testArray))) {
            System.out.println("----------------------------------");
            System.out.printf("\tname: %s\n", wc.name);
            System.out.printf("\toccurrence: %s\n", wc.occurrence);
            System.out.println("----------------------------------");
        }

    }
}