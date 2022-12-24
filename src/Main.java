public class Main {
// It my result with  setCount = 1000000000

//    HW11
//    end of first part:0.222958
//    end of second part:0.222958
//    It's take a 15669 milliseconds
//    Process finished with exit code 0


    public static void main(String[] args) throws InterruptedException {
        System.out.println("HW11");
        ValueCalculator valueCalculator = new ValueCalculator(1000000000);
        valueCalculator.run();
    }
}