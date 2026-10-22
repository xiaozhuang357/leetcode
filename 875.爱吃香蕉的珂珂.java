/*
 * @lc app=leetcode.cn id=875 lang=java
 *
 * [875] 爱吃香蕉的珂珂
 */

// @lc code=start
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int i : piles) {
            right = Math.max(right, i);
        }
        if (piles.length == h) {
            return right;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    static boolean check(int[] piles, int k, int h) {
        int sum = 0;
        for (int i : piles) {
            sum += (i + k - 1) / k;
            if (sum > h) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
