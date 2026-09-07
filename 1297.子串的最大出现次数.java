/*
 * @lc app=leetcode.cn id=1297 lang=java
 *
 * [1297] 子串的最大出现次数
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < minSize; i++) {
            char c = s.charAt(i);
            map.merge(c, 1, Integer::sum);
        }
        Map<String, Integer> strMap = new HashMap<>();
        if (map.size() <= maxLetters) {
            String subStr = s.substring(0, minSize);
            ans = strMap.merge(subStr, 1, Integer::sum);
        }
        for (int i = minSize; i < s.length(); i++) {
            char c = s.charAt(i);
            map.merge(c, 1, Integer::sum);
            c = s.charAt(i - minSize);
            if (map.get(c) == 1) {
                map.remove(c);
            } else {
                map.merge(c, -1, Integer::sum);
            }
            if (map.size() <= maxLetters) {
                String sub = s.substring(i - minSize + 1, i + 1);
                int cnt = strMap.merge(sub, 1, Integer::sum);
                ans = Math.max(ans, cnt);
            }

        }
        return ans;
    }
}
// @lc code=end
