import java.util.*;

public class Tools {
    public static int countOccurance(List<String> list, String needle) {
        int result = 0;
        for (String string : list
        ) {
            if (string.equals(needle)) {
                result++;
            }
        }
        return result;
    }

    public static List<Integer> toList(int[] list) {

      //  return  Arrays.stream(list).boxed().toList(); //):
        List result = new ArrayList<Integer>();
        for (int i:list) {
            result.add(i);
        }
        return result;
    }

    public static List findUnique(List<String> list) {

        List<Object> result = new ArrayList<>();
        if (list.size() == 0) {
            return result;
        }
        result.add(list.get(0));
        for (Object o : list
        ) {
            if (!result.contains(o)) {
                result.add(o);
            }
        }
        return result;
    }

    public static List<WordCount> findOccurance(List<String> list) {
        List<WordCount> result = new ArrayList<WordCount>();
        List uniqValues  = Tools.findUnique(list);
        for (Object string : uniqValues) {
            result.add(new WordCount(string.toString(), Tools.countOccurance(list, string.toString())));
        }
        return result;
    }

}
