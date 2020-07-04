package leetcode264_nthUglyNumber;

import java.util.*;

public class Solution {

    /**
     * ["eat", "tea", "tan", "ate", "nat", "bat"]
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 1; i <= 1690; i++) {
            if(i > 1) {
                if(i % 2 == 0 && i % 3 == 0 && i % 5 == 0) {
                    queue.offer(i);
                }
            } else {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int val = queue.poll();
            n--;
            if(n == 0) {
                return val;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.nthUglyNumber(11);
        System.out.println(res);
    }
}
