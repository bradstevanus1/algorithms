package two_sum;

import java.util.HashMap;

@SuppressWarnings("Duplicates")
public class TwoSum {

    public int[] twoSumTwoPass(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target && i != j) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution!");
    }

    public int[] twoSumTwoPassHashTable(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num) && map.get(num) != i) {
                return new int[]{i, map.get(num)};
            }
        }
        return null;
    }

    public int[] twoSumOnePassHashTable(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                return new int[] { map.get(num), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution!");
    }


}
