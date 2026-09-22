/*
 * @lc app=leetcode.cn id=1156 lang=java
 *
 * [1156] 单字符重复子串的最大长度
 */

// @lc code=start
class Solution {
    public int maxRepOpt1(String text) {
        int ans = 0;
        char[] s = text.toCharArray();
        int[] cnt = new int[26];
        for (char c : s) {
            cnt[c - 'a']++;
        }

        int target = 1;

        for (int i = 0; i < cnt.length; i++) {
            // 跳过不存在的字符
            if (cnt[i] == 0) {
                continue;
            }
            int diff = 0;
            int left = 0;
            for (int right = 0; right < s.length; right++) {
                if (s[right] - 'a' != i) {
                    diff++;
                }
                while (diff > target) {
                    if (s[left] - 'a' != i) {
                        diff--;
                    }
                    left++;
                }
                ans = Math.max(ans, Math.min(right - left + 1, cnt[i]));
            }
        }
        return ans;
    }
}
// @lc code=end
