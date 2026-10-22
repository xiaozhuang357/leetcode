/*
 * @lc app=leetcode.cn id=1011 lang=java
 *
 * [1011] 在 D 天内送达包裹的能力
 */

// @lc code=start
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int i : weights) {
            left = Math.max(i, left);
            right += i;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(weights, mid, days)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean check(int[] weights, int loads, int days) {
        int sum = 0;
        days--;
        for (int i = 0; i < weights.length; i++) {
            if (sum + weights[i] > loads) {
                days--;
                sum = weights[i];
            } else {
                sum += weights[i];
            }
            if (days < 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
