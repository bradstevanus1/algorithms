package binary_tree;

import java.util.ArrayList;

@SuppressWarnings("Duplicates")
public class Tree {

    public Node root;

    /**
     * Creates a binary tree from an arrray with indexes
     * in standard form.
     * @param array An array of node values
     * @param root  The root of the tree to insert the values at
     * @param i     Index in the array to start at
     * @return      Pointer to the tree root
     */
    public Node insertLevelOrder(int[] array, Node root, int i) {
        if (i < array.length) {
            int level = getLevelFromIndex(i);
            root = new Node(array[i], level);
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
     * Finds the lowest level in the array (which
     * represents a binary tree) with the maximum
     * sum of all the nodes in that level.
     * @param array Standard array representing a
     *              binary tree
     * @return      Level with highest sum {0, 1, 2, ...}
     */
    public static int minLevelMaxSum(int[] array) {
        int max = array[0];
        int maxLevel = 0;
        int sum = 0;
        int level = 0;
        int levelSize = (int) Math.pow(2, level);
        int i = 0;
        while (i < array.length) {
            for (int j = 0; j < levelSize; j++) {
                sum += array[i];
                i++;
                if (i >= array.length) break;
            }
            if (sum >= max) {
                max = sum;
                maxLevel = level;
            }
            sum = 0;
            level++;
            levelSize = (int) Math.pow(2, level);
        }
        return maxLevel;
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
        return getExponent(2, index + 1);
    }


    private int sumAtLevel(int level) {
        return countLevel(root, level,0);
    }

    private int countLevel(Node root, int level, int count) {
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
        return getExponent(2, nodeCount + 1);
    }

    private int nodeCount(Node root, int count) {
        if (root != null) {
            count++;
            count = nodeCount(root.left, count);
            count = nodeCount(root.right, count);
        }
        return count;
    }

    /**
     * Returns the exponent that is applied to
     * base {base} to yield the result {result}.
     * For example:
     * base = 2
     * result = 8
     * 2^n = 8 => n = 3
     * @param base      The power base
     * @param result    The power result
     * @return          The power exponent
     */
    private static int getExponent(int base, int result) {
        return (int) (Math.log(result)/Math.log(base));
    }

}
