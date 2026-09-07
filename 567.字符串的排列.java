/*
 * @lc app=leetcode.cn id=567 lang=java
 *
 * [567] 字符串的排列
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map.merge(s1.charAt(i), 1, Integer::sum);
        }
        for (int i = 0; i < s1.length(); i++) {
            int cnt = map.merge(s2.charAt(i), -1, Integer::sum);
            if (cnt == 0) {
                map.remove(s2.charAt(i));
            }
        }
        if (map.isEmpty()) {
            return true;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            int cnt = map.merge(s2.charAt(i), -1, Integer::sum);
            if (cnt == 0) {
                map.remove(s2.charAt(i));
            }
            cnt = map.merge(s2.charAt(i - s1.length()), 1, Integer::sum);
            if (cnt == 0) {
                map.remove(s2.charAt(i - s1.length()));
            }
            if (map.isEmpty()) {
                return true;
            }
        }
        return false;

    }
}
// @lc code=end
