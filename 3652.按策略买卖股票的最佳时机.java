/*
 * @lc app=leetcode.cn id=3652 lang=java
 *
 * [3652] 按策略买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        long ans = 0;
        long income = 0;
        int days = prices.length;
        for (int i = 0; i < days; i++) {
            income += strategy[i] * prices[i];
        }
        ans = income;
        for (int i = 0; i < k; i++) {
            int half = k >> 1;
            income += i < half ? (0 - strategy[i]) * prices[i] : (1 - strategy[i]) * prices[i];
        }
        ans = Math.max(ans, income);
        for (int i = k; i < days; i++) {
            income += (1 - strategy[i]) * prices[i];
            income += (0 - 1) * prices[i - (k >> 1)];
            income -= (0 - strategy[i - k]) * prices[i - k];
            ans = Math.max(income, ans);
        }
        return ans;
    }
}
// @lc code=end
