/*
 * @lc app=leetcode.cn id=1423 lang=java
 *
 * [1423] 可获得的最大点数
 */

// @lc code=start
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int ans = 0;
        int sum = 0;
        int len = cardPoints.length;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        if (k == len) {
            return sum;
        }
        ans = sum; 
        for (int j = 1, i = k - j; j <= k; j++,i--) {
            sum += cardPoints[len - j];
            sum -= cardPoints[i];
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
// @lc code=end
