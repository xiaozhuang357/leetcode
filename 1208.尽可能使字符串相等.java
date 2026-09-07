/*
 * @lc app=leetcode.cn id=1208 lang=java
 *
 * [1208] 尽可能使字符串相等
 */

// @lc code=start
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int ans = 0;
        int minCost = 0;
        int left = 0;
        int right = 0;
        for (; right < n; right++) {
            minCost += Math.abs(s.charAt(right) - t.charAt(right));
            while (minCost > maxCost) {
                minCost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
// @lc code=end
