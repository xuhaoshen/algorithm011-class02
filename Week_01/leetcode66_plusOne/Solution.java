package leetcode66_plusOne;

public class Solution {

    /**
     * [4,3,2,1] -> [4,3,2,2]
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--) {
            // 取模为0时，需要向上进1
            digits[i] = (digits[i] + 1) % 10;
            if(digits[i] > 0) return digits;
        }
        // 出现[0,0,0]时
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{9,9,9};
        int[] res = solution.plusOne(arr);
        System.out.println(res);
    }
}
