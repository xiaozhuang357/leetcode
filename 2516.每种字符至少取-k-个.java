/*
 * @lc app=leetcode.cn id=2516 lang=java
 *
 * [2516] 每种字符至少取 K 个
 */

// @lc code=start
class Solution {
    public int takeCharacters(String s, int k) {
        int[] num = new int[3];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 3; i++) {
            if (num[i] < k) {
                return -1;
            }
        }
        int left = 0;
        int right = 0;
        int widLength = 0;
        int[] wid = new int[3];
        for (; right < s.length(); right++) {
            int index = s.charAt(right) - 'a';
            wid[index]++;
            while (wid[index] + k > num[index]) {
                int leftIndex = s.charAt(left++) - 'a';
                wid[leftIndex]--;
            }
            widLength = Math.max(widLength, right - left + 1);
        }
        return s.length() - widLength;

    }
}
// @lc code=end
