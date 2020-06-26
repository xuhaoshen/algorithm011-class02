package leetcode283_moveZeroes;

public class Solution {

    /**
     * [0,1,0,3,12]
     * [1,3,12,0,0]
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        // j记录最左边0的位置
        // 当发现非0元素时，与之替换
        for(int i = 0, j = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{0,1,0,3,12};
        solution.moveZeroes(arr);
        System.out.println(arr);
    }
}
