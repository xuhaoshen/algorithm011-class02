package leetcode42_trap;

import java.util.*;

public class Solution {

    /**
     *
     *           *
     *    *      * *   *
     *  * * *  * * * * * *
     * l                 r
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            // 蓄水由最矮挡板决定
            if(height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                res += (leftMax - height[left]);
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                res += (rightMax - height[right]);
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int res = solution.trap(arr);
        System.out.println(res);
    }

}
