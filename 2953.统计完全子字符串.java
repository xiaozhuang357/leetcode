/*
 * @lc app=leetcode.cn id=2953 lang=java
 *
 * [2953] 统计完全子字符串
 */

// @lc code=start
class Solution {
    public int countCompleteSubstrings(String word, int k) {
        int n = word.length();
        int i = 0;
        int ans = 0;
        while (i < n) {
            int start = i;
            i++;
            while (i < n && Math.abs(word.charAt(i) - word.charAt(i - 1)) <= 2) {
                i++;
            }
            // 此时start到i中间的所有字符只差都小于等于2
            // 进行处理
            ans += f(word.substring(start, i), k);
        }
        return ans;
    }

    public int f(String S, int k) {
        int res = 0;
        char[] s = S.toCharArray();
        for (int m = 1; m <= 26 && m * k <= s.length; m++) {
            int[] cnt = new int[26];
            int windLen = m * k;
            for (int right = 0; right < s.length; right++) {
                int left = right - windLen + 1;
                cnt[s[right] - 'a']++;
                if (left < 0) {
                    continue;
                }
                boolean ok = true;
                for (int i = 0; i < 26; i++) {
                    if (cnt[i] > 0 && cnt[i] != k) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    res++;
                }
                cnt[s[left] - 'a']--;
            }
        }
        return res;
    }
}
// @lc code=end
