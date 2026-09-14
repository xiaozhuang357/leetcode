/*
 * @lc app=leetcode.cn id=1234 lang=java
 *
 * [1234] 替换子串得到平衡字符串
 */

// @lc code=start
class Solution {
    public int balancedString(String s) {
        int[] cnt = new int[128];
        int left = 0;
        char[] S = s.toCharArray();
        for (char c : S) {
            cnt[c]++;
        }
        int n = S.length;
        int m = n / 4;
        int ans = n;
        if (cnt['Q'] == m && cnt['W'] == m && cnt['E'] == m && cnt['R'] == m) {
            return 0;
        }
        for (int right = 0; right < S.length; right++) {
            cnt[S[right]]--;
            while (cnt['Q'] <= m && cnt['W'] <= m && cnt['E'] <= m && cnt['R'] <= m) {
                ans = Math.min(ans, right - left + 1);
                cnt[S[left]]++;
                left++;
            }
        }
        return ans;
    }
}
// @lc code=end