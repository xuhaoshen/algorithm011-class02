package leetcode91_numDecodings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int numDecodings(String s) {
        int count = 1;
        char[] _s = s.toCharArray();
        if(_s[0] == '0') return 0;
        int pre = 1;
        for(int i = 1; i < _s.length; i++) {
            int temp = count;
            if(_s[i] == '0') {
                if (_s[i - 1] == '1' || _s[i - 1] == '2') {
                    count = pre;
                } else {
                    return 0;
                }
            } else if(_s[i - 1] == '1' || (_s[i - 1] == '2' && _s[i] >= '1' && _s[i] <= '6')) {
                count = count + pre;
            }
            pre = temp;
        }
        return count;
    }
}
