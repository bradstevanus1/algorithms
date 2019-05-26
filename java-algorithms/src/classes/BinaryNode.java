package classes;

public class BinaryNode {

    int level;
    int data;
    BinaryNode left;
    BinaryNode right;

    BinaryNode(int data, int level) {
        this.level = level;
        this.data = data;
        left = null;
        right = null;
    }
}
