/*
 * @lc app=leetcode.cn id=3090 lang=java
 *
 * [3090] 每个字符最多出现两次的最长子字符串
 */

// @lc code=start
class Solution {
    public int maximumLengthSubstring(String s) {
        int ans = 0;
        int left = 0;
        int right = 0;
        int[] cnt = new int[26];
        for (; right < s.length(); right++) {
            int c = s.charAt(right) - 'a';
            cnt[c]++;
            while (cnt[c] > 2) {
                cnt[s.charAt(left++) - 'a']--;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
// @lc code=end
