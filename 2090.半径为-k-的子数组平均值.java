/*
 * @lc app=leetcode.cn id=2090 lang=java
 *
 * [2090] 半径为 k 的子数组平均值
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int[] getAverages(int[] nums, int k) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        if (nums.length < 2 * k + 1) {
            return ans;
        }
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i] + nums[i + k + 1];
        }
        sum += nums[k];
        ans[k] = (int) (sum / (2 * k + 1));
        for (int i = k + 1; i + k < nums.length; i++) {
            sum += nums[i + k] - nums[i - k - 1];
            ans[i] = (int) (sum / (2 * k + 1));
        }
        return ans;
    }
}
// @lc code=end
