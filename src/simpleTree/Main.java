package simpleTree;
import java.util.HashMap;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("HW17");
        SimpleTree sp = new SimpleTree();
        sp.add(1);
        sp.add(3);
        sp.add(2);
        int[] values = {4,7,9,5,6,11,-1,-3,-2,-34-25-34,45,22,33,55,78,456,4};
        sp.addAll(values);



        HashMap<Integer,Node> result = sp.nodesList();
        for (Node node: result.values()) {
            System.out.println(node.getValue());
            System.out.printf("Parent: %d\n",node.getParent()!=null ? node.getParent().value:0);

        }
    }
}