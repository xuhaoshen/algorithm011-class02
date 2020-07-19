package leetcode860_lemonadeChange;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for(int bill: bills) {
            switch (bill) {
                case 5:
                    five++;
                    break;
                case 10:
                    five--;
                    ten++;
                    break;
                case 20:
                    if(ten > 0) {
                        ten--;
                        five--;
                    }  else {
                        five -= 3;
                    }
                    break;
            }
            if(five < 0 || ten < 0) {
                return false;
            }
        }
        return true;
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


