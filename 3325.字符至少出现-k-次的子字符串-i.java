/*
 * @lc app=leetcode.cn id=3325 lang=java
 *
 * [3325] 字符至少出现 K 次的子字符串 I
 */

// @lc code=start
class Solution {
    public int numberOfSubstrings(String s, int k) {
        int ans = 0;

        char[] S = s.toCharArray();
        int n = S.length;
        int right = n - 1;

        int[] cnt = new int[26];

        for (int left = n - 1; left >= 0; left--) {
            cnt[S[left] - 'a']++;

            while (cnt[S[left] - 'a'] >= k) {
                cnt[S[right] - 'a']--;
                right--;
            }

            ans += n - right - 1;
        }

        return ans;
    }
}
// @lc code=end
