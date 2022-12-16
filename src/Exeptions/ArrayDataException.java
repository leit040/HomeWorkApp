package Exeptions;

public class ArrayDataException extends Exception{


    public ArrayDataException(int x,int y, String value) {
        super("Your  array contain non-converting value '"+value+"' in ["+x+"]["+y+"]");

    }

}
