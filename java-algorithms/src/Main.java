import binary_tree.Solution;
import classes.BinaryTree;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] binaryTree = {100, 5, 10, 0, -1, -4, 0};
        int levelOfMaxSum = solution.solution(binaryTree);
        System.out.println(levelOfMaxSum);
    }

}
