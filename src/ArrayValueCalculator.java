import Exeptions.ArrayDataException;
import Exeptions.ArraySizeException;



public class ArrayValueCalculator {

    public static int doCalc(String[][] strArray) throws Exception {
        if (strArray.length != 4) {
            throw new ArraySizeException();
        }
        for (int i = 0; i <= 3; i++) {
            if (strArray[i].length != 4) {
                throw new ArraySizeException();
            }
        }
        return convertValuesToInt(strArray);
    }

    private static int convertValuesToInt(String[][] array) throws ArrayDataException {

        int result = 0;
        for (int x = 0; x <= 3; x++) {
            for (int y = 0; y <= 3; y++) {
                try {
                    result += Integer.parseInt(array[x][y]);
                }
                catch (NumberFormatException e){
                    throw new ArrayDataException(x,y,array[x][y]);
                }
            }

        }
return result;
    }
}
