/*
 * @lc app=leetcode.cn id=2555 lang=java
 *
 * [2555] 两个线段获得的最多奖品
 */

// @lc code=start
class Solution {
    public int maximizeWin(int[] prizePositions, int k) {

        int n = prizePositions.length;
        //dp[i]表示[0,i-1]的区间上，长度为k的线段最多可以覆盖多少奖励
        int[] dp = new int[n + 1];
        int left = 0;
        int ans = 0;
        for (int right = 0; right < n; right++) {

            while (prizePositions[right] - prizePositions[left] > k) {
                left++;
            }

            int current = right - left + 1;
            ans = Math.max(ans, current + dp[left]);
            //更新right+1的记录
            dp[right + 1] = Math.max(dp[right], current);
        }
        return ans;
    }
}
// @lc code=end
