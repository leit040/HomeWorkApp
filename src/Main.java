import java.util.Arrays;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("HW16");
        int[] array = { -123,-122,-345,12,34,978,-44,456,12,18,16,24,12,56,90,567,-475 };
        //quicksort(array, 0, array.length - 1);
        shakerSort(array);
        System.out.println(Arrays.toString(array));


    }

    public static void swap (int[] array, int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int partition(int[] array, int start, int end)
    {
        int pivot = array[end];
        int pIndex = start;
        for (int i = start; i < end; i++)
        {
            if (array[i] <= pivot)
            {
                swap(array, i, pIndex);
                pIndex++;
            }
        }
        swap(array, end, pIndex);
        return pIndex;
    }

    public static void quicksort(int[] array, int start, int end)
    {
       if (start >= end) {
            return;
        }
        int pivot = partition(array, start, end);
        quicksort(array, start, pivot - 1);
        quicksort(array, pivot + 1, end);
    }
 




 
    public static void shakerSort(int[] array) {
        int tmp;
        int left = 0;
        int right = array.length - 1;
        do {
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (array[i] < array[i - 1]) {
                    tmp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = tmp;
                }
            }
            left++;
        } while (left < right);
    }
}