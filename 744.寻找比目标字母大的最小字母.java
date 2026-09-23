/*
 * @lc app=leetcode.cn id=744 lang=java
 *
 * [744] 寻找比目标字母大的最小字母
 */

// @lc code=start
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] < target + 1) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left < letters.length ? letters[left] : letters[0];
    }
}
// @lc code=end
