package leetcode26_removeDuplicates;

public class Solution {

    /**
     * nums = [0,0,1,1,1,2,2,3,3,4]
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        // 左指针
        int left = 0;
        // 右指针
        int right = 1;
        // 遍历右指针，直到数组结束
        while (right < nums.length) {
            // 当右指针对应的值与当前左指针对应的值不同
            // 则将左指针偏移一位，使当右指针值再出现不同值时，
            // 能替换当前左指针的值
            if(nums[right] != nums[left]) {
                left++;
                nums[left] = nums[right];
            }
            right++;
        }
        // 返回数组不同值的长度，并非下标
        return left + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
        System.out.println(res);
    }
}
