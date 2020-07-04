package leetcode11_maxArea;

public class Solution {

    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int minHeight = height[left] < height[right] ? height[left++] : height[right--];
            max = Math.max(max, (right - left + 1) * minHeight);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
        int res = solution.maxArea(arr);
        System.out.println(res);
    }

}
