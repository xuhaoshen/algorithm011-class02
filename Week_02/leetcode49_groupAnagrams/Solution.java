package leetcode49_groupAnagrams;

import java.util.*;

public class Solution {

    /**
     * ["eat", "tea", "tan", "ate", "nat", "bat"]
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            System.out.println(key);
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = solution.groupAnagrams(arr);
        System.out.println(res);
    }
}
