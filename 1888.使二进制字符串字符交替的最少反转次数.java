/*
 * @lc app=leetcode.cn id=1888 lang=java
 *
 * [1888] 使二进制字符串字符交替的最少反转次数
 */

// @lc code=start
class Solution {
    public int minFlips(String s) {
        int n = s.length();
        int ans = n / 2;
        char[] s01 = "01".toCharArray();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == s01[i % 2]) {
                cnt++;
            }
        }
        ans = Math.min(ans, Math.min(cnt, n - cnt));
        for (int i = n; i < 2 * n - 1; i++) {
            if (s.charAt(i % n) == s01[i % 2]) {
                cnt++;
            }
            if (s.charAt((i - n) % n) == s01[(i - n) % 2]) {
                cnt--;
            }
            ans = Math.min(ans, Math.min(cnt, n - cnt));
        }
        return ans;
    }
}
// @lc code=end
