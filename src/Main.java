public class Main {
    public static void main(String[] args) {
        System.out.println("HW6");
        System.out.println(findSymbolOccurance("GHjgdhaghjasghjasgdewyuewydgew", 'j'));
        System.out.println(findWordPosition("Big test string", "test"));
        System.out.println(stringReverse("String to reverse"));
        System.out.println(isPalindrome("EREERE"));

    }


    public static int findSymbolOccurance(String source, char target) {
        int result = 0;
        for (Character ch : source.toCharArray()) {
            if (ch == target) {
                result++;
            }
        }
        return result;
    }

    public static int findWordPosition(String source, String target) {
        return source.indexOf(target);
    }

    public static String stringReverse(String source) {
        StringBuilder sb = new StringBuilder(source);
        return sb.reverse().toString();
    }

    public static boolean isPalindrome(String source) {
        return source.equals(stringReverse(source));
    }




}