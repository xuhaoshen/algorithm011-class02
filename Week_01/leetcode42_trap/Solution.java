package leetcode42_trap;

import java.util.*;

public class Solution {

    /**
     *
     *           *
     *    *      * *   *
     *  * * *  * * * * * *
     *  l                r
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        int leftMax = 0;
        int rightMax = 0;
        // 蓄水由最矮挡板决定
        while (left < right) {
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
//        Solution solution = new Solution();
//        int[] arr = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        int res = solution.trap(arr);
//        System.out.println(res);
        System.out.println(11>>>1);
        PriorityQueue queue = new PriorityQueue();

        queue.offer(14);
        queue.offer(7);
        queue.offer(12);
        queue.offer(6);
        queue.offer(9);
        queue.offer(4);
        queue.offer(17);
        queue.offer(23);
        queue.offer(10);
        queue.offer(15);
        queue.offer(3);
        System.out.println(queue);

        int x = 3;
        int e =9;
        Comparable<Integer> comparator = (Comparable<Integer>) x;
        System.out.println(comparator.compareTo(e) >= 0);
    }

}
