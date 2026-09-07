/*
 * @lc app=leetcode.cn id=3439 lang=java
 *
 * [3439] 重新安排会议得到最多空余时间 I
 */

// @lc code=start
class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] spare = new int[n + 1];
        int ans = 0;
        int sum = 0;
        spare[0] = startTime[0];
        for (int i = 1; i < n; i++) {
            spare[i] = startTime[i] - endTime[i - 1];
        }
        spare[n] = eventTime - endTime[n - 1];
        for (int i = 0; i < k + 1; i++) {
            sum += spare[i];
        }
        ans = sum;
        for (int i = k + 1; i < n + 1; i++) {
            sum += spare[i];
            sum -= spare[i - k - 1];
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
// @lc code=end
