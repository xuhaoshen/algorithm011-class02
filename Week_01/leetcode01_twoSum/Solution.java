package leetcode01_twoSum;

import java.util.*;

public class Solution {

    /**
     * nums = [2, 7, 11, 15], target = 9
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int rest = target - nums[i];
            if(map.containsKey(rest)) {
                return new int[] {i, map.get(rest)};
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{2, 5, 5, 11};
        int[] res = solution.twoSum(arr, 10);
        System.out.println(res);
    }
}
