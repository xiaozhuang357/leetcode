/*
 * @lc app=leetcode.cn id=1283 lang=java
 *
 * [1283] 使结果不超过阈值的最小除数
 */

// @lc code=start
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 0;
        int right = 0;
        for (int x : nums) {
            right = Math.max(right, x);
        }
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (check(nums, mid, threshold)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private static boolean check(int[] nums, int div, int threshold) {
        int sum = 0;
        for (int num : nums) {
            sum += ceilDiv(num, div);
            if (sum > threshold) {
                return false;
            }
        }
        return true;
    }

    private static int ceilDiv(int a, int b) {
        return (a + b - 1) / b;
    }

}
// @lc code=end
