/*
 * @lc app=leetcode.cn id=3298 lang=java
 *
 * [3298] 统计重新排列后包含另一个字符串的子字符串数目 II
 */

// @lc code=start
class Solution {
    public long validSubstringCount(String word1, String word2) {
        long ans = 0;
        char[] W = word1.toCharArray();
        int[] need = new int[26];
        for (char c : word2.toCharArray()) {
            need[c - 'a']++;
        }
        int[] cnt = new int[26];
        int left = 0;
        int covered = 0;
        for (int right = 0; right < W.length; right++) {
            int cRight = W[right] - 'a';
            cnt[cRight]++;
            if (cnt[cRight] <= need[cRight]) {
                covered++;
            }
            while (covered == word2.length()) {
                int cLeft = W[left] - 'a';
                cnt[cLeft]--;
                if (cnt[cLeft] < need[cLeft]) {
                    covered--;
                }
                left++;
            }
            ans += left;
        }
        return ans;
    }
}
// @lc code=end
