import java.util.function.IntFunction;

public class Main {


    public static void main(String[] args) {

        System.out.println("HW20");

//PerformOperation isOdd(): The lambda expression must return if a number is odd or if it is even.

        IntFunction<Boolean> isOdd = (n) -> n % 2 == 0;

//PerformOperation isPrime(): The lambda expression must return if a number is prime or if it is composite.

        IntFunction<Boolean> isPrime = (n) -> {
            if (n == 0 || n == 1) {
                return false;
            }
            if (n == 2) {
                return true;
            }
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        };
//PerformOperation isPalindrome(): The lambda expression must return if a number is a palindrome or if it is not.

        IntFunction<Boolean> isPalindrome = (n) -> {
            String str = String.valueOf(n);
            StringBuilder rStr = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                rStr.insert(0, str.charAt(i));
            }
            return str.equals(rStr.toString());
        };


    }
}