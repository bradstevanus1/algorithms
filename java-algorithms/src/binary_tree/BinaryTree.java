package binary_tree;

@SuppressWarnings("Duplicates")
public class BinaryTree {

    public int solution(int[] A) {
        Tree tree = new Tree();
        tree.root= tree.insertLevelOrder(A, tree.root, 0);
        return tree.minLevelMaxSum();
    }

}
