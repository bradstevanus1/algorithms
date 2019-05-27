package binary_tree;

import classes.BinaryTree;

@SuppressWarnings("Duplicates")
public class Solution {

    public int solution(int[] A) {
        BinaryTree tree = new BinaryTree();
        tree.root= tree.insertLevelOrder(A, tree.root, 0);
        return tree.minLevelMaxSum();
    }

}
