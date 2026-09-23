/*
 * @lc app=leetcode.cn id=424 lang=java
 *
 * [424] 替换后的最长重复字符
 */

// @lc code=start
class Solution {
    public int characterReplacement(String s, int k) {
        int ans = 0;

        int[] cnt = new int[26];

        char[] S = s.toCharArray();

        for (char c : S) {
            cnt[c - 'A']++;
        }

        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == 0) {
                continue;
            }

            int diff = 0;

            int left = 0;
            for (int right = 0; right < S.length; right++) {
                if (S[right] - 'A' != i) {
                    diff++;
                }
                while (diff > k) {
                    if (S[left] - 'A' != i) {
                        diff--;
                    }
                    left++;
                }
                ans = Math.max(ans,  right - left + 1);
            }
        }

        return ans;
    }
}
// @lc code=end

