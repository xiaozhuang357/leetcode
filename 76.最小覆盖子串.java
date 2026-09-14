/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        char[] S = s.toCharArray();
        String ans = "";
        Map<Character, Integer> cnt = new HashMap<>();
        for (char c : t.toCharArray()) {
            cnt.merge(c, 1, Integer::sum);
        }
        int left = 0;
        int minLen = Integer.MAX_VALUE;

        int valid = 0;

        Map<Character, Integer> cur = new HashMap<>();
        for (int right = 0; right < S.length; right++) {
            if (cnt.containsKey(S[right])) {

                char c = S[right];
                cur.merge(c, 1, Integer::sum);

                if (cnt.get(c).equals(cur.get(c))) {
                    valid++;
                }
            }
            while (valid == cnt.size()) {
                if (minLen > right - left + 1) {
                    minLen = right - left + 1;
                    ans = s.substring(left, left + minLen);
                }

                char d = S[left];
                if (cnt.containsKey(d)) {
                    if (cnt.get(d).equals(cur.get(d))) {
                        valid--;
                    }
                    cur.merge(d, -1, Integer::sum);
                }
                left++;
            }
        }
        return ans;
    }
}
// @lc code=end
