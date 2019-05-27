package binary_tree;

public class Node {

    int level;
    int data;
    Node left;
    Node right;

    Node(int data, int level) {
        this.level = level;
        this.data = data;
        left = null;
        right = null;
    }
}
