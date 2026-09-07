/*
 * @lc app=leetcode.cn id=1456 lang=java
 *
 * [1456] 定长子串中元音的最大数目
 */

// @lc code=start
class Solution {
    public int maxVowels(String s, int k) {
        char[] input = s.toCharArray();
        int cur = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(input[i])) {
                cur++;
            }
        }
        int ans = cur;
        for (int i = k; i < input.length; i++) {
            if (isVowel(input[i -k])) {
                cur = Math.max(0, cur - 1);
            }
            if (isVowel(input[i])) {
                cur++;
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
// @lc code=end
