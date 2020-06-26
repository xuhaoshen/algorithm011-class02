package leetcode189_rotate;

public class Solution {

    /**
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        // 取余，当k = nums.length时，则nums返回原处
        int mod = k % nums.length;
        // 7 6 5 4 3 2 1
        reverse(nums, 0, nums.length - 1);
        // 5 6 7 4 3 2 1
        reverse(nums, 0, mod - 1);
        // 5 6 7 1 2 3 4
        reverse(nums, mod, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1,2,3,4,5,6,7};
        solution.rotate(arr, 3);
        System.out.println(arr);
    }
}
