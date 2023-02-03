import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("HW18");
        Integer[] array = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(toList(array));
    }

    public static <T> List<T> toList(T[] array) {

        return new ArrayList<T>(Arrays.asList(array));
    }
}