import binary_tree.Solution;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] binaryTree = {-2, 3, 5000, 0, -5, -5, 200};
        int levelOfMaxSum = solution.solution(binaryTree);
        System.out.println(levelOfMaxSum);
    }

}
