import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("HW7");

        int size_x = 4;
        int size_y = 4;
        Random rand = new Random();
        String[][] strArr = new String[size_x][size_y];
        for (int x = 0;x<size_x;x++){
            for (int y = 0;y<size_y;y++){
                strArr[x][y] = String.valueOf(rand.nextInt(10,99));
            }
        }
      //  strArr[2][2] = "Xxd"; uncomment this for test
//
//        for (int x = 0;x<size_x;x++){
//            System.out.print('\n');
//            for (int y = 0;y<size_y;y++){
//                System.out.print(' '+strArr[x][y]);
//            }
//        }

        System.out.println("\n\n");

        try {
            System.out.println("\n\n result = " + ArrayValueCalculator.doCalc(strArr));
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }

    }
}