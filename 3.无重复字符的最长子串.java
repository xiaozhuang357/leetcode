/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int[] cnt = new int[128];
        int left = 0;
        int right = 0;
        for (; right < s.length(); right++) {
            char c = s.charAt(right);
            cnt[c]++;
            while (cnt[c] > 1) {
                cnt[s.charAt(left)]--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
// @lc code=end
