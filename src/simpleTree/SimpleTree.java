package simpleTree;

import java.util.HashMap;


public class SimpleTree {
    Node root;

    private Node addNode(Node currentNode, int value) {

        if (root == null) {
            Node root = new Node(null, value);
            this.root = root;
            return root;
        }
        if (currentNode.getValue() == value) {
            return currentNode;
        }
        if (value > currentNode.getValue()) {
            if (currentNode.getRight() != null) {
                return addNode(currentNode.getRight(), value);
            } else {
                Node node = new Node(currentNode, value);
                currentNode.setRight(node);
                return node;
            }
        }
        if (currentNode.getLeft() != null) {
            return addNode(currentNode.getLeft(), value);
        } else {
            Node node = new Node(currentNode, value);
            currentNode.setLeft(node);
            return node;
        }
    }

    void addAll(int[] values){
        for (int value:values) {
            add(value);
        }
    }
    void add(int value) {
        this.addNode(root, value);
    }

    public HashMap<Integer, Node> nodesList() {
        HashMap<Integer, Node> result = new HashMap<Integer, Node>();
        this.getRecursive(root, result);
        return result;
    }

    private void getRecursive(Node node, HashMap<Integer, Node> result) {

        if (node.getLeft() != null) {
            getRecursive(node.getLeft(), result);
        }
        if (node.getRight() != null) {
            getRecursive(node.getRight(), result);
        }
        result.put(node.getValue(), node);
    }

}
