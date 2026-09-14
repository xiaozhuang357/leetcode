/*
 * @lc app=leetcode.cn id=2904 lang=java
 *
 * [2904] 最短且字典序最小的美丽子字符串
 */

// @lc code=start
class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans = "";
        int cnt = 0;
        int left = 0;
        int len = Integer.MAX_VALUE;
        int[] dplen = new int[s.length()];
        char[] S = s.toCharArray();
        for (int i = 0; i < dplen.length; i++) {
            dplen[i] = -1;
        }
        for (int right = 0; right < S.length; right++) {
            cnt += S[right] - '0';
            while (cnt == k) {
                len = Math.min(len, right - left + 1);
                dplen[left] = right - left + 1;
                cnt -= S[left] - '0';
                left++;
            }
        }
        String cur = s;
        for (int i = 0; i < dplen.length; i++) {
            if (dplen[i] == len) {
                cur = minString(cur, s.substring(i, i + len));
            }
        }
        return len == Integer.MAX_VALUE ? ans : cur;
    }

    public String minString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return s1.length() < s2.length() ? s1 : s2;
        }

        return s1.compareTo(s2) <= 0 ? s1 : s2;
    }
}
// @lc code=end
