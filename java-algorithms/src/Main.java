import two_sum.TwoSum;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        int[] array = solution.twoSumTwoPass(new int[]{3, 2, 4}, 6);
        System.out.println(Arrays.toString(array));
    }

}
