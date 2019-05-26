package classes;

import java.util.ArrayList;

@SuppressWarnings("Duplicates")
public class BinaryTree {

    public BinaryNode root;

    /**
     * Creates a binary tree from an arrray with indexes
     * in standard form.
     * @param array An array of node values
     * @param root  The root of the tree to insert the values at
     * @param i     Index in the array to start at
     * @return      Pointer to the tree root
     */
    public BinaryNode insertLevelOrder(int[] array, BinaryNode root, int i) {
        if (i < array.length) {
            int level = getLevelFromIndex(i);
            root = new BinaryNode(array[i], level);
            root.left = insertLevelOrder(array, root.left, 2 * i + 1);
            root.right = insertLevelOrder(array, root.right, 2 * i + 2);
        }
        return root;
    }

    /**
     * Finds the lowest level in the binary tree
     * with the maximum sum of all node values in that level.
     * @return  The level number, {0, 1, 2, ...}
     */
    public int minLevelMaxSum() {
        ArrayList<Integer> levelSums = new ArrayList<>();
        for (int i = 0; i < levelCount(); i++) {
            levelSums.add(sumAtLevel(i));
        }
        int max = levelSums.get(0);
        int maxIndex = 0;
        for (int i = 1; i < levelSums.size(); i++) {
            if (levelSums.get(i) > max) {
                max = levelSums.get(i);
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /**
     * Gets the level in binary tree that contains the
     * element based on the array index.
     * @param index
     * @return
     */
    private static int getLevelFromIndex(int index) {
        // Checks that the index is currently 1 less than a power of 2
        //
        while (((index + 1) & index) != 0) {
            index--;
        }
        return expOfBase2ForResult(index + 1);
    }


    private int sumAtLevel(int level) {
        return countLevel(root, level,0);
    }

    private int countLevel(BinaryNode root, int level, int count) {
        if (root != null) {
            if (root.level == level) {
                count += root.data;
            }
            count = countLevel(root.left, level, count);
            count = countLevel(root.right, level, count);
        }
        return count;
    }

    private int levelCount() {
        int nodeCount = nodeCount(root, 0);
        return expOfBase2ForResult(nodeCount + 1);
    }

    private int nodeCount(BinaryNode root, int count) {
        if (root != null) {
            count++;
            count = nodeCount(root.left, count);
            count = nodeCount(root.right, count);
        }
        return count;
    }

    private static int expOfBase2ForResult(int num) {
        if (num < 2) return 0;
        int count = 1;
        while (num != 2) {
            num /= 2;
            count++;
        }
        return count;
    }

}
