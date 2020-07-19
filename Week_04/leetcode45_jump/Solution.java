package leetcode45_jump;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int jump(int[] nums) {
        int max = 0;
        int position = 0;
        int step = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if(position == i) {
                position = max;
                step++;
            }
        }
        return step++;
    }
}


