/*
 * @lc app=leetcode.cn id=2187 lang=java
 *
 * [2187] 完成旅途的最少时间
 */

// @lc code=start
class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long left = 0;
        long right = Integer.MAX_VALUE;
        for (int i : time) {
            right = Math.min(i, right);
        }
        right *= totalTrips;
        while (left + 1 < right) {
            long mid = left + (right - left) / 2;
            if (check(time, mid, totalTrips)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }

    private static boolean check(int[] time, long totalTime, int totalTrips) {
        int sum = 0;
        for (int t : time) {
            sum += totalTime / t;
            if (sum >= totalTrips) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
