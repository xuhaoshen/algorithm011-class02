package leetcode47_permuteUnique;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        backtrack(nums, new LinkedList<>(), res, new boolean[nums.length]);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> list, List<List<Integer>> res, boolean[] visited) {
        if(list.size() == nums.length) {
            res.add(new LinkedList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(visited[i]) continue;
            if(i > 0 && nums[i] == nums[i-1] && visited[i-1]) break;
            list.add(nums[i]);
            visited[i] = true;
            backtrack(nums, list, res, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
