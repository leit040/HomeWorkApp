import java.util.GregorianCalendar;
import java.util.Random;
import java.util.function.BiFunction;

public class Main {
    static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("____***!!!HW5!!!***____");
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.printf("Compare %d and %d, result = %s\n",25,76, compareNumbers(25,76));
        printIsPositive(44);
        System.out.printf("Check is  76, result = %s\n", isNegative(76));
        printMany("test string",10);
        System.out.printf("Check is  1979 is a leap year,, result = %s", isLeap(1979));


    }

    public static void printThreeWords() {
        String[] arr = {"Orange", "Banana", "Apple"};
        System.out.printf("%s\n%s\n%s\n", arr);
    }

    public static void checkSumSign() {
        int a, b;
        a = random.nextInt(-100, 100);
        b = random.nextInt(-50, 50);
        String mess = a + b >= 0 ? "Result positive" : "Result negative";
        System.out.println(mess);
    }

    public static void printColor() {
        int a;
        a = random.nextInt(-50, 150);
        String mess = a <= 0 ? "Red": a>100? "Green":"Yellow";
        System.out.println(mess);
    }

    public static void compareNumbers()
    {
        int a, b;
        a = random.nextInt(-100, 100);
        b = random.nextInt(-50, 50);
        String mess = a >= b ? "a > b" : "b > a";
        System.out.println(mess);
    }

    public static boolean compareNumbers(int x, int y)
    {
        int res = x+y;
        return res > 10 & res < 20;
    }

    public static void printIsPositive (int a)
    {
        String mess = a>=0? "Positive":"Negative";
        System.out.println(mess);
    }
    public static boolean isNegative(int a)
    {
    return  a<0;
    }

    public static void printMany(String str, int count)
    {
        for (int i = 0;i<count;i++){
            System.out.println(str);
        }
    }

    public static boolean isLeap(int year)
    {
        GregorianCalendar calendar = new GregorianCalendar(year, 1,1);
        return calendar.isLeapYear(year);
        //I don't understand why it need parameter year for checking, so could you please explain it in next lesson, or in private message on tg ?
    }

}