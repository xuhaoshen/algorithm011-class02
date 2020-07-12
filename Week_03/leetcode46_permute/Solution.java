package leetcode46_permute;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        backtrack(nums, new LinkedList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> list, List<List<Integer>> res) {
        if(list.size() == nums.length) {
            res.add(new LinkedList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            backtrack(nums, list, res);
            list.remove(list.size() - 1);
        }
    }
}


