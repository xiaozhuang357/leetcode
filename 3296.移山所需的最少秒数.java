/*
 * @lc app=leetcode.cn id=3296 lang=java
 *
 * [3296] 移山所需的最少秒数
 */

// @lc code=start
class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 0;
        long right = 0;
        int n = workerTimes.length;
        for (int i : workerTimes) {
            right = Math.max(right, i);
        }
        int h = (mountainHeight - 1) / n + 1;
        right = right * h * (h + 1) / 2;

        while (left < right) {
            long mid = left + (right - left) / 2;

            if (check(workerTimes, mid, mountainHeight)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    static boolean check(int[] workerTimes, long totalTime, int leftH) {
        for (int t : workerTimes) {
            leftH -= ((int) Math.sqrt(totalTime / t * 8 + 1) - 1) / 2;
            if (leftH <= 0) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end
