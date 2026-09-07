/*
 * @lc app=leetcode.cn id=2730 lang=java
 *
 * [2730] 找到最长的半重复子字符串
 */

// @lc code=start
class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int ans = 0;
        int left = 0;
        int right = 1;
        int cnt = 0;
        for (; right < s.length(); right++) {
            if (s.charAt(right - 1) == s.charAt(right)) {
                cnt++;
            }
            while (cnt > 1) {
                if (s.charAt(left) == s.charAt(left + 1)) {
                    cnt--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
// @lc code=end
